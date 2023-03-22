package bjornoid.food.fight;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ChickenWingItem extends Item {
    public ChickenWingItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean isUsedOnRelease(ItemStack stack) {
        return true;
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (!world.isClient) {
            user.setStackInHand(Hand.MAIN_HAND, new ItemStack(ModItems.WING_BONE));
        }

        super.onStoppedUsing(stack, world, user, remainingUseTicks);
    }
}
