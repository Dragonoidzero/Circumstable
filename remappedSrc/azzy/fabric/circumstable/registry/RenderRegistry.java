package azzy.fabric.circumstable.registry;

import azzy.fabric.circumstable.render.blockentity.gearbox.GearboxRenderer2x;
import azzy.fabric.circumstable.render.blockentity.gearbox.SteelGearbox2xRenderer;
import azzy.fabric.circumstable.render.blockentity.shaft.*;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;

import static azzy.fabric.circumstable.registry.BlockEntityRegistry.*;

public class RenderRegistry {

    private static final BlockEntityRendererRegistry INSTANCE = BlockEntityRendererRegistry.INSTANCE;

    public static void init() {
        INSTANCE.register(STEEL_SHAFT_ENTITY, SteelShaftRenderer::new);
        INSTANCE.register(GRANITE_SHAFT_ENTITY, GraniteShaftRenderer::new);
        INSTANCE.register(DIAMOND_SHAFT_ENTITY, DiamondShaftRenderer::new);
        INSTANCE.register(TUNGSTEN_SHAFT_ENTITY, TungstenShaftRenderer::new);
        INSTANCE.register(TITANIUM_SHAFT_ENTITY, TitaniumShaftRenderer::new);
        INSTANCE.register(STEEL_GEARBOX_ENTITY_2, SteelGearbox2xRenderer::new);
    }
}
