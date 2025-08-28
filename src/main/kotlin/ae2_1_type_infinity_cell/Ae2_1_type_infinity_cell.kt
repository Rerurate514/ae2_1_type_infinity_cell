package ae2_1_type_infinity_cell

import ae2_1_type_infinity_cell.items.A1TICItems
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

@Mod(Ae2_1_type_infinity_cell.ID)
class Ae2_1_type_infinity_cell {
    companion object {
        const val ID = "ae2_1_type_infinity_cell"
        val LOGGER: Logger = LogManager.getLogger(ID)
    }

    init {
        LOGGER.log(Level.INFO, "Hello world!")
        val modEventBus: IEventBus = FMLJavaModLoadingContext.get().modEventBus

        A1TICItems().initialize(modEventBus)
    }
}