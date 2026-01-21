package net.happyspeed.swordish.events;

import net.happyspeed.swordish.Swordish;
import net.happyspeed.swordish.items.templates.SwordishBase;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@EventBusSubscriber(modid = Swordish.MODID)
public class AttackSwingListener {

    @SubscribeEvent
    public static void onAttackEntity(AttackEntityEvent event) {
        if (event.getTarget() instanceof LivingEntity living) {
            if (!living.hurtMarked) {
                //Applying hurt marked and testing for it prevents infinity recursion
                //No side effects detected?
                handleAttackSwing(event.getEntity());
            }
        }
    }

    @SubscribeEvent
    public static void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
        handleAttackSwing(event.getEntity());
    }

    public static void handleAttackSwing(Player player) {
        if (player.level().isClientSide()) return;

        if (player instanceof ServerPlayer serverPlayer) {

            if (serverPlayer.getMainHandItem().getItem() instanceof SwordishBase swordishBase) {
                swordishBase.onSwing(player, serverPlayer.level());
            }
        }
    }
}
