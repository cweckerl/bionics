package dev.enemeez.bionics.common

import com.mojang.logging.LogUtils
import dev.enemeez.bionics.common.registries.ModBlocks
import dev.enemeez.bionics.common.registries.ModItems
import dev.enemeez.bionics.common.registries.ModLootModifiers
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.ItemStack
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.event.CreativeModeTabEvent
import net.minecraftforge.event.CreativeModeTabEvent.BuildContents
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(Bionics.MOD_ID)
object Bionics {
    const val MOD_ID = "bionics"
    private val LOG = LogUtils.getLogger()

    init {
        ModItems.itemRegister.register(MOD_BUS)
        ModBlocks.blockRegister.register(MOD_BUS)

        ModLootModifiers.globalLootModifierRegister.register(MOD_BUS)

        MinecraftForge.EVENT_BUS.register(this)
        MOD_BUS.addListener(this::registerTab)
        MOD_BUS.addListener(this::addCreative)
        LOG.info("$MOD_ID setup complete!")
    }

    private fun addCreative(event: BuildContents) {
        if (event.tab.iconItem.item == ModItems.stomach.get()) {
            ModItems.list.forEach(event::accept)
        }
    }

    private fun registerTab(event: CreativeModeTabEvent.Register) {
        event.registerCreativeModeTab(ResourceLocation(MOD_ID, "creative_tab")) {
            it.title(Component.translatable("item_group.$MOD_ID"))
                .icon { ItemStack(ModItems.stomach.get()) }
                .build()
        }
    }
}
