package gregtechsieves.recipes;

import exnihilocreatio.compatibility.jei.sieve.SieveRecipe;
import exnihilocreatio.registries.manager.ExNihiloRegistryManager;
import exnihilocreatio.registries.types.Siftable;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import net.minecraft.item.ItemStack;

public class SievingRecipes {
  public static void postInit() {
    for (SieveRecipe recipe : ExNihiloRegistryManager.SIEVE_REGISTRY.getRecipeList()) {
      for (ItemStack sievable : recipe.getSievables()) {
        ItemStack mesh = recipe.getMesh();
        SimpleRecipeBuilder builder = RecipeMaps.SIEVE_RECIPES.recipeBuilder()
                .notConsumable(mesh)
                .inputs(sievable)
                .duration(100)
                .EUt(4);
        for (Siftable siftable : ExNihiloRegistryManager.SIEVE_REGISTRY.getDrops(sievable)) {
          if (siftable.getMeshLevel() == mesh.getMetadata()) {
            builder.chancedOutput(
              siftable.getDrop().getItemStack(),
              floatChanceToIntChance(siftable.getChance()),
              100
            );

          }
        }
        builder.buildAndRegister();
      }
    }
  }

  private static int floatChanceToIntChance(float chance) {
    float getMaxChancedValueAsFloat = (float) Recipe.getMaxChancedValue();
    return (int) (chance * getMaxChancedValueAsFloat);
  }
}