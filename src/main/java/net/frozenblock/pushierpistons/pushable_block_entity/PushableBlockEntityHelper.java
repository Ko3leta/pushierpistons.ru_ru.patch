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
import net.minecraft.world.level.block.state.BlockState;

public class PushableBlockEntityHelper {

	public static boolean isBlockPushingDisabled(BlockState state) {
		if (!state.hasBlockEntity()) return false;
		if (state.is(PPBlockTags.EXCLUDED_BLOCK_ENTITIES)) return true;

		// STORAGE
		if (!PPConfig.PUSHABLE_CHESTS && state.is(PPBlockTags.PUSHABLE_CHESTS)) return true;
		if (!PPConfig.PUSHABLE_BARRELS && state.is(PPBlockTags.PUSHABLE_BARRELS)) return true;
		if (!PPConfig.PUSHABLE_CHESTS && state.is(PPBlockTags.PUSHABLE_CHESTS)) return true;

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
		if (!PPConfig.PUSHABLE_SPAWNERS && state.is(PPBlockTags.PUSHABLE_SPAWNERS)) return true;
		if (!PPConfig.PUSHABLE_TRIAL_SPAWNERS && state.is(PPBlockTags.PUSHABLE_TRIAL_SPAWNERS)) return true;
		if (!PPConfig.PUSHABLE_VAULTS && state.is(PPBlockTags.PUSHABLE_VAULTS)) return true;

		// BUFFS
		if (!PPConfig.PUSHABLE_BEACONS && state.is(PPBlockTags.PUSHABLE_BEACONS)) return true;
		if (!PPConfig.PUSHABLE_CONDUITS && state.is(PPBlockTags.PUSHABLE_CONDUITS)) return true;

		// OTHER
		if (!PPConfig.PUSHABLE_BEEHIVES && state.is(PPBlockTags.PUSHABLE_BEEHIVES)) return true;
		if (!PPConfig.PUSHABLE_CAMPFIRES && state.is(PPBlockTags.PUSHABLE_CAMPFIRES)) return true;

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

}
