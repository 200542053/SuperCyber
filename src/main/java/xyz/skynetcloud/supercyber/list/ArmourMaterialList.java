package xyz.skynetcloud.supercyber.list;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import xyz.skynetcloud.supercyber.SuperCyber;

public enum ArmourMaterialList implements IArmorMaterial
{
	
	dark_steel("dark_steel", 400, new int[] {8, 10, 9, 7}, 25, ItemList.DARK_STEEL, "entity.ender_dragon.growl", 0.0f),
	ruby("ruby", 500, new int[] {10, 15, 12, 10}, 35, ItemList.RUBY, "entity.ender_dragon.growl", 0.0f),
	vibranium("vibranium", 700, new int[] {15, 20, 15, 20}, 45, ItemList.VIBRANIUM, "entity.ender_dragon.growl", 0.0f ),
	null_stuff("null_stuff", 2000, new int[] {100, 100, 100, 100}, 100, Items.BEDROCK, "entity.ender_dragon.growl", 0.0f);
	
	private static final int[] max_damage_array = new int[]{13, 15, 16, 11};
	private String name, equipSound;
	private int durability, enchantability;
	private Item repairItem;
	private int[] damageReductionAmounts;
	private float toughness;
	
	
	
	private ArmourMaterialList(String name, int durability, int[] damageReductionAmounts, int enchantability, Item repairItem, String equipSound, float toughness) 
	{
		this.name = name;
		this.equipSound = equipSound;
		this.durability = durability;
		this.enchantability = enchantability;
		this.repairItem = repairItem;
		this.damageReductionAmounts = damageReductionAmounts;
		this.toughness = toughness;
		
		
		
	}


	@Override
	public int getDamageReductionAmount(EquipmentSlotType slot) 
	{
		return this.damageReductionAmounts[slot.getIndex()];
	}

	@Override
	public int getDurability(EquipmentSlotType slot) 
	{
		return max_damage_array[slot.getIndex()] * this.durability;
	}

	@Override
	public int getEnchantability() 
	{
		return this.enchantability;
	}

	@Override
	public String getName() 
	{
		return SuperCyber.modid + ":" + this.name;
	}

	@Override
	public Ingredient getRepairMaterial() 
	{
		return Ingredient.fromItems(this.repairItem);
	}

	@Override
	public SoundEvent getSoundEvent() 
	{
		return new SoundEvent(new ResourceLocation(equipSound));
	}

	@Override
	public float getToughness() 
	{
		return this.toughness;
	}
	
    

}