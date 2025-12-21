package net.happyspeed.swordish.events;

import net.happyspeed.swordish.Swordish;
import net.happyspeed.swordish.items.templates.GlaiveItem;
import net.happyspeed.swordish.util.packets.AirSwingPacket;
import net.happyspeed.swordish.util.packets.AirSwingPacketHandler;
import net.happyspeed.swordish.util.packets.SwordishNetwork;
import net.happyspeed.swordish.util.tags.SwordishModTags;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.ItemAttributeModifierEvent;
import net.neoforged.neoforge.event.enchanting.EnchantmentLevelSetEvent;
import net.neoforged.neoforge.event.entity.player.CriticalHitEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

import java.util.UUID;

import static net.minecraft.world.item.Item.BASE_ATTACK_SPEED_ID;

@EventBusSubscriber(modid = Swordish.MODID)
public class SwordishEvents {

    @SubscribeEvent
    public static void onLeftClickEmpty(PlayerInteractEvent.LeftClickEmpty event) {
        if (event.getEntity().level().isClientSide()) {
            SwordishNetwork.sendToServer(new AirSwingPacket());
        }
    }

    @SubscribeEvent
    public static void registerPackets(RegisterPayloadHandlersEvent event) {

        PayloadRegistrar registrar = event.registrar("1.0");

        registrar.playToServer(
                AirSwingPacket.TYPE,
                AirSwingPacket.CODEC,
                AirSwingPacketHandler::handle
        );
    }







//    @SubscribeEvent
//    public static void onCriticalHit(CriticalHitEvent event) {
//        Player player = event.getEntity();
//        Entity target = event.getTarget();
//
//        if (event.isCriticalHit()) {
//            if (player.getMainHandItem().getItem() instanceof GlaiveItem glaiveItem) {
//                event.setDamageMultiplier(1.2f);
//            }
//        }
//    }


    @SubscribeEvent
    public static void onItemAttributes(ItemAttributeModifierEvent event) {
        ItemStack stack = event.getItemStack();

        // Only modify axes
        if (!(stack.getItem() instanceof AxeItem)) {
            return;
        }

        // Remove vanilla attack speed
        event.removeModifier(Attributes.ATTACK_SPEED, BASE_ATTACK_SPEED_ID);

        // Add your custom attack speed (MAINHAND only)
        event.addModifier(
                Attributes.ATTACK_SPEED,
                new AttributeModifier(BASE_ATTACK_SPEED_ID, -3.1, AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND
        );
    }



//
//    @SubscribeEvent
//    public static void onTooltip(ItemTooltipEvent event) {
//        ItemStack stack = event.getItemStack();
//
//
//    }


}
