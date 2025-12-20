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

package net.frozenblock.pushierpistons.pushable_block_entity.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.frozenblock.pushierpistons.pushable_block_entity.PushableBlockEntityHelper;
import net.minecraft.world.level.block.piston.PistonBaseBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = PistonBaseBlock.class, priority = 1001)
public class PistonBaseBlockMixin {

	@WrapOperation(
		method = "isPushable",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/world/level/block/state/BlockState;hasBlockEntity()Z"
		)
	)
	private static boolean pushierPistons$verifyBlockEntityCanBePushed(BlockState state, Operation<Boolean> original) {
		if (state.hasBlockEntity()) {
			final boolean isDisabled = PushableBlockEntityHelper.isBlockPushingDisabled(state);
			if (isDisabled) return true;
		}
		return original.call(state);
	}

}
