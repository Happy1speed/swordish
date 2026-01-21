package net.happyspeed.swordish.items.templates;

import net.happyspeed.swordish.Swordish;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.phys.Vec3;

import java.util.List;

import static net.minecraft.world.item.enchantment.EnchantmentHelper.doPostAttackEffectsWithItemSource;

public class DualbladeItem extends SwordishBase {
    public DualbladeItem(Tier tier, Properties properties) {
        super(tier, properties);
    }



    @Override
    public void onSwing(Player player, Level level) {

        if (player.getAttackStrengthScale(0.0f) < 0.5) {
            return;
        }

        double radius = player.getAttributeValue(Attributes.ENTITY_INTERACTION_RANGE);

        Vec3 look = player.getLookAngle().normalize();


        double dotThreshold = Math.cos(Math.toRadians(70));

        //get all living entities in a radius around the player, in front!
        List<LivingEntity> targets = level.getEntitiesOfClass(
                LivingEntity.class,
                player.getBoundingBox().inflate(radius, radius, radius),
                e -> e != player && e.isAlive()
        );

        boolean hasBeenDamaged = false;

        if (level instanceof ServerLevel serverLevel) {

            for (LivingEntity target : targets) {

                if (target instanceof ArmorStand) continue;
                if (target instanceof TamableAnimal tamable && tamable.isOwnedBy(player)) continue;


                if (!player.hasLineOfSight(target)) continue;

                double distanceSq = player.position().distanceToSqr(target.position());
                if (distanceSq > radius * radius) continue;


                Vec3 toTarget = target.position().subtract(player.position()).normalize();


                double dot = look.dot(toTarget);
                if (dot < dotThreshold) continue;


                target.hurtMarked = true;
                player.attack(target);

                if (!hasBeenDamaged) {
                    hasBeenDamaged = true;
                    this.stackDamage(player.getMainHandItem(), player);
                }

            }


            player.sweepAttack();

            level.playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.PLAYER_ATTACK_SWEEP, SoundSource.PLAYERS, 0.3F, 0.9F);
        }
    }


    public static ItemAttributeModifiers createAttributes(Tier tier, int attackDamage, float attackSpeed) {
        return createAttributes(tier, (float)attackDamage, attackSpeed);
    }

    public static ItemAttributeModifiers createAttributes(Tier p_330371_, float p_331976_, float p_332104_) {
        return ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, (double)(p_331976_ + p_330371_.getAttackDamageBonus()), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, (double)p_332104_, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build();
    }

}
