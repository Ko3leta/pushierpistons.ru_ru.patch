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

package net.frozenblock.pushierpistons.pushable_block_entity;

import net.frozenblock.pushierpistons.config.PPConfig;
import net.frozenblock.pushierpistons.tag.PPBlockTags;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.ShelfBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SideChainPart;

public class PushableBlockEntityHelper {

	public static boolean isBlockPushingDisabled(BlockState state) {
		if (!state.hasBlockEntity()) return false;
		if (state.is(PPBlockTags.EXCLUDED_BLOCK_ENTITIES)) return true;

		// STORAGE
		if (!PPConfig.PUSHABLE_CHESTS && state.is(PPBlockTags.PUSHABLE_CHESTS)) return true;
		if (!PPConfig.PUSHABLE_BARRELS && state.is(PPBlockTags.PUSHABLE_BARRELS)) return true;
		if (!PPConfig.PUSHABLE_CHESTS && state.is(PPBlockTags.PUSHABLE_CHESTS)) return true;
		if (!PPConfig.PUSHABLE_LECTERNS && state.is(PPBlockTags.PUSHABLE_LECTERNS)) return true;
		if (!PPConfig.PUSHABLE_SHELVES && state.is(PPBlockTags.PUSHABLE_SHELVES)) return true;

		// UTILITY
		if (!PPConfig.PUSHABLE_FURNACES && state.is(PPBlockTags.PUSHABLE_FURNACES)) return true;
		if (!PPConfig.PUSHABLE_BREWING_STANDS && state.is(PPBlockTags.PUSHABLE_BREWING_STANDS)) return true;
		if (!PPConfig.PUSHABLE_ENCHANTING_TABLES && state.is(PPBlockTags.PUSHABLE_ENCHANTING_TABLES)) return true;

		// REDSTONE
		if (!PPConfig.PUSHABLE_ITEM_TRANSPORTERS && state.is(PPBlockTags.PUSHABLE_ITEM_TRANSPORTERS)) return true;
		if (!PPConfig.PUSHABLE_EJECTORS && state.is(PPBlockTags.PUSHABLE_EJECTORS)) return true;
		if (!PPConfig.PUSHABLE_CRAFTERS && state.is(PPBlockTags.PUSHABLE_CRAFTERS)) return true;
		if (!PPConfig.PUSHABLE_DAYLIGHT_DETECTORS && state.is(PPBlockTags.PUSHABLE_DAYLIGHT_DETECTORS)) return true;

		// COMBAT
		if (!PPConfig.PUSHABLE_CREAKING_HEARTS && state.is(PPBlockTags.PUSHABLE_CREAKING_HEARTS)) return true;
		if (!PPConfig.PUSHABLE_SPAWNERS && state.is(PPBlockTags.PUSHABLE_SPAWNERS)) return true;
		if (!PPConfig.PUSHABLE_TRIAL_SPAWNERS && state.is(PPBlockTags.PUSHABLE_TRIAL_SPAWNERS)) return true;
		if (!PPConfig.PUSHABLE_VAULTS && state.is(PPBlockTags.PUSHABLE_VAULTS)) return true;

		// BUFFS
		if (!PPConfig.PUSHABLE_BEACONS && state.is(PPBlockTags.PUSHABLE_BEACONS)) return true;
		if (!PPConfig.PUSHABLE_CONDUITS && state.is(PPBlockTags.PUSHABLE_CONDUITS)) return true;

		// OTHER
		if (!PPConfig.PUSHABLE_BEEHIVES && state.is(PPBlockTags.PUSHABLE_BEEHIVES)) return true;
		if (!PPConfig.PUSHABLE_CAMPFIRES && state.is(PPBlockTags.PUSHABLE_CAMPFIRES)) return true;
		if (!PPConfig.PUSHABLE_SIGNS && state.is(PPBlockTags.PUSHABLE_SIGNS)) return true;

		// WILDER WILD
		if (!PPConfig.PUSHABLE_GEYSERS && state.is(PPBlockTags.PUSHABLE_GEYSERS)) return true;

		// TRAILIER TALES
		if (!PPConfig.PUSHABLE_SURVEYORS && state.is(PPBlockTags.PUSHABLE_SURVEYORS)) return true;

		// NETHERIER NETHER
		if (!PPConfig.PUSHABLE_NETHER_REACTOR_CORES && state.is(PPBlockTags.PUSHABLE_NETHER_REACTOR_CORES)) return true;

		// SIMPLE COPPER PIPES
		if (!PPConfig.PUSHABLE_COPPER_PIPES && state.is(PPBlockTags.PUSHABLE_COPPER_PIPES)) return true;
		if (!PPConfig.PUSHABLE_COPPER_FITTINGS && state.is(PPBlockTags.PUSHABLE_COPPER_FITTINGS)) return true;

		return false;
	}

	public static boolean canShelvesStick(BlockState state1, BlockState state2, Direction direction) {
		if (!PPConfig.PUSHABLE_SHELVES) return false;
		if (!state1.is(PPBlockTags.PUSHABLE_SHELVES) || !state2.is(PPBlockTags.PUSHABLE_SHELVES)) return false;

		final SideChainPart chainPart1 = state1.getValueOrElse(ShelfBlock.SIDE_CHAIN_PART, SideChainPart.UNCONNECTED);
		if (chainPart1 == SideChainPart.UNCONNECTED) return false;

		final SideChainPart chainPart2 = state2.getValueOrElse(ShelfBlock.SIDE_CHAIN_PART, SideChainPart.UNCONNECTED);
		if (chainPart2 == SideChainPart.UNCONNECTED) return false;

		if (!state1.hasProperty(ShelfBlock.FACING) || !state2.hasProperty(ShelfBlock.FACING)) return false;
		final Direction facing1 = state1.getValue(ShelfBlock.FACING);
		final Direction facing2 = state2.getValue(ShelfBlock.FACING);
		if (facing1 != facing2) return false;

		final Direction left = facing1.getCounterClockWise();
		final Direction right = facing1.getClockWise();
		final Direction oppositeDirection = direction.getOpposite();

		if (chainPart1 == SideChainPart.CENTER) {
			if (oppositeDirection == left) return chainPart2 != SideChainPart.RIGHT;
			if (oppositeDirection == right) return chainPart2 != SideChainPart.LEFT;
			return false;
		}

		if (chainPart1 == SideChainPart.LEFT) {
			if (oppositeDirection == right) return chainPart2 != SideChainPart.LEFT;
			return false;
		}

		if (chainPart1 == SideChainPart.RIGHT) {
			if (oppositeDirection == left) return chainPart2 != SideChainPart.RIGHT;
			return false;
		}

		return false;
	}

}
