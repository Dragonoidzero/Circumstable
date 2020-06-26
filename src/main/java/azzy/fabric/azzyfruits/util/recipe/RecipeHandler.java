package azzy.fabric.azzyfruits.util.recipe;

import net.minecraft.block.entity.BlockEntity;

public abstract class RecipeHandler<T> {

    protected String id;

    public RecipeHandler(String id){
        this.id = id;
    }

    public abstract FFRecipe search(T... args);

    public abstract boolean matches(FFRecipe recipe, BlockEntity entity);

    public abstract boolean valid(FFRecipe recipe);

    public abstract void craft(FFRecipe recipe, BlockEntity entity);

}