package dev.enemeez.bionics.common.registries

import com.mojang.serialization.Codec
import dev.enemeez.bionics.common.Bionics
import dev.enemeez.bionics.common.data.VillageLootModifier
import net.minecraftforge.common.loot.IGlobalLootModifier
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries

object ModLootModifiers {
    val globalLootModifierRegister: DeferredRegister<Codec<out IGlobalLootModifier>> = DeferredRegister.create(
        ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Bionics.MOD_ID
    )

    val villager = globalLootModifierRegister.register<Codec<out IGlobalLootModifier>>("villager", VillageLootModifier.codec)
}
