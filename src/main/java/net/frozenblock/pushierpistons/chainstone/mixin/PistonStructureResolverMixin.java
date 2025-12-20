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

package net.frozenblock.pushierpistons.chainstone.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.frozenblock.pushierpistons.chainstone.ChainstoneHelper;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.piston.PistonStructureResolver;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PistonStructureResolver.class)
public class PistonStructureResolverMixin {

	@Shadow
	@Final
	private Direction pushDirection;

	@WrapOperation(
		method = {"resolve", "addBlockLine"},
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/world/level/block/piston/PistonStructureResolver;isSticky(Lnet/minecraft/world/level/block/state/BlockState;)Z"
		)
	)
	private boolean pushierPistons$chainSticking(BlockState state, Operation<Boolean> original) {
		return original.call(state) || ChainstoneHelper.isChainstoneBlock(state);
	}

	@WrapOperation(
		method = "addBlockLine",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/world/level/block/piston/PistonStructureResolver;canStickToEachOther(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/block/state/BlockState;)Z"
		)
	)
	private boolean pushierPistons$addBlockLineChainStone(BlockState state1, BlockState state2, Operation<Boolean> original) {
		return original.call(state1, state2) || ChainstoneHelper.verifyCombination(state1, state2, this.pushDirection.getAxis());
	}

	@WrapOperation(
		method = "addBranchingBlocks",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/world/level/block/piston/PistonStructureResolver;canStickToEachOther(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/block/state/BlockState;)Z"
		)
	)
	private boolean pushierPistons$addBranchingBlocksChainStone(
		BlockState state1, BlockState state2, Operation<Boolean> original,
		@Local Direction direction
	) {
		return original.call(state1, state2) || ChainstoneHelper.verifyCombination(state2, state1, direction.getAxis());
	}

}
