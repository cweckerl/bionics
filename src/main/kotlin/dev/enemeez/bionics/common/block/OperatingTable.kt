package dev.enemeez.bionics.common.block

import net.minecraft.core.BlockPos
import net.minecraft.world.level.block.EntityBlock
import net.minecraft.world.level.block.HorizontalDirectionalBlock
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState

class OperatingTable(pProperties: Properties) : HorizontalDirectionalBlock(pProperties), EntityBlock {

    override fun newBlockEntity(pPos: BlockPos, pState: BlockState): BlockEntity {
        TODO("Not yet implemented")
    }
}
