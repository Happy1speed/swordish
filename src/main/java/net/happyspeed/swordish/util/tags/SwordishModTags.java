package net.happyspeed.swordish.util.tags;

import net.happyspeed.swordish.Swordish;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

public class SwordishModTags {
    public static class Items {
        public static final TagKey<Item> HALBERD = TagKey.create(
                Registries.ITEM,
                ResourceLocation.fromNamespaceAndPath(Swordish.MODID, "halberd")
        );

        public static final TagKey<Item> GLAIVE = TagKey.create(
                Registries.ITEM,
                ResourceLocation.fromNamespaceAndPath(Swordish.MODID, "glaive")
        );

        public static final TagKey<Item> DUALBLADE = TagKey.create(
                Registries.ITEM,
                ResourceLocation.fromNamespaceAndPath(Swordish.MODID, "dualblade")
        );
    }
}