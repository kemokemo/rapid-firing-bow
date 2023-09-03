package com.kemokemo.rapid_firing_bow;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = RapidFiringBowMod.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BowModelEventHandler
{
    @SubscribeEvent
    public static void setModelProperties(FMLClientSetupEvent event)
    {
        BowUtils.setupBowModelProperties(RapidFiringBowMod.RAPID_FIRING_WOOD_BOW.get());
    }
}
