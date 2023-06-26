package dev.enemeez.bionics.common.registries

import dev.enemeez.bionics.common.Bionics
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.ItemTags

object ModTags {
    val organs = ItemTags.create(ResourceLocation(Bionics.MOD_ID, "organs"))
}
