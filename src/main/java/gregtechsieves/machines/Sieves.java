package gregtechsieves.machines;

import gregtech.api.GregTechAPI;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.render.Textures;
import gregtechsieves.GregTechSieves;
import gregtechsieves.recipes.RecipeMaps;
import net.minecraft.util.ResourceLocation;

import java.util.Arrays;
import java.util.List;

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
            "uv",
            "max"
    );
    public static SMMTE[] SIEVES = new SMMTE[tierNames.size()];
    public static SteamSievingMachine STEAM_SIEVE = null;

    public static void init() {
        Sieves.STEAM_SIEVE = (SteamSievingMachine) GregTechAPI.registerMetaTileEntity(
                2749,
                (MetaTileEntity) new SteamSievingMachine(resourceLocationFromName("sieve.steam"),
                        RecipeMaps.SIEVE_RECIPES,
                        Textures.SIFTER_OVERLAY,
                        false
                ));
        for (int i = 0; i < tierNames.size(); i++) {
            String name = "sieve." + tierNames.get(i);
            SIEVES[i] = registerSieve(name, i + startingTier);
        }
    }

    private static SMMTE registerSieve(String name, int tier) {
        return GregTechAPI.registerMetaTileEntity(
                2749 + tier,
                createSampleMachineMetaTileEntity(name, tier)
        );
    }

    private static SMMTE createSampleMachineMetaTileEntity(String name, int tier) {
        return new SMMTE(
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