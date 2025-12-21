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

package net.frozenblock.pushierpistons.tag;

import net.frozenblock.pushierpistons.PPConstants;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public final class PPBlockTags {
	// STORAGE
	public static final TagKey<Block> PUSHABLE_CHESTS = bind("pushable_chests");
	public static final TagKey<Block> PUSHABLE_BARRELS = bind("pushable_barrels");
	public static final TagKey<Block> PUSHABLE_CHISELED_BOOKSHELVES = bind("pushable_chiseled_bookshelves");
	public static final TagKey<Block> PUSHABLE_LECTERNS = bind("pushable_lecterns");
	public static final TagKey<Block> PUSHABLE_SHELVES = bind("pushable_shelves");
	// UTILITY
	public static final TagKey<Block> PUSHABLE_FURNACES = bind("pushable_furnaces");
	public static final TagKey<Block> PUSHABLE_BREWING_STANDS = bind("pushable_brewing_stands");
	public static final TagKey<Block> PUSHABLE_ENCHANTING_TABLES = bind("pushable_enchanting_tables");
	// REDSTONE
	public static final TagKey<Block> PUSHABLE_ITEM_TRANSPORTERS = bind("pushable_item_transporters");
	public static final TagKey<Block> PUSHABLE_EJECTORS = bind("pushable_ejectors");
	public static final TagKey<Block> PUSHABLE_CRAFTERS = bind("pushable_crafters");
	public static final TagKey<Block> PUSHABLE_DAYLIGHT_DETECTORS = bind("pushable_daylight_detectors");
	// COMBAT
	public static final TagKey<Block> PUSHABLE_CREAKING_HEARTS = bind("pushable_creaking_hearts");
	public static final TagKey<Block> PUSHABLE_SPAWNERS = bind("pushable_spawners");
	public static final TagKey<Block> PUSHABLE_TRIAL_SPAWNERS = bind("pushable_trial_spawners");
	public static final TagKey<Block> PUSHABLE_VAULTS = bind("pushable_vaults");
	// BUFFS
	public static final TagKey<Block> PUSHABLE_BEACONS = bind("pushable_beacons");
	public static final TagKey<Block> PUSHABLE_CONDUITS = bind("pushable_conduits");
	// OTHER
	public static final TagKey<Block> PUSHABLE_BEEHIVES = bind("pushable_beehives");
	public static final TagKey<Block> PUSHABLE_CAMPFIRES = bind("pushable_campfires");
	public static final TagKey<Block> PUSHABLE_SIGNS = bind("pushable_signs");
	// WILDER WILD
	public static final TagKey<Block> PUSHABLE_GEYSERS = bind("pushable_geysers");
	// TRAILIER TALES
	public static final TagKey<Block> PUSHABLE_SURVEYORS = bind("pushable_surveyors");
	// NETHERIER NETHER
	public static final TagKey<Block> PUSHABLE_NETHER_REACTOR_CORES = bind("pushable_nether_reactor_cores");
	// SIMPLE COPPER PIPES
	public static final TagKey<Block> PUSHABLE_COPPER_PIPES = bind("pushable_copper_pipes");
	public static final TagKey<Block> PUSHABLE_COPPER_FITTINGS = bind("pushable_copper_fittings");
	// EXCLUSIONS
	public static final TagKey<Block> EXCLUDED_BLOCK_ENTITIES = bind("excluded_block_entities");

	// CHAINSTONE
	public static final TagKey<Block> CHAINSTONE_BLOCKS = bind("chainstone_blocks");

	private PPBlockTags() {
		throw new UnsupportedOperationException("PPBlockTags contains only static declarations.");
	}

	private static TagKey<Block> bind(String path) {
		return TagKey.create(Registries.BLOCK, PPConstants.id(path));
	}
}
