package bjornoid.chicken.wing.mod;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block WING_SAUCE_BOWL_BLOCK = registerBlock("wing_sauce_bowl_block",
            new WingSauceBowlBlock(AbstractBlock.Settings.of(Material.METAL, MapColor.STONE_GRAY).requiresTool()
                    .strength(2.0f).nonOpaque()),
            ModItemGroup.CHICKEN_WING_GROUP);

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier("chickenwingmod", name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        Item item = Registry.register(Registries.ITEM, new Identifier("chickenwingmod", name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return item;
    }

    public static void registerModBlocks() {
        ChickenWingMod.LOGGER.info("Registering ModBlocks for chickenwingmod");
    }
}
