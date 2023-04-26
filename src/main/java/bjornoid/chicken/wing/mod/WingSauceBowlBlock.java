package bjornoid.chicken.wing.mod;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractCauldronBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.event.GameEvent;

/**
 * An empty cauldron block.
 */
public class WingSauceBowlBlock
        extends AbstractCauldronBlock {
    public WingSauceBowlBlock(AbstractBlock.Settings settings) {
        super(settings, CauldronBehavior.EMPTY_CAULDRON_BEHAVIOR);
    }

    @Override
    public boolean isFull(BlockState state) {
        return false;
    }

    protected static boolean canFillWithPrecipitation(World world, Biome.Precipitation precipitation) {
        if (precipitation == Biome.Precipitation.RAIN) {
            return world.getRandom().nextFloat() < 0.05f;
        }
        if (precipitation == Biome.Precipitation.SNOW) {
            return world.getRandom().nextFloat() < 0.1f;
        }
        return false;
    }

    @Override
    public void precipitationTick(BlockState state, World world, BlockPos pos, Biome.Precipitation precipitation) {
        if (precipitation == Biome.Precipitation.RAIN) {
            world.setBlockState(pos, Blocks.WATER_CAULDRON.getDefaultState());
            world.emitGameEvent(null, GameEvent.BLOCK_CHANGE, pos);
        } else if (precipitation == Biome.Precipitation.SNOW) {
            world.setBlockState(pos, Blocks.POWDER_SNOW_CAULDRON.getDefaultState());
            world.emitGameEvent(null, GameEvent.BLOCK_CHANGE, pos);
        }
    }

    @Override
    protected boolean canBeFilledByDripstone(Fluid fluid) {
        return true;
    }

    @Override
    protected void fillFromDripstone(BlockState state, World world, BlockPos pos, Fluid fluid) {
        if (fluid == Fluids.WATER) {
            BlockState blockState = Blocks.WATER_CAULDRON.getDefaultState();
            world.setBlockState(pos, blockState);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(blockState));
            world.syncWorldEvent(WorldEvents.POINTED_DRIPSTONE_DRIPS_WATER_INTO_CAULDRON, pos, 0);
        } else if (fluid == Fluids.LAVA) {
            BlockState blockState = Blocks.LAVA_CAULDRON.getDefaultState();
            world.setBlockState(pos, blockState);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(blockState));
            world.syncWorldEvent(WorldEvents.POINTED_DRIPSTONE_DRIPS_LAVA_INTO_CAULDRON, pos, 0);
        }
    }
}
