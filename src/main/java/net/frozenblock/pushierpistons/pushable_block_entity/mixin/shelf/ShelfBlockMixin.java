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
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ShelfBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ShelfBlock.class)
public class ShelfBlockMixin {

	@Inject(method = "onPlace", at = @At("HEAD"))
	private void pushierPistons$updatePowerOnMovement(
		BlockState state, Level level, BlockPos pos, BlockState replacingState, boolean movedByPiston, CallbackInfo info,
		@Local(argsOnly = true, ordinal = 0) LocalRef<BlockState> stateRef
	) {
		// This is technically unnecessary, but is here just to be safe.
		if (movedByPiston && PPConfig.PUSHABLE_SHELVES) {
			final boolean powered = level.hasNeighborSignal(pos);
			stateRef.set(state.setValue(ShelfBlock.POWERED, powered));
		}
	}

}
