package dev.enemeez.bionics.common.registries

import net.minecraft.world.food.FoodProperties

object ModFoods {
    val suspiciousMeat = FoodProperties.Builder()
        .nutrition(3)
        .saturationMod(0.3F)
        .meat()
        .build()
}
