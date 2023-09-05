package com.kemokemo.rapid_firing_bow;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
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

    // Wood bow
    //  3 arrows, very slow firing speed, very low durability
    public static final int RapidFiringWoodBow_Durability = 100;
    public static final int RapidFiringWoodBow_MaxShootTimes = 3;
    public static final int RapidFiringWoodBow_IntervalFrames = 50;
    public static final Tier RapidFiringWoodBow_Tier = new ForgeTier (2,250,6.0F,2.0F,
            30, BlockTags.NEEDS_STONE_TOOL, () -> Ingredient.of(ItemTags.PLANKS)
    );

    // Iron bow
    //  5 arrows, slow firing speed, middle durability
    public static final int RapidFiringIronBow_Durability = 350;
    public static final int RapidFiringIronBow_MaxShootTimes = 5;
    public static final int RapidFiringIronBow_IntervalFrames = 35;
    public static final Tier RapidFiringIronBow_Tier = new ForgeTier (2,250,6.0F,2.0F,
            50, BlockTags.NEEDS_STONE_TOOL, () -> Ingredient.of(Items.IRON_INGOT)
    );

    // Amethyst bow
    //  7 arrows, very quick firing speed, low durability
    public static final int RapidFiringAmethystBow_Durability = 200;
    public static final int RapidFiringAmethystBow_MaxShootTimes = 7;
    public static final int RapidFiringAmethystBow_IntervalFrames = 15;
    public static final Tier RapidFiringAmethystBow_Tier = new ForgeTier (2,250,6.0F,2.0F,
            70, BlockTags.NEEDS_STONE_TOOL, () -> Ingredient.of(Items.AMETHYST_SHARD)
    );

    // Diamond bow
    //  10 arrows, quick firing speed, high durability
    public static final int RapidFiringDiamondBow_Durability = 500;
    public static final int RapidFiringDiamondBow_MaxShootTimes = 10;
    public static final int RapidFiringDiamondBow_IntervalFrames = 25;
    public static final Tier RapidFiringDiamondBow_Tier = new ForgeTier (2,250,6.0F,2.0F,
            90, BlockTags.NEEDS_STONE_TOOL, () -> Ingredient.of(Items.DIAMOND)
    );
}
