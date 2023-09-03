package com.kemokemo.rapid_firing_bow;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RapidFiringBowMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    static ForgeConfigSpec SPEC = BUILDER.build();

    public static final int RapidFiringWoodBow_Durability = 100;
    public static final int RapidFiringWoodBow_MaxShootTimes = 3;
    public static final int RapidFiringWoodBow_IntervalFrames = 20;
    public static final Tier RapidFiringWoodBow_Tier = new ForgeTier (2,250,6.0F,2.0F,
            30, BlockTags.NEEDS_STONE_TOOL, () -> Ingredient.of(ItemTags.PLANKS)
    );
}
