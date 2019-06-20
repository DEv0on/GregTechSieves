package gregtechsieves;

import gregtechsieves.machines.Sieves;
import gregtechsieves.recipes.MachineRecipes;
import gregtechsieves.recipes.SievingRecipes;
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
  public static final String NAME = "GregTech Sieves";
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
}