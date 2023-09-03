package com.kemokemo.rapid_firing_bow;

import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(RapidFiringBowMod.MODID)
public class RapidFiringBowMod
{
    public static final String MODID = "rapid_firing_bow";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<Item> RAPID_FIRING_BOWS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    // If you add some awesome bows, please add this code block.
    public static final RegistryObject<Item> RAPID_FIRING_WOOD_BOW = RAPID_FIRING_BOWS.register("rapid_firing_wood_bow",
            () -> new RapidFiringBow(new Item.Properties().stacksTo(1).durability(Config.RapidFiringWoodBow_Durability),
                    Config.RapidFiringWoodBow_MaxShootTimes,
                    Config.RapidFiringWoodBow_IntervalFrames,
                    Config.RapidFiringWoodBow_Tier));

    public static final RegistryObject<CreativeModeTab> RAPID_FIRING_BOW_TAB = CREATIVE_MODE_TABS.register("rapid_firing_bow_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .title(Component.translatable("itemGroup.rapid_firing_bow"))
            .icon(() -> RAPID_FIRING_WOOD_BOW.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                for (var bow: RAPID_FIRING_BOWS.getEntries()) {
                    output.accept(bow.get());
                }
            }).build());

    public RapidFiringBowMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);

        RAPID_FIRING_BOWS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // If you have common setup task, add here.
    }

    // Add the items to this mod's tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.COMBAT){
            for (var bow: RAPID_FIRING_BOWS.getEntries()) {
                event.accept(bow);
            }
        }
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        // If you count and action, use this event.
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
        }
    }
}
