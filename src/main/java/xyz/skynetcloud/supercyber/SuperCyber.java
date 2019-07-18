package xyz.skynetcloud.supercyber;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import xyz.skynetcloud.supercyber.items.tools.ToolAxeBase;
import xyz.skynetcloud.supercyber.items.tools.ToolHoeBase;
import xyz.skynetcloud.supercyber.items.tools.ToolPickaxeBase;
import xyz.skynetcloud.supercyber.items.tools.ToolShovelBase;
import xyz.skynetcloud.supercyber.items.tools.ToolSwordBase;
import xyz.skynetcloud.supercyber.list.ArmourMaterialList;
import xyz.skynetcloud.supercyber.list.BlockInit;
import xyz.skynetcloud.supercyber.list.ItemList;
import xyz.skynetcloud.supercyber.list.ToolMaterialList;
import xyz.skynetcloud.supercyber.world.gen.OreGeneration;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("cx")
public class SuperCyber {

	public static SuperCyber instance;
	public static final String modid = "cx";
	public static final Logger logger = LogManager.getLogger(modid);

	public static final ItemGroup cybertab = new SuperCyberItemGroup();

	public SuperCyber() {

		instance = this;

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);

		MinecraftForge.EVENT_BUS.register(this);
	}

	private void setup(final FMLCommonSetupEvent event) {
		OreGeneration.setupOreGeneration();
		logger.info("Setup method registered.");

	}

	private void clientRegistries(final FMLClientSetupEvent event) {

		logger.info("clientRegistries method registered.");

	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class ModRegsitry {

		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			event.getRegistry().registerAll(

					ItemList.DARK_STEEL = new Item(new Item.Properties().group(SuperCyber.cybertab))
							.setRegistryName(location("dark_steel")),
					ItemList.RUBY = new Item(new Item.Properties().group(SuperCyber.cybertab))
							.setRegistryName(location("ruby")),
					ItemList.VIBRANIUM = new Item(new Item.Properties().group(SuperCyber.cybertab))
							.setRegistryName(location("vibranium")),

					ItemList.DARK_STEEL_AXE = new ToolAxeBase(ToolMaterialList.dark_steel, 3, 3,
							new Item.Properties().group(SuperCyber.cybertab))
									.setRegistryName(location("dark_steel_axe")),
					ItemList.DARK_STEEL_HOE = new ToolHoeBase(ToolMaterialList.dark_steel, 0,
							new Item.Properties().group(SuperCyber.cybertab))
									.setRegistryName(location("dark_steel_hoe")),
					ItemList.DARK_STEEL_PICKAXE = new ToolPickaxeBase(ToolMaterialList.dark_steel, 2, 5,
							new Item.Properties().group(SuperCyber.cybertab))
									.setRegistryName(location("dark_steel_pickaxe")),
					ItemList.DARK_STEEL_SHOVEL = new ToolShovelBase(ToolMaterialList.dark_steel, 3, 1,
							new Item.Properties().group(SuperCyber.cybertab))
									.setRegistryName(location("dark_steel_shovel")),
					ItemList.DARK_STEEL_SWORD = new ToolSwordBase(ToolMaterialList.dark_steel, 4, 4,
							new Item.Properties().group(SuperCyber.cybertab))
									.setRegistryName(location("dark_steel_sword")),

					ItemList.RUBY_AXE = new ToolAxeBase(ToolMaterialList.ruby, 5, 1,
							new Item.Properties().group(SuperCyber.cybertab)).setRegistryName(location("ruby_axe")),
					ItemList.RUBY_HOE = new ToolHoeBase(ToolMaterialList.ruby, 0,
							new Item.Properties().group(SuperCyber.cybertab)).setRegistryName(location("ruby_hoe")),
					ItemList.RUBY_PICKAXE = new ToolPickaxeBase(ToolMaterialList.ruby, 3, 1,
							new Item.Properties().group(SuperCyber.cybertab)).setRegistryName(location("ruby_pickaxe")),
					ItemList.RUBY_SHOVEL = new ToolShovelBase(ToolMaterialList.ruby, 0, 0,
							new Item.Properties().group(SuperCyber.cybertab)).setRegistryName(location("ruby_shovel")),
					ItemList.RUBY_SWORD = new ToolSwordBase(ToolMaterialList.ruby, 10, 5,
							new Item.Properties().group(SuperCyber.cybertab)).setRegistryName(location("ruby_sword")),

					ItemList.VIBRANIUM_AXE = new ToolAxeBase(ToolMaterialList.vibranium, 5, 5,
							new Item.Properties().group(SuperCyber.cybertab))
									.setRegistryName(location("vibranium_axe")),
					ItemList.VIBRANIUM_HOE = new ToolHoeBase(ToolMaterialList.vibranium, 0,
							new Item.Properties().group(SuperCyber.cybertab))
									.setRegistryName(location("vibranium_hoe")),
					ItemList.VIBRANIUM_PICKAXE = new ToolPickaxeBase(ToolMaterialList.vibranium, 5, 5,
							new Item.Properties().group(SuperCyber.cybertab))
									.setRegistryName(location("vibranium_pickaxe")),
					ItemList.VIBRANIUM_SHOVEL = new ToolShovelBase(ToolMaterialList.vibranium, 5, 5,
							new Item.Properties().group(SuperCyber.cybertab))
									.setRegistryName(location("vibranium_shovel")),
					ItemList.VIBRANIUM_SWORD = new ToolSwordBase(ToolMaterialList.vibranium, 15, 15,
							new Item.Properties().group(SuperCyber.cybertab))
									.setRegistryName(location("vibranium_sword")),

					ItemList.DARK_STEEL_BLOCK = new BlockItem(BlockInit.DARK_STEEL_BLOCK,
							new Item.Properties().group(cybertab))
									.setRegistryName(BlockInit.DARK_STEEL_BLOCK.getRegistryName()),
					ItemList.RUBY_BLOCK = new BlockItem(BlockInit.RUBY_BLOCK, new Item.Properties().group(cybertab))
							.setRegistryName(BlockInit.RUBY_BLOCK.getRegistryName()),
					ItemList.VIBRANIUM_BLOCK = new BlockItem(BlockInit.VIBRANIUM_BLOCK,
							new Item.Properties().group(cybertab))
									.setRegistryName(BlockInit.VIBRANIUM_BLOCK.getRegistryName()),

					ItemList.DARK_STEEL_HELMET = new ArmorItem(ArmourMaterialList.dark_steel, EquipmentSlotType.HEAD,
							new Item.Properties().group(cybertab)).setRegistryName(location("dark_steel_helmet")),
					ItemList.DARK_STEEL_CHESTPLATE = new ArmorItem(ArmourMaterialList.dark_steel,
							EquipmentSlotType.CHEST, new Item.Properties().group(cybertab))
									.setRegistryName(location("dark_steel_chestplate")),
					ItemList.DARK_STEEL_LEGGINGS = new ArmorItem(ArmourMaterialList.dark_steel, EquipmentSlotType.LEGS,
							new Item.Properties().group(cybertab)).setRegistryName(location("dark_steel_leggings")),
					ItemList.DARK_STEEL_BOOTS = new ArmorItem(ArmourMaterialList.dark_steel, EquipmentSlotType.FEET,
							new Item.Properties().group(cybertab)).setRegistryName(location("dark_steel_boots")),

					ItemList.RUBY_HELMET = new ArmorItem(ArmourMaterialList.ruby, EquipmentSlotType.HEAD,
							new Item.Properties().group(cybertab)).setRegistryName(location("ruby_helmet")),
					ItemList.RUBY_CHESTPLATE = new ArmorItem(ArmourMaterialList.ruby, EquipmentSlotType.CHEST,
							new Item.Properties().group(cybertab)).setRegistryName(location("ruby_chestplate")),
					ItemList.RUBY_LEGGINGS = new ArmorItem(ArmourMaterialList.ruby, EquipmentSlotType.LEGS,
							new Item.Properties().group(cybertab)).setRegistryName(location("ruby_leggings")),
					ItemList.RUBY_BOOTS = new ArmorItem(ArmourMaterialList.ruby, EquipmentSlotType.FEET,
							new Item.Properties().group(cybertab)).setRegistryName(location("ruby_boots")),

					ItemList.VIBRANIUM_HELMET = new ArmorItem(ArmourMaterialList.vibranium, EquipmentSlotType.HEAD,
							new Item.Properties().rarity(Rarity.EPIC).group(cybertab))
									.setRegistryName(location("vibranium_helmet")),
					ItemList.VIBRANIUM_CHESTPLATE = new ArmorItem(ArmourMaterialList.vibranium, EquipmentSlotType.CHEST,
							new Item.Properties().rarity(Rarity.EPIC).group(cybertab))
									.setRegistryName(location("vibranium_chestplate")),
					ItemList.VIBRANIUM_LEGGINGS = new ArmorItem(ArmourMaterialList.vibranium, EquipmentSlotType.LEGS,
							new Item.Properties().rarity(Rarity.EPIC).group(cybertab))
									.setRegistryName(location("vibranium_leggings")),
					ItemList.VIBRANIUM_BOOTS = new ArmorItem(ArmourMaterialList.vibranium, EquipmentSlotType.FEET,
							new Item.Properties().rarity(Rarity.EPIC).group(cybertab))
									.setRegistryName(location("vibranium_boots")),

					ItemList.NULL_HELEMT = new ArmorItem(ArmourMaterialList.null_stuff, EquipmentSlotType.HEAD,
							new Item.Properties().rarity(Rarity.UNCOMMON).group(cybertab))
									.setRegistryName(location("null_helmet")),
					ItemList.NULL_CHESTPLATE = new ArmorItem(ArmourMaterialList.null_stuff, EquipmentSlotType.CHEST,
							new Item.Properties().rarity(Rarity.UNCOMMON).group(cybertab))
									.setRegistryName(location("null_chestplate")),
					ItemList.NULL_LEGGINGS = new ArmorItem(ArmourMaterialList.null_stuff, EquipmentSlotType.LEGS,
							new Item.Properties().rarity(Rarity.UNCOMMON).group(cybertab))
									.setRegistryName(location("null_leggings")),
					ItemList.NULL_BOOTS = new ArmorItem(ArmourMaterialList.null_stuff, EquipmentSlotType.FEET,
							new Item.Properties().rarity(Rarity.UNCOMMON).group(cybertab))
									.setRegistryName(location("null_boots")),

					ItemList.DARK_STEEL_ORE = new BlockItem(BlockInit.DARK_STEEL_ORE,
							new Item.Properties().group(cybertab))
									.setRegistryName(BlockInit.DARK_STEEL_ORE.getRegistryName()),
					ItemList.RUBY_ORE = new BlockItem(BlockInit.RUBY_ORE, new Item.Properties().group(cybertab))
							.setRegistryName(BlockInit.RUBY_ORE.getRegistryName()),
					ItemList.VIBRANIUM_ORE = new BlockItem(BlockInit.VIBRANIUM_ORE,
							new Item.Properties().group(cybertab))
									.setRegistryName(BlockInit.VIBRANIUM_ORE.getRegistryName())

			);

			SuperCyber.logger.info("Items registered.");
		}

		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) {
			event.getRegistry().registerAll(

					BlockInit.RUBY_ORE = new Block(Block.Properties.create(Material.GOURD).hardnessAndResistance(0)
							.lightValue(0).sound(SoundType.GROUND)).setRegistryName(location("ruby_ore")),
					BlockInit.DARK_STEEL_ORE = new Block(Block.Properties.create(Material.GOURD)
							.hardnessAndResistance(0).lightValue(2).sound(SoundType.GROUND))
									.setRegistryName(location("dark_steel_ore")),
					BlockInit.VIBRANIUM_ORE = new Block(Block.Properties.create(Material.ROCK)
							.hardnessAndResistance(2.0f, 3.0f).lightValue(1).sound(SoundType.METAL))
									.setRegistryName(location("vibranium_ore")),
					BlockInit.DARK_STEEL_BLOCK = new Block(Block.Properties.create(Material.IRON)
							.hardnessAndResistance(2.0f, 3.0f).lightValue(5).sound(SoundType.METAL))
									.setRegistryName(location("dark_steel_block")),
					BlockInit.RUBY_BLOCK = new Block(Block.Properties.create(Material.IRON)
							.hardnessAndResistance(2.0f, 3.0f).lightValue(5).sound(SoundType.METAL))
									.setRegistryName(location("ruby_block")),
					BlockInit.VIBRANIUM_BLOCK = new Block(Block.Properties.create(Material.IRON)
							.hardnessAndResistance(2.0f, 3.0f).lightValue(5).sound(SoundType.METAL))
									.setRegistryName(location("vibranium_block")));
			logger.info("Blocks registered.");
		}

		private static ResourceLocation location(String name) {
			return new ResourceLocation(SuperCyber.modid, name);
		}
	}
}