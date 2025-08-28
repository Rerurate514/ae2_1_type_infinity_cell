package ae2_1_type_infinity_cell.items.cells

import appeng.api.config.FuzzyMode
import appeng.api.stacks.AEKeyType
import appeng.api.storage.cells.IBasicCellItem
import appeng.api.storage.cells.ICellWorkbenchItem
import net.minecraft.network.chat.Component
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.TooltipFlag
import net.minecraft.world.level.Level
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.api.distmarker.OnlyIn

class InfinityStorageCell(
    properties: Properties,
    val _idleDrain: Double,
    val _keyType: AEKeyType
) : Item(properties), IBasicCellItem, ICellWorkbenchItem {
    override fun getKeyType(): AEKeyType? = _keyType;
    override fun getBytes(p0: ItemStack?): Int = Int.MAX_VALUE;
    override fun getBytesPerType(p0: ItemStack?): Int = Int.MAX_VALUE;
    override fun getTotalTypes(p0: ItemStack?): Int = 1;
    override fun getIdleDrain(): Double = _idleDrain;

    override fun getFuzzyMode(p0: ItemStack?): FuzzyMode? {
        val fz = p0!!.orCreateTag.getString("FuzzyMode")
        return if (fz.isEmpty()) {
            FuzzyMode.IGNORE_ALL
        } else try {
            FuzzyMode.valueOf(fz)
        } catch (t: Throwable) {
            FuzzyMode.IGNORE_ALL
        }
    }

    override fun setFuzzyMode(p0: ItemStack?, p1: FuzzyMode?) {
        p0!!.orCreateTag.putString("FuzzyMode", p1!!.name)
    }

    @OnlyIn(Dist.CLIENT)
    override fun appendHoverText(
        stack: ItemStack?,
        level: Level?,
        lines: MutableList<Component?>,
        advancedTooltips: TooltipFlag?
    ) {
        addCellInformationToTooltip(stack, lines)
    }
}