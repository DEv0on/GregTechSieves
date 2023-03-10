package gregtechsieves;

import gregtechsieves.machines.Sieves;
import gregtechsieves.recipes.MachineRecipes;
import gregtechsieves.recipes.SievingRecipes;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

@Mod(
  modid = GregTechSieves.MOD_ID,
  name = GregTechSieves.NAME,
  version = GregTechSieves.VERSION
)
public class GregTechSieves {
  public static final String MOD_ID = "gregtechsieves";
  public static final String NAME = "GregTechSieves";
  public static final String VERSION = "@VERSION@";

  @EventHandler
  public void init(FMLInitializationEvent event) {
    Sieves.init();
    MachineRecipes.init();
  }

  @EventHandler
  public void postInit(FMLPostInitializationEvent event) {
    SievingRecipes.postInit();
  }

  @Config(modid = GregTechSieves.MOD_ID)
  public static class GregTechSievesConfig {

    @Config.Comment("Value multiplied by machine tier added to drop chance when sieving.")
    @Config.Name("chancePerTier")
    public static double chancePerTier = 0.5;
  }
}