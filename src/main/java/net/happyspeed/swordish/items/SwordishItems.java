package net.happyspeed.swordish.items;

import net.happyspeed.swordish.Swordish;
import net.happyspeed.swordish.items.templates.DualbladeItem;
import net.happyspeed.swordish.items.templates.GlaiveItem;
import net.happyspeed.swordish.items.templates.HalberdItem;
import net.happyspeed.swordish.items.templates.SwordishBase;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SwordishItems {

    public static final float HALBERDSPEED = -3.3f;
    public static final float HALBERDATTACK = 5.0f;

    public static final float GLAIVESPEED = -2.4f;
    public static final float GLAIVEATTACK = 2.0f;

    public static final float DUALBLADESPEED = -2.2f;
    public static final float DUALBLADEATTACK = 3.0f;



    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Swordish.MODID);





    public static final DeferredItem<HalberdItem> GOLDEN_HALBERD =
            ITEMS.register("golden_halberd",
                    () -> new HalberdItem(
                            Tiers.GOLD,
                            new Item.Properties()
                                    .stacksTo(1).attributes(HalberdItem.createAttributes(Tiers.GOLD,HALBERDATTACK, HALBERDSPEED))

                    )
            );

    public static final DeferredItem<GlaiveItem> GOLDEN_GLAIVE =
            ITEMS.register("golden_glaive",
                    () -> new GlaiveItem(
                            Tiers.GOLD,
                            new Item.Properties()
                                    .stacksTo(1).attributes(GlaiveItem.createAttributes(Tiers.GOLD,GLAIVEATTACK, GLAIVESPEED))

                    )
            );

    public static final DeferredItem<DualbladeItem> GOLDEN_DUALBLADE =
            ITEMS.register("golden_dualblade",
                    () -> new DualbladeItem(
                            Tiers.GOLD,
                            new Item.Properties()
                                    .stacksTo(1).attributes(DualbladeItem.createAttributes(Tiers.GOLD,DUALBLADEATTACK, DUALBLADESPEED))

                    )
            );



    public static final DeferredItem<HalberdItem> STONE_HALBERD =
            ITEMS.register("stone_halberd",
                    () -> new HalberdItem(
                            Tiers.STONE,
                            new Item.Properties()
                                    .stacksTo(1).attributes(HalberdItem.createAttributes(Tiers.STONE,HALBERDATTACK, HALBERDSPEED))

                    )
            );

    public static final DeferredItem<GlaiveItem> STONE_GLAIVE =
            ITEMS.register("stone_glaive",
                    () -> new GlaiveItem(
                            Tiers.STONE,
                            new Item.Properties()
                                    .stacksTo(1).attributes(GlaiveItem.createAttributes(Tiers.STONE,GLAIVEATTACK, GLAIVESPEED))

                    )
            );

    public static final DeferredItem<DualbladeItem> STONE_DUALBLADE =
            ITEMS.register("stone_dualblade",
                    () -> new DualbladeItem(
                            Tiers.STONE,
                            new Item.Properties()
                                    .stacksTo(1).attributes(DualbladeItem.createAttributes(Tiers.STONE,DUALBLADEATTACK, DUALBLADESPEED))

                    )
            );





    public static final DeferredItem<HalberdItem> IRON_HALBERD =
            ITEMS.register("iron_halberd",
                    () -> new HalberdItem(
                            Tiers.IRON,
                            new Item.Properties()
                                    .stacksTo(1).attributes(HalberdItem.createAttributes(Tiers.IRON,HALBERDATTACK, HALBERDSPEED))

                    )
            );

    public static final DeferredItem<GlaiveItem> IRON_GLAIVE =
            ITEMS.register("iron_glaive",
                    () -> new GlaiveItem(
                            Tiers.IRON,
                            new Item.Properties()
                                    .stacksTo(1).attributes(GlaiveItem.createAttributes(Tiers.IRON,GLAIVEATTACK, GLAIVESPEED))

                    )
            );

    public static final DeferredItem<DualbladeItem> IRON_DUALBLADE =
            ITEMS.register("iron_dualblade",
                    () -> new DualbladeItem(
                            Tiers.IRON,
                            new Item.Properties()
                                    .stacksTo(1).attributes(DualbladeItem.createAttributes(Tiers.IRON,DUALBLADEATTACK, DUALBLADESPEED))

                    )
            );


    public static final DeferredItem<HalberdItem> DIAMOND_HALBERD =
            ITEMS.register("diamond_halberd",
                    () -> new HalberdItem(
                            Tiers.DIAMOND,
                            new Item.Properties()
                                    .stacksTo(1).attributes(HalberdItem.createAttributes(Tiers.DIAMOND,HALBERDATTACK, HALBERDSPEED))

                    )
            );

    public static final DeferredItem<GlaiveItem> DIAMOND_GLAIVE =
            ITEMS.register("diamond_glaive",
                    () -> new GlaiveItem(
                            Tiers.DIAMOND,
                            new Item.Properties()
                                    .stacksTo(1).attributes(GlaiveItem.createAttributes(Tiers.DIAMOND,GLAIVEATTACK, GLAIVESPEED))

                    )
            );

    public static final DeferredItem<DualbladeItem> DIAMOND_DUALBLADE =
            ITEMS.register("diamond_dualblade",
                    () -> new DualbladeItem(
                            Tiers.DIAMOND,
                            new Item.Properties()
                                    .stacksTo(1).attributes(DualbladeItem.createAttributes(Tiers.DIAMOND,DUALBLADEATTACK, DUALBLADESPEED))

                    )
            );



    public static final DeferredItem<HalberdItem> NETHERITE_HALBERD =
            ITEMS.register("netherite_halberd",
                    () -> new HalberdItem(
                            Tiers.NETHERITE,
                            new Item.Properties()
                                    .stacksTo(1).attributes(HalberdItem.createAttributes(Tiers.NETHERITE,HALBERDATTACK, HALBERDSPEED))

                    )
            );

    public static final DeferredItem<GlaiveItem> NETHERITE_GLAIVE =
            ITEMS.register("netherite_glaive",
                    () -> new GlaiveItem(
                            Tiers.NETHERITE,
                            new Item.Properties()
                                    .stacksTo(1).attributes(GlaiveItem.createAttributes(Tiers.NETHERITE,GLAIVEATTACK, GLAIVESPEED))

                    )
            );

    public static final DeferredItem<DualbladeItem> NETHERITE_DUALBLADE =
            ITEMS.register("netherite_dualblade",
                    () -> new DualbladeItem(
                            Tiers.NETHERITE,
                            new Item.Properties()
                                    .stacksTo(1).attributes(DualbladeItem.createAttributes(Tiers.NETHERITE,DUALBLADEATTACK, DUALBLADESPEED))

                    )
            );


    public static final DeferredItem<HalberdItem> WOODEN_HALBERD =
            ITEMS.register("wooden_halberd",
                    () -> new HalberdItem(
                            Tiers.WOOD,
                            new Item.Properties()
                                    .stacksTo(1).attributes(HalberdItem.createAttributes(Tiers.WOOD,HALBERDATTACK, HALBERDSPEED))

                    )
            );

    public static final DeferredItem<GlaiveItem> WOODEN_GLAIVE =
            ITEMS.register("wooden_glaive",
                    () -> new GlaiveItem(
                            Tiers.WOOD,
                            new Item.Properties()
                                    .stacksTo(1).attributes(GlaiveItem.createAttributes(Tiers.WOOD,GLAIVEATTACK, GLAIVESPEED))

                    )
            );

    public static final DeferredItem<DualbladeItem> WOODEN_DUALBLADE =
            ITEMS.register("wooden_dualblade",
                    () -> new DualbladeItem(
                            Tiers.WOOD,
                            new Item.Properties()
                                    .stacksTo(1).attributes(DualbladeItem.createAttributes(Tiers.WOOD,DUALBLADEATTACK, DUALBLADESPEED))

                    )
            );
}
