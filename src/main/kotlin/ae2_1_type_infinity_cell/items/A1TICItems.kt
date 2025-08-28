package ae2_1_type_infinity_cell.items

import ae2_1_type_infinity_cell.Ae2_1_type_infinity_cell
import ae2_1_type_infinity_cell.cores.A1TICText
import ae2_1_type_infinity_cell.items.cells.InfinityStorageCell
import appeng.api.stacks.AEKeyType
import appeng.items.materials.MaterialItem
import appeng.items.parts.PartItem
import appeng.items.parts.PartModelsHelper
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Rarity
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject


class A1TICItems {
    val TABS: DeferredRegister<CreativeModeTab?> = DeferredRegister.create<CreativeModeTab?>(
        Registries.CREATIVE_MODE_TAB,
        Ae2_1_type_infinity_cell.ID
    )

    val ITEMS: DeferredRegister<Item?> = DeferredRegister.create(
        ForgeRegistries.ITEMS,
        Ae2_1_type_infinity_cell.ID
    )

    fun initialize(bus: IEventBus?) {
        TABS.register(bus)
        ITEMS.register(bus)
    }

    companion object {
        fun basic(): Item {
            return MaterialItem(properties())
        }

        fun properties(): Item.Properties {
            return Item.Properties()
        }
    }

    val CREATIVE_TAB: RegistryObject<CreativeModeTab?> = TABS.register(
        "main",
        {
            CreativeModeTab.builder()
                .title(Component.translatable(A1TICText.TITLE))
                .icon { INFINITY_CELL?.let { ItemStack(it.get()) } } // アイコンをInfinityCellに設定
                .displayItems { _, output ->
                    for (entry in ITEMS.entries) {
                        output.accept(entry.get())
                    }
                }
                .build()
        })
    
    val INFINITY_CELL_HOUSING: RegistryObject<Item?> = ITEMS.register(
        A1TICText.INFINITY_CELL_HOUSING,
        { A1TICItems.basic() }
    )
    
    val INFINITY_CELL: RegistryObject<Item?>? = ITEMS.register(
        A1TICText.INFINITY_CELL,
    {
        InfinityStorageCell(
            properties().stacksTo(1).rarity(Rarity.EPIC),
            0.0,
            _keyType = AEKeyType.items()
        )
    })
}
