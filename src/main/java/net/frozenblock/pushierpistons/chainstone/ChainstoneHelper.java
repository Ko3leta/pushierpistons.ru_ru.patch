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

package net.frozenblock.pushierpistons.chainstone;

import net.frozenblock.pushierpistons.config.PPConfig;
import net.frozenblock.pushierpistons.tag.PPBlockTags;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.ChainBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ChainstoneHelper {

	public static boolean isChainstoneBlock(BlockState state) {
		final ChainstoneType type = PPConfig.CHAINSTONE_TYPE;
		if (type == ChainstoneType.DISABLED) return false;
		return state.is(PPBlockTags.CHAINSTONE_BLOCKS);
	}

	public static boolean verifyCombination(BlockState state1, BlockState state2, Direction.Axis pushAxis) {
		final ChainstoneType type = PPConfig.CHAINSTONE_TYPE;
		return switch (type) {
			case CHAIN_FACING_INTO -> verifyFacingInto(state1, pushAxis);
			case CHAINS_ALONG_SAME_AXIS -> verifyAlongSameAxis(state1, state2, pushAxis);
			case ADJACENT_CHAINS_FACING_INTO -> verifyChainstoneAdjacentFacingInto(state1, state2, pushAxis);
			default -> false;
		};
	}

	public static boolean verifyFacingInto(BlockState state, Direction.Axis pushAxis) {
		return state.is(PPBlockTags.CHAINSTONE_BLOCKS) && state.getOptionalValue(ChainBlock.AXIS).orElse(null) == pushAxis;
	}

	public static boolean verifyAlongSameAxis(BlockState state1, BlockState state2, Direction.Axis pushAxis) {
		final boolean is1Chain = state1.is(PPBlockTags.CHAINSTONE_BLOCKS);
		final boolean is2Chain = state2.is(PPBlockTags.CHAINSTONE_BLOCKS);
		if (!is1Chain && !is2Chain) return false;

		final Direction.Axis axis1 = state1.getOptionalValue(ChainBlock.AXIS).orElse(null);
		final Direction.Axis axis2 = state2.getOptionalValue(ChainBlock.AXIS).orElse(null);

		if (is1Chain) {
			if (is2Chain) return axis1 == pushAxis && axis2 == pushAxis;
			return axis1 == pushAxis;
		}

		return axis2 == pushAxis;
	}

	public static boolean verifyChainstoneAdjacentFacingInto(BlockState state1, BlockState state2, Direction.Axis pushAxis) {
		return verifyFacingInto(state1, pushAxis) || verifyFacingInto(state2, pushAxis);
	}

}
