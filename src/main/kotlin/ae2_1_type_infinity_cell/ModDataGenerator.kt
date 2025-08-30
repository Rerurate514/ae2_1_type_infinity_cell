package ae2_1_type_infinity_cell

import ae2_1_type_infinity_cell.recipes.ModRecipeProvider
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.eventbus.api.SubscribeEvent

@Mod.EventBusSubscriber(modid = Ae2_1_type_infinity_cell.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
object ModDataGenerators {
    @JvmStatic
    @SubscribeEvent
    fun gatherData(event: GatherDataEvent) {
        val generator = event.generator
        val packOutput = generator.packOutput

        generator.addProvider(event.includeServer(), ModRecipeProvider(packOutput))
    }
}
