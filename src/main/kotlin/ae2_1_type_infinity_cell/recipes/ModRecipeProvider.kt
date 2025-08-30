package ae2_1_type_infinity_cell.recipes

import ae2_1_type_infinity_cell.items.A1TICItems
import appeng.core.definitions.AEBlocks
import appeng.core.definitions.AEItems
import net.minecraft.data.PackOutput
import net.minecraft.data.recipes.FinishedRecipe
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.RecipeProvider
import net.minecraft.data.recipes.ShapedRecipeBuilder
import net.minecraft.data.recipes.ShapelessRecipeBuilder
import net.minecraft.world.item.Items
import java.util.function.Consumer

class ModRecipeProvider(output: PackOutput) : RecipeProvider(output) {
    override fun buildRecipes(consumer: Consumer<FinishedRecipe>) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, A1TICItems.INFINITY_CELL_COMPONENT.get())
            .pattern("EFE")
            .pattern("FCF")
            .pattern("EFE")
            .define('E', Items.ENDER_EYE)
            .define('F', AEItems.FLUIX_CRYSTAL)
            .define('C', AEItems.ITEM_CELL_1K)
            .unlockedBy("has_charged_fluix_crystal", has(AEItems.CERTUS_QUARTZ_CRYSTAL_CHARGED))
            .save(consumer)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, A1TICItems.INFINITY_CELL_HOUSING.get())
            .pattern("QEQ")
            .pattern("EPE")
            .pattern("IDI")
            .define('I', Items.IRON_INGOT)
            .define('E', Items.ENDER_PEARL)
            .define('P', AEItems.FLUIX_PEARL)
            .define('F', Items.DIAMOND)
            .define('Q', AEBlocks.QUARTZ_GLASS)
            .unlockedBy("has_fluix_pearl", has(AEItems.FLUIX_PEARL))
            .save(consumer)

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, A1TICItems.INFINITY_CELL.get())
            .requires(A1TICItems.INFINITY_CELL_COMPONENT.get())
            .requires(A1TICItems.INFINITY_CELL_HOUSING.get())
            .unlockedBy("has_infinity_cell_component", has(A1TICItems.INFINITY_CELL_COMPONENT.get()))
            .save(consumer)
    }
}
