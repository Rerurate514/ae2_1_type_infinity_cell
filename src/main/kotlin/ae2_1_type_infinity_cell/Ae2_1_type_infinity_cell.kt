package ae2_1_type_infinity_cell

import ae2_1_type_infinity_cell.items.A1TICItems
import net.minecraftforge.fml.common.Mod
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(Ae2_1_type_infinity_cell.ID)
class Ae2_1_type_infinity_cell {
    companion object {
        const val ID = "ae2_1_type_infinity_cell"
        val LOGGER: Logger = LogManager.getLogger(ID)
    }

    init {
        LOGGER.log(Level.INFO, "Hello world!")
        A1TICItems.initialize(MOD_BUS)
        MOD_BUS.register(ModDataGenerators::class.java)
    }
}
