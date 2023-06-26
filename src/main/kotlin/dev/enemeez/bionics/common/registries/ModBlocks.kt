package dev.enemeez.bionics.common.registries

import dev.enemeez.bionics.common.Bionics
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.DropExperienceBlock
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.material.Material
import net.minecraft.world.level.material.MaterialColor
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries

object ModBlocks {

    val blockRegister: DeferredRegister<Block> = DeferredRegister.create(ForgeRegistries.BLOCKS, Bionics.MOD_ID)

    val titaniumOre = registerOreBlock("titanium_ore")
    val deepslateTitaniumOre = registerDeepslateOreBlock("deepslate_titanium_ore")

    private fun registerOreBlock(name: String) = blockRegister.register(name) {
        DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
            .requiresCorrectToolForDrops()
            .strength(3.0f, 3.0f)
        )
    }

    private fun registerDeepslateOreBlock(name: String) = blockRegister.register(name) {
        DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
            .requiresCorrectToolForDrops()
            .color(MaterialColor.DEEPSLATE)
            .strength(4.5f, 3.0f)
            .sound(SoundType.DEEPSLATE)
        )
    }
}
