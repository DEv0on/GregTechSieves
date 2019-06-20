package gregtechsieves.recipes;

import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;

public class RecipeMaps {
  public static final RecipeMap<SimpleRecipeBuilder> SIEVE_RECIPES = sieveRecipes();

  private static RecipeMap<SimpleRecipeBuilder> sieveRecipes() {
    int inputs = 2;
    int minOutputs = 1;
    int maxOutputs = 54;
    int fluids = 0;
    return new SieveRecipeMap(
      "electric_sieve",
      inputs,
      inputs,
      minOutputs,
      maxOutputs,
      fluids,
      fluids,
      fluids,
      fluids,
      new SimpleRecipeBuilder()
    ).setProgressBar(
      GuiTextures.PROGRESS_BAR_SIFT,
      ProgressWidget.MoveType.HORIZONTAL
    );
  }
}