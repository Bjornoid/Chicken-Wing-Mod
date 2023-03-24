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
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        if (!world.isClient) {
            if (remainingUseTicks == 1) {
                user.setStackInHand(Hand.MAIN_HAND, new ItemStack(ModItems.WING_BONE));
            }
        }
        super.usageTick(world, user, stack, remainingUseTicks);
    }
}
