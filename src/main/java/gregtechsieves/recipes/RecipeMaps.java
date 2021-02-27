package gregtechsieves.recipes;

import gregtech.api.GTValues;
import gregtech.api.gui.resources.TextureArea;
import gregtech.api.recipes.*;
import gregtech.api.recipes.builders.*;
import gregtech.api.gui.*;
import gregtech.api.gui.widgets.*;
import gregtech.common.metatileentities.steam.SteamMacerator;
import net.minecraft.util.ResourceLocation;

public class RecipeMaps
{
  public static final RecipeMap<SimpleRecipeBuilder> SIEVE_RECIPES;

  private static RecipeMap<SimpleRecipeBuilder> sieveRecipes() {
    final int inputs = 2;
    final int minOutputs = 1;
    final int maxOutputs = 54;
    final int fluids = 0;
    return (RecipeMap<SimpleRecipeBuilder>)new SieveRecipeMap("electric","sieve", inputs, inputs, minOutputs, maxOutputs, fluids, fluids, fluids, fluids, new SimpleRecipeBuilder()).setProgressBar(GuiTextures.PROGRESS_BAR_SIFT, ProgressWidget.MoveType.HORIZONTAL);
  }

  static {
    SIEVE_RECIPES = sieveRecipes();
  }
}
