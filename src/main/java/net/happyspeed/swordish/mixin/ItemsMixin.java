package net.happyspeed.swordish.mixin;


import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(Items.class)
public class ItemsMixin {
    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/AxeItem;createAttributes(Lnet/minecraft/world/item/Tier;FF)Lnet/minecraft/world/item/component/ItemAttributeModifiers;", ordinal = 0), index = 1)
    private static float modifyAxeAttackWood(float par2) {
        return 5.0f;
    }

    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/AxeItem;createAttributes(Lnet/minecraft/world/item/Tier;FF)Lnet/minecraft/world/item/component/ItemAttributeModifiers;", ordinal = 1), index = 1)
    private static float modifyAxeAttackStone(float par2) {
        return 5.0f;
    }

    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/AxeItem;createAttributes(Lnet/minecraft/world/item/Tier;FF)Lnet/minecraft/world/item/component/ItemAttributeModifiers;", ordinal = 2), index = 1)
    private static float modifyAxeAttackGold(float par2) {
        return 5.0f;
    }

    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/AxeItem;createAttributes(Lnet/minecraft/world/item/Tier;FF)Lnet/minecraft/world/item/component/ItemAttributeModifiers;", ordinal = 3), index = 1)
    private static float modifyAxeAttackIron(float par2) {
        return 5.0f;
    }

    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/AxeItem;createAttributes(Lnet/minecraft/world/item/Tier;FF)Lnet/minecraft/world/item/component/ItemAttributeModifiers;", ordinal = 4), index = 1)
    private static float modifyAxeAttackDiamond(float par2) {
        return 5.0f;
    }

    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/AxeItem;createAttributes(Lnet/minecraft/world/item/Tier;FF)Lnet/minecraft/world/item/component/ItemAttributeModifiers;", ordinal = 5), index = 1)
    private static float modifyAxeAttackNetherite(float par2) {
        return 5.0f;
    }

}
