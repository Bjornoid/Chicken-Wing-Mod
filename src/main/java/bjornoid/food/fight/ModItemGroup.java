package bjornoid.food.fight;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup FOOD_FIGHT_GROUP = FabricItemGroup
            .builder(new Identifier("foodfight", "food_fight_items"))
            .icon(() -> new ItemStack(ModItems.CHICKEN_WING))
            .build();
}
