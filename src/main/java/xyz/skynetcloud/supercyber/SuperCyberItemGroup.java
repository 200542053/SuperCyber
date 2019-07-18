package xyz.skynetcloud.supercyber;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import xyz.skynetcloud.supercyber.list.ItemList;

public class SuperCyberItemGroup extends ItemGroup {

	
	public SuperCyberItemGroup() 
	{
		super("supercyber");
	}

	@Override
	public ItemStack createIcon() 
	{
		return new ItemStack(ItemList.DARK_STEEL);
	}
	
}
