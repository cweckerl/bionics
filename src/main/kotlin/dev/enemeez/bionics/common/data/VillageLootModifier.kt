package dev.enemeez.bionics.common.data

import com.google.common.base.Suppliers
import com.mojang.serialization.Codec
import com.mojang.serialization.codecs.RecordCodecBuilder
import dev.enemeez.bionics.common.model.Organ
import it.unimi.dsi.fastutil.objects.ObjectArrayList
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.storage.loot.LootContext
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition
import net.minecraftforge.common.loot.IGlobalLootModifier
import net.minecraftforge.common.loot.LootModifier
import java.util.function.Supplier

class VillageLootModifier(conditions: Array<LootItemCondition>) : LootModifier(conditions) {

    override fun codec(): Codec<out IGlobalLootModifier> = codec.get()

    override fun doApply(generatedLoot: ObjectArrayList<ItemStack>, context: LootContext): ObjectArrayList<ItemStack> {
        generatedLoot.add(ItemStack(Organ.getRandomItem(context.random)))
        return generatedLoot
    }

    companion object {
        val codec: Supplier<Codec<VillageLootModifier>> = Suppliers.memoize {
            RecordCodecBuilder.create { codecStart(it).apply(it, ::VillageLootModifier) }
        }
    }
}
