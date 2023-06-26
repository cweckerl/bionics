package dev.enemeez.bionics.common.registries

import dev.enemeez.bionics.common.Bionics
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.ArmorItem
import net.minecraft.world.item.ArmorMaterials
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import java.util.LinkedList
import java.util.function.Supplier

object ModItems {

    val itemRegister: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, Bionics.MOD_ID)
    val list = LinkedList<RegistryObject<Item>>()

    val brain = registerItem("brain")
    val heart = registerItem("heart")
    val lungs = registerItem("lungs")
    val stomach = registerItem("stomach")
    val eyeball = registerItem("eyeball")

    val bionicBrain = registerItem("bionic_brain")
    val bionicHeart = registerItem("bionic_heart")
    val bionicLungs = registerItem("bionic_lungs")
    val bionicStomach = registerItem("bionic_stomach")
    val bionicEyeball = registerItem("bionic_eyeball")
    val bionicArm = registerItem("bionic_arm")
    val bionicLeg = registerItem("bionic_leg")

    val decayingBrain = registerItem("decaying_brain")
    val decayingHeart = registerItem("decaying_heart")
    val decayingLungs = registerItem("decaying_lungs")
    val decayingStomach = registerItem("decaying_stomach")
    val decayingEyeball = registerItem("decaying_eyeball")

    val tissue = registerItem("tissue")
    val surgicalMask = registerSurgicalMaskItem()
    val surgeonScrubs = registerSurgeonScrubsItem()

    val cutQuartz = registerItem("cut_quartz")
    val oscillator = registerItem("oscillator")
    val processor = registerItem("processor")
    val capacitor = registerItem("capacitor")
    val resistor = registerItem("resistor")

    // Titanium
    val titaniumOre = registerBlockItem("titanium_ore") { ModBlocks.titaniumOre.get() }
    val deepslateTitaniumOre = registerBlockItem("deepslate_titanium_ore") { ModBlocks.deepslateTitaniumOre.get() }
    val titaniumIngot = registerItem("titanium_ingot")

    private fun registerItem(name: String): RegistryObject<Item> {
        val item = itemRegister.register(name) { Item(Item.Properties()) }
        list.add(item)
        return item
    }

    private fun registerFoodItem(name: String, foodProperties: FoodProperties): RegistryObject<Item> {
        val item = itemRegister.register(name) { Item(Item.Properties().food(foodProperties)) }
        list.add(item)
        return item
    }

    private fun registerBlockItem(name: String, block: Supplier<Block>): RegistryObject<Item> {
        val item: RegistryObject<Item> = itemRegister.register(name) { BlockItem(block.get(), Item.Properties()) }
        list.add(item)
        return item
    }

    private fun registerSurgicalMaskItem(): RegistryObject<Item> {
        val item: RegistryObject<Item> = itemRegister.register("surgical_mask") {
            ArmorItem(ArmorMaterials.LEATHER, EquipmentSlot.HEAD, Item.Properties())
        }
        list.add(item)
        return item
    }

    private fun registerSurgeonScrubsItem(): RegistryObject<Item> {
        val item: RegistryObject<Item> = itemRegister.register("surgeon_scrubs") {
            ArmorItem(ArmorMaterials.LEATHER, EquipmentSlot.CHEST, Item.Properties())
        }
        list.add(item)
        return item
    }
}
