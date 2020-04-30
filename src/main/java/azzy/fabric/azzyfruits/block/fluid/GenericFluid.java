package azzy.fabric.azzyfruits.block.fluid;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.BaseFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.IWorld;
import net.minecraft.world.WorldView;

public abstract class GenericFluid extends BaseFluid {

    @Override
    public boolean matchesType(Fluid fluid)
    {
        return fluid == getStill() || fluid == getFlowing();
    }

    @Override
    protected boolean isInfinite()
    {
        return false;
    }

    @Override
    protected void beforeBreakingBlock(IWorld world, BlockPos pos, BlockState state)
    {
        final BlockEntity blockEntity = state.getBlock().hasBlockEntity() ? world.getBlockEntity(pos) : null;
        Block.dropStacks(state, world.getWorld(), pos, blockEntity);
    }

    @Override
    protected boolean canBeReplacedWith(FluidState fluidState, BlockView blockView, BlockPos blockPos, Fluid fluid, Direction direction)
    {
        return false;
    }

    @Override
    protected int method_15733(WorldView worldView)
    {
        return 3;
    }

    @Override
    protected int getLevelDecreasePerBlock(WorldView worldView)
    {
        return 1;
    }

    @Override
    public int getTickRate(WorldView worldView)
    {
        return 15;
    }

    @Override
    protected float getBlastResistance()
    {
        return 1000.0F;
    }
}
