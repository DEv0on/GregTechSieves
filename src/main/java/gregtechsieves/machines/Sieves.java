package gregtechsieves.machines;

import java.util.Arrays;
import java.util.List;

import gregtech.api.GregTechAPI;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.render.Textures;
import gregtechsieves.GregTechSieves;
import gregtechsieves.recipes.RecipeMaps;
import net.minecraft.util.ResourceLocation;

public class Sieves {
  public static int startingTier = 1;

  public static List<String> tierNames = Arrays.asList(
    "lv",
    "mv",
    "hv",
    "ev",
    "iv",
    "luv",
    "zpm",
    "uv"
  );
  public static SimpleMachineMetaTileEntity[] SIEVES = new SimpleMachineMetaTileEntity[tierNames.size()];

  public static void init() {
    for (int i = 0; i < tierNames.size(); i++) {
      String name = "sieve." + tierNames.get(i);
      SIEVES[i] = registerSieve(name, i + startingTier);
    }
  }

  private static SimpleMachineMetaTileEntity registerSieve(String name, int tier) {
    return GregTechAPI.registerMetaTileEntity(
        2749 + tier,
        createSampleMachineMetaTileEntity(name, tier)
      );
  }

  private static SimpleMachineMetaTileEntity createSampleMachineMetaTileEntity(String name, int tier) {
    return new SimpleMachineMetaTileEntity(
        resourceLocationFromName(name),
        RecipeMaps.SIEVE_RECIPES,
        Textures.SIFTER_OVERLAY,
        tier
    );
  }

  private static ResourceLocation resourceLocationFromName(String name) {
    return new ResourceLocation(GregTechSieves.MOD_ID, name);
  }
}