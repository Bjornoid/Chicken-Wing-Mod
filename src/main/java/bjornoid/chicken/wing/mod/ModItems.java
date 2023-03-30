package bjornoid.chicken.wing.mod;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
        public static final Item RAW_CHICKEN_WING = registerItem("raw_chicken_wing",
                        new ChickenWingItem(new FabricItemSettings().maxCount(1)
                                        .food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f)
                                                        .meat()
                                                        .build())));

        public static final Item CHICKEN_WING = registerItem("chicken_wing",
                        new ChickenWingItem(new FabricItemSettings().maxCount(1)
                                        .food(new FoodComponent.Builder().hunger(3).saturationModifier(1.2f).meat()
                                                        .build())));

        public static final Item SPICY_CHICKEN_WING = registerItem("spicy_chicken_wing",
                        new ChickenWingItem(new FabricItemSettings().maxCount(1)
                                        .food(new FoodComponent.Builder().hunger(4).saturationModifier(0.6f).meat()
                                                        .build())));

        public static final Item BBQ_CHICKEN_WING = registerItem("bbq_chicken_wing",
                        new ChickenWingItem(new FabricItemSettings().maxCount(1)
                                        .food(new FoodComponent.Builder().hunger(4).saturationModifier(0.6f).meat()
                                                        .build())));

        public static final Item HONEYBBQ_CHICKEN_WING = registerItem("honeybbq_chicken_wing",
                        new ChickenWingItem(new FabricItemSettings().maxCount(1)
                                        .food(new FoodComponent.Builder().hunger(5).saturationModifier(0.6f).meat()
                                                        .build())));

        public static final Item REDHOT = registerItem("redhot", new Item(new FabricItemSettings()));

        public static final Item GLASS_BOWL_FRAGMENT = registerItem("glass_bowl_fragment",
                        new Item(new FabricItemSettings()));

        public static final Item GLASS_BOWL = registerItem("glass_bowl", new Item(new FabricItemSettings()));

        public static final Item CHICKEN_WING_DIP = registerItem("chicken_wing_dip",
                        new ChickenWingItem(new FabricItemSettings()
                                        .food(new FoodComponent.Builder().hunger(14).saturationModifier(2.8f)
                                                        .alwaysEdible().build())));

        public static final Item DIAMOND_CHICKEN_WING_TOOL = registerItem("diamond_chicken_wing_tool",
                        new ChickenWingToolItem(ToolMaterials.DIAMOND, new FabricItemSettings()));

        private static Item registerItem(String name, Item item) {

                return Registry.register(Registries.ITEM, new Identifier("chickenwingmod", name), item);
        }

        public static void addItemsToItemGroup() {
                addToItemGroup(ModItemGroup.CHICKEN_WING_GROUP, RAW_CHICKEN_WING);
                addToItemGroup(ModItemGroup.CHICKEN_WING_GROUP, CHICKEN_WING);
                addToItemGroup(ModItemGroup.CHICKEN_WING_GROUP, SPICY_CHICKEN_WING);
                addToItemGroup(ModItemGroup.CHICKEN_WING_GROUP, BBQ_CHICKEN_WING);
                addToItemGroup(ModItemGroup.CHICKEN_WING_GROUP, HONEYBBQ_CHICKEN_WING);
                addToItemGroup(ModItemGroup.CHICKEN_WING_GROUP, REDHOT);
                addToItemGroup(ModItemGroup.CHICKEN_WING_GROUP, GLASS_BOWL_FRAGMENT);
                addToItemGroup(ModItemGroup.CHICKEN_WING_GROUP, GLASS_BOWL);
                addToItemGroup(ModItemGroup.CHICKEN_WING_GROUP, CHICKEN_WING_DIP);
                addToItemGroup(ModItemGroup.CHICKEN_WING_GROUP, DIAMOND_CHICKEN_WING_TOOL);
        }

        private static void addToItemGroup(ItemGroup group, Item item) {
                ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        }

        public static void registerModItems() {
                ChickenWingMod.LOGGER.debug("Registering Mod Items for chicken wing mod");

                addItemsToItemGroup();
        }
}
