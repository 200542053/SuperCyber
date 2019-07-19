package xyz.skynetcloud.supercyber.items.tools;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ToolAxeBase extends AxeItem {

	
	
	public ToolAxeBase(IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}


	@Override
	public int getBurnTime(ItemStack itemStack) {
		return 400;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		playerIn.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 25000, 0, false, false, true));
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
}
