package bjornoid.chicken.wing.mod;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item CHICKEN_WING = registerItem("chicken_wing",
            new ChickenWingItem(new FabricItemSettings().maxCount(1)
                    .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build())));

    public static final Item SPICY_CHICKEN_WING = registerItem("spicy_chicken_wing",
            new ChickenWingItem(new FabricItemSettings().maxCount(1)
                    .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build())));

    public static final Item BBQ_CHICKEN_WING = registerItem("bbq_chicken_wing",
            new ChickenWingItem(new FabricItemSettings().maxCount(1)
                    .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build())));

    public static final Item WING_BONE = registerItem("wing_bone", new Item(new FabricItemSettings()));

    public static final Item REDHOT = registerItem("redhot", new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {

        return Registry.register(Registries.ITEM, new Identifier("chickenwingmod", name), item);
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ModItemGroup.CHICKEN_WING_GROUP, CHICKEN_WING);
        addToItemGroup(ModItemGroup.CHICKEN_WING_GROUP, SPICY_CHICKEN_WING);
        addToItemGroup(ModItemGroup.CHICKEN_WING_GROUP, BBQ_CHICKEN_WING);
        addToItemGroup(ModItemGroup.CHICKEN_WING_GROUP, WING_BONE);
        addToItemGroup(ModItemGroup.CHICKEN_WING_GROUP, REDHOT);
    }

    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        ChickenWingMod.LOGGER.debug("Registering Mod Items for chicken wing mod");

        addItemsToItemGroup();
    }
}
