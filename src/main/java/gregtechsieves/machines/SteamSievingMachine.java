package gregtechsieves.machines;

import gregtechsieves.recipes.RecipeMaps;
import net.minecraft.util.*;
import gregtech.api.recipes.*;
import net.minecraftforge.items.*;
import gregtech.api.metatileentity.*;
import gregtechsieves.recipes.*;
import gregtech.api.render.*;
import net.minecraft.entity.player.*;
import gregtech.api.gui.resources.*;
import gregtech.api.gui.widgets.*;
import gregtech.api.gui.*;

public class SteamSievingMachine extends SteamMetaTileEntity
{
    private static final int PROGRESS_LEFT = 51;
    private static final int PROGRESS_TOP = 24;
    private static final int ITEM_SLOT_WITH_EDGE_DIMENSION = 18;
    private static final int OUTPUT_TOP = 17;
    private static final int OUTPUT_LEFT = 79;
    private static final int MESH_TOP = 26;
    private static final int MESH_LEFT = 7;
    private static final int INPUT_TOP = 26;
    private static final int INPUT_LEFT = 25;

    public SteamSievingMachine(final ResourceLocation metaTileEntityId, final RecipeMap<?> recipeMap, final OrientedOverlayRenderer renderer, final boolean isHighPressure) {
        super(metaTileEntityId, (RecipeMap)recipeMap, renderer, isHighPressure);
    }

    public IItemHandlerModifiable createImportItemHandler() {
        return (IItemHandlerModifiable)new ItemStackHandler(2);
    }

    public IItemHandlerModifiable createExportItemHandler() {
        return (IItemHandlerModifiable)new ItemStackHandler(57);
    }

    public MetaTileEntity createMetaTileEntity(final MetaTileEntityHolder holder) {
        return (MetaTileEntity)new SteamSievingMachine(this.metaTileEntityId, RecipeMaps.SIEVE_RECIPES, Textures.SIFTER_OVERLAY, this.isHighPressure);
    }

    protected ModularUI createUI(final EntityPlayer player) {
        final ResourceLocation txt = new ResourceLocation("gregtechsieves", "textures/gui/progress_bar/progress_bar_sift_bronze.png");
        final ResourceLocation txt1 = new ResourceLocation("gregtechsieves", "textures/gui/base/bronze_gui.png");

        final ModularUI.Builder builder = ModularUI.builder(new TextureArea(txt1,0.0D, 0.0D, 1.0D, 1.0D), 175, 230).bindPlayerInventory(player.inventory, this.BRONZE_SLOT_BACKGROUND_TEXTURE, 7, 150).widget((Widget)new LabelWidget(6, 6, this.getMetaFullName(), new Object[0])).widget((Widget)new SlotWidget(this.importItems, 0, 7, 26).setBackgroundTexture(new TextureArea[] { this.BRONZE_SLOT_BACKGROUND_TEXTURE })).widget((Widget)new SlotWidget(this.importItems, 1, 25, 26).setBackgroundTexture(new TextureArea[] { this.BRONZE_SLOT_BACKGROUND_TEXTURE })).widget(new ProgressWidget(this.workableHandler::getProgressPercent, PROGRESS_LEFT, PROGRESS_TOP, 20, 20, new TextureArea(txt,0.0D, 0.0D, 1.0D, 1.0D), ProgressWidget.MoveType.HORIZONTAL));
        builder.widget(new LabelWidget(8, 139,"Inventory:"));
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 9; ++j) {
                final int slotIndex = i * 9 + j;
                builder.widget((Widget)new SlotWidget((IItemHandler)this.exportItems, slotIndex, 7 + 18 * j, 47 + 18 * i, true, false).setBackgroundTexture(new TextureArea[] { this.BRONZE_SLOT_BACKGROUND_TEXTURE }));
            }
        }
        return builder.build((IUIHolder)this.getHolder(), player);
    }
}
