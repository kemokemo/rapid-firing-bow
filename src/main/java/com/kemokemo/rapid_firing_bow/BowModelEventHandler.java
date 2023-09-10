package com.kemokemo.rapid_firing_bow;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = RapidFiringBowMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BowModelEventHandler
{
    @SubscribeEvent
    public static void setModelProperties(FMLClientSetupEvent event)
    {
        // If you add some awesome bows, please add this code block.
        BowUtils.setupBowModelProperties(RapidFiringBowMod.RAPID_FIRING_WOOD_BOW.get());
        BowUtils.setupBowModelProperties(RapidFiringBowMod.RAPID_FIRING_IRON_BOW.get());
        BowUtils.setupBowModelProperties(RapidFiringBowMod.RAPID_FIRING_AMETHYST_BOW.get());
        BowUtils.setupBowModelProperties(RapidFiringBowMod.RAPID_FIRING_DIAMOND_BOW.get());
    }
}
