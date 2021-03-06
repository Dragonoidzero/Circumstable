package azzy.fabric.circumstable.render.blockentity.shaft;

import azzy.fabric.circumstable.render.blockentity.ShaftRenderer;
import azzy.fabric.circumstable.staticentities.blockentity.logistics.SteelShaftEntity;
import azzy.fabric.circumstable.staticentities.blockentity.logistics.TungstenShaftEntity;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.util.Identifier;

import static azzy.fabric.circumstable.Circumstable.MOD_ID;
import static azzy.fabric.circumstable.registry.ItemRegistry.STICK_TITANIUM;
import static azzy.fabric.circumstable.registry.ItemRegistry.STICK_TUNGSTEN;

public class TungstenShaftRenderer extends ShaftRenderer<TungstenShaftEntity> {

    public TungstenShaftRenderer(BlockEntityRenderDispatcher dispatcher) {
        super(dispatcher, new Identifier(MOD_ID, "textures/block/tungsten_block.png"));
    }
}
