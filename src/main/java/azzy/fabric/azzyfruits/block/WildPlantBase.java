package azzy.fabric.azzyfruits.block;

import jdk.nashorn.internal.ir.annotations.Ignore;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityContext;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.mob.RavagerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

import java.util.Random;

public class WildPlantBase extends PlantBlock {

    private ParticleEffect effects;
    private double flight;
    private int count;
    private String type;
    private StatusEffect[] touchEffects;
    public WildPlantBase(String type, Material material, BlockSoundGroup sound, ParticleEffect effects, double flight, int count, StatusEffect ... touchEffects){
        super(FabricBlockSettings.of(material).sounds(sound).breakInstantly().ticksRandomly().build().noCollision());
        this.effects = effects;
        this.flight = flight;
        this.count = count;
        this.type = type;
        this.touchEffects = touchEffects;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView view, BlockPos pos) {
        Block block = floor.getBlock();
        if(type != "cindermote" && type != "dracora" && type != "vompollolowm" && type != "protestar" && type != "moss berry" && type != "shimmerspark" && type != "haggstrom")
            return block == Blocks.GRASS_BLOCK || block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL || block == Blocks.FARMLAND;
        if(type == "cindermote")
            return block == Blocks.SOUL_SAND || block == Blocks.MAGMA_BLOCK;
        if(type == "dracora")
            return block == Blocks.END_STONE;
        if(type == "vompollolowm")
            return block == Blocks.STONE || block == Blocks.COBBLESTONE || block == Blocks.MOSSY_COBBLESTONE;
        if(type == "protestar")
            return block == Blocks.AIR;
        if(type == "moss berry")
            return block == Blocks.WATER || block == Blocks.SAND;
        if(type == "shimmerspark")
            return block == Blocks.STONE;
        if(type == "haggstrom")
            return block == Blocks.DARK_OAK_LOG;
        return false;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, EntityContext ctx) {
        return VoxelShapes.cuboid(0.2f, 0f, 0.2f, 0.9f, 0.8f, 0.8f);
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random){
        if(effects != null)
            world.spawnParticles(effects, (double) pos.getX()+Math.random(), (double) pos.getY()+(Math.random()/2), (double) pos.getZ()+Math.random(), (int) (Math.random()*5)+1+count, 0.1D, flight, 0.1D, 0.1D);
    }
}