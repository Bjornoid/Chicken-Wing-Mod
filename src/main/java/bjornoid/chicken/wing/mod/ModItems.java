package bjornoid.chicken.wing.mod;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RAW_CHICKEN_WING = registerItem("raw_chicken_wing",
            new ChickenWingItem(new FabricItemSettings().maxCount(1)
                    .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 0), 0.3f).meat()
                            .build())));

    public static final Item CHICKEN_WING = registerItem("chicken_wing",
            new ChickenWingItem(new FabricItemSettings().maxCount(1)
                    .food(new FoodComponent.Builder().hunger(3).saturationModifier(1.2f).meat().build())));

    public static final Item SPICY_CHICKEN_WING = registerItem("spicy_chicken_wing",
            new ChickenWingItem(new FabricItemSettings().maxCount(1)
                    .food(new FoodComponent.Builder().hunger(4).saturationModifier(0.6f).meat().build())));

    public static final Item BBQ_CHICKEN_WING = registerItem("bbq_chicken_wing",
            new ChickenWingItem(new FabricItemSettings().maxCount(1)
                    .food(new FoodComponent.Builder().hunger(4).saturationModifier(0.6f).meat().build())));

    public static final Item REDHOT = registerItem("redhot", new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {

        return Registry.register(Registries.ITEM, new Identifier("chickenwingmod", name), item);
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ModItemGroup.CHICKEN_WING_GROUP, RAW_CHICKEN_WING);
        addToItemGroup(ModItemGroup.CHICKEN_WING_GROUP, CHICKEN_WING);
        addToItemGroup(ModItemGroup.CHICKEN_WING_GROUP, SPICY_CHICKEN_WING);
        addToItemGroup(ModItemGroup.CHICKEN_WING_GROUP, BBQ_CHICKEN_WING);
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
