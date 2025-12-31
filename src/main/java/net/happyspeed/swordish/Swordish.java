package net.happyspeed.swordish;

import net.happyspeed.swordish.items.SwordishItems;
import net.neoforged.fml.ModList;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Swordish.MODID)
public class Swordish {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "swordish";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "swordish" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SWORDISH_TAB = CREATIVE_MODE_TABS.register("swordish_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.swordish")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> SwordishItems.GOLDEN_HALBERD.get().getDefaultInstance())
            .displayItems((parameters, output) -> {

                output.accept(SwordishItems.WOODEN_HALBERD.get().getDefaultInstance());
                output.accept(SwordishItems.WOODEN_GLAIVE.get().getDefaultInstance());
                output.accept(SwordishItems.WOODEN_DUALBLADE.get().getDefaultInstance());

                output.accept(SwordishItems.GOLDEN_HALBERD.get().getDefaultInstance());
                output.accept(SwordishItems.GOLDEN_GLAIVE.get().getDefaultInstance());
                output.accept(SwordishItems.GOLDEN_DUALBLADE.get().getDefaultInstance());

                output.accept(SwordishItems.STONE_HALBERD.get().getDefaultInstance());
                output.accept(SwordishItems.STONE_GLAIVE.get().getDefaultInstance());
                output.accept(SwordishItems.STONE_DUALBLADE.get().getDefaultInstance());

                output.accept(SwordishItems.IRON_HALBERD.get().getDefaultInstance());
                output.accept(SwordishItems.IRON_GLAIVE.get().getDefaultInstance());
                output.accept(SwordishItems.IRON_DUALBLADE.get().getDefaultInstance());

                output.accept(SwordishItems.DIAMOND_HALBERD.get().getDefaultInstance());
                output.accept(SwordishItems.DIAMOND_GLAIVE.get().getDefaultInstance());
                output.accept(SwordishItems.DIAMOND_DUALBLADE.get().getDefaultInstance());

                output.accept(SwordishItems.NETHERITE_HALBERD.get().getDefaultInstance());
                output.accept(SwordishItems.NETHERITE_GLAIVE.get().getDefaultInstance());
                output.accept(SwordishItems.NETHERITE_DUALBLADE.get().getDefaultInstance());

            }).build());




    public Swordish(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the Deferred Register to the mod event bus so blocks get registered
        SwordishItems.ITEMS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so tabs get registered
        CREATIVE_MODE_TABS.register(modEventBus);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        // Some common setup code
        //LOGGER.info("HELLO FROM COMMON SETUP");
    }
}
