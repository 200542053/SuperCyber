package xyz.skynetcloud.supercyber.world.gen;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;
import xyz.skynetcloud.supercyber.list.BlockInit;

public class OreGeneration {

	
	

	public static void setupOreGeneration()
	{
		for(Biome biome : ForgeRegistries.BIOMES)
		{
			CountRangeConfig ruby_ore = new CountRangeConfig(15, 10, 0, 25);
			biome.addFeature(Decoration.UNDERGROUND_ORES,  Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.RUBY_ORE.getDefaultState() , 5), Placement.COUNT_RANGE, ruby_ore));
		
			CountRangeConfig dark_steel_ore = new CountRangeConfig(10, 15, 0, 35);
			biome.addFeature(Decoration.UNDERGROUND_ORES,  Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.DARK_STEEL_ORE.getDefaultState(), 5), Placement.COUNT_RANGE, dark_steel_ore));
	
			CountRangeConfig vibranium_ore = new CountRangeConfig(1, 5, 0, 15);
			biome.addFeature(Decoration.UNDERGROUND_ORES,  Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.VIBRANIUM_ORE.getDefaultState(), 5), Placement.COUNT_RANGE, vibranium_ore));
		}
	}
}