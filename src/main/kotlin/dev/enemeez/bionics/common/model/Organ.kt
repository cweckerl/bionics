package dev.enemeez.bionics.common.model

import dev.enemeez.bionics.common.registries.ModItems
import net.minecraft.util.RandomSource
import net.minecraft.world.item.Item

enum class Organ(private val item: Item) {
    BRAIN(ModItems.brain.get()),
    EYEBALL(ModItems.eyeball.get()),
    HEART(ModItems.heart.get()),
    LUNGS(ModItems.lungs.get()),
    STOMACH(ModItems.stomach.get());

    companion object {
        fun getRandomItem(rand: RandomSource) = values()[rand.nextInt(values().size)].item
    }
}
