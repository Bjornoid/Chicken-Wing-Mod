package bjornoid.chicken.wing.mod;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup CHICKEN_WING_GROUP = FabricItemGroup
            .builder(new Identifier("chickenwingmod", "chicken_wing_mod"))
            .icon(() -> new ItemStack(ModItems.CHICKEN_WING))
            .build();
}
