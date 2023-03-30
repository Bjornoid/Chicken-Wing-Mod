package bjornoid.chicken.wing.mod;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ChickenWingItem extends Item {
    public ChickenWingItem(Settings settings) {
        super(settings);
    }

    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        if (!world.isClient) {
            if (remainingUseTicks == 1) {
                if (stack.getName().equals(ModItems.RAW_CHICKEN_WING.getName())) {
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0));
                    user.setStackInHand(Hand.MAIN_HAND, new ItemStack(Items.BONE));
                } else if (stack.getName().equals(ModItems.CHICKEN_WING_DIP.getName())) {
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 1));
                    user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 0));
                    user.setStackInHand(Hand.MAIN_HAND, new ItemStack(ModItems.GLASS_BOWL));
                } else {
                    user.setStackInHand(Hand.MAIN_HAND, new ItemStack(Items.BONE));
                }
            }
        }
        super.usageTick(world, user, stack, remainingUseTicks);
    }

}
