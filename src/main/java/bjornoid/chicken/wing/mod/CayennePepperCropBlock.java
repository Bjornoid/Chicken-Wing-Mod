package bjornoid.chicken.wing.mod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.IntProperty;

public class CayennePepperCropBlock extends CropBlock {
    public static final IntProperty AGE = IntProperty.of("age", 0, 6);

    public CayennePepperCropBlock(Settings settings) {
        super(settings);

    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.CAYENNE_PEPPER_SEEDS;
    }

    @Override
    public int getMaxAge() {
        return 6;
    }

    @Override
    public IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    protected void appendProperties(Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
