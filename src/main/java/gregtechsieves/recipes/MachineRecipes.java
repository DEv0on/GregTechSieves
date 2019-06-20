package gregtechsieves.recipes;

import gregtech.loaders.recipe.CraftingComponent;
import gregtech.loaders.recipe.MetaTileEntityLoader;
import gregtechsieves.machines.Sieves;

public class MachineRecipes {
  public static void init() {
    MetaTileEntityLoader.registerMachineRecipe(
        Sieves.SIEVES,
        "CPC",
        "VHV",
        "BPB",
        'C', CraftingComponent.CIRCUIT,
        'P', CraftingComponent.PLATE,
        'V', CraftingComponent.CONVEYOR,
        'H', CraftingComponent.HULL,
        'B', CraftingComponent.CABLE
    );
  }
}