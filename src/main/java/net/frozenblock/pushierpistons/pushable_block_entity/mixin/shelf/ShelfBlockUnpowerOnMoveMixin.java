/*
 * Copyright 2025 FrozenBlock
 * This file is part of Pushier Pistons.
 *
 * This program is free software; you can modify it under
 * the terms of version 1 of the FrozenBlock Modding Oasis License
 * as published by FrozenBlock Modding Oasis.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * FrozenBlock Modding Oasis License for more details.
 *
 * You should have received a copy of the FrozenBlock Modding Oasis License
 * along with this program; if not, see <https://github.com/FrozenBlock/Licenses>.
 */

package net.frozenblock.pushierpistons.pushable_block_entity.mixin.shelf;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import net.frozenblock.pushierpistons.config.PPConfig;
import net.frozenblock.pushierpistons.tag.PPBlockTags;
import net.minecraft.world.level.block.ShelfBlock;
import net.minecraft.world.level.block.piston.PistonMovingBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SideChainPart;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PistonMovingBlockEntity.class)
public class ShelfBlockUnpowerOnMoveMixin {

	@Inject(
		method = "<init>(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/core/Direction;ZZ)V",
		at = @At(
			value = "CTOR_HEAD",
			args = "enforce=PRE_BODY"
		)
	)
	public void pushierPistons$powerDownShelfOnPush(
		CallbackInfo info,
		@Local(ordinal = 1, argsOnly = true) LocalRef<BlockState> movedStateRef
	) {
		if (!PPConfig.PUSHABLE_SHELVES) return;

		final BlockState movedState = movedStateRef.get();
		if (movedState.is(PPBlockTags.PUSHABLE_SHELVES)) {
			movedStateRef.set(movedState.trySetValue(ShelfBlock.POWERED, false).trySetValue(ShelfBlock.SIDE_CHAIN_PART, SideChainPart.UNCONNECTED));
		}
	}

}
