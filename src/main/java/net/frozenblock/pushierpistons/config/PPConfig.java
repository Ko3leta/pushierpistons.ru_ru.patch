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

package net.frozenblock.pushierpistons.config;

import net.frozenblock.lib.config.api.instance.Config;
import net.frozenblock.lib.config.api.instance.json.JsonConfig;
import net.frozenblock.lib.config.api.instance.json.JsonType;
import net.frozenblock.lib.config.api.registry.ConfigRegistry;
import net.frozenblock.lib.config.api.sync.annotation.EntrySyncData;
import net.frozenblock.pushierpistons.PPConstants;
import net.frozenblock.pushierpistons.chainstone.ChainstoneType;

public class PPConfig {
	public static final Config<PPConfig> INSTANCE = ConfigRegistry.register(
		new JsonConfig<>(
			PPConstants.MOD_ID,
			PPConfig.class,
			JsonType.JSON5_UNQUOTED_KEYS,
			true
		) {
			@Override
			public void onSave() throws Exception {
				super.onSave();
				this.onSync(null);
			}

			@Override
			public void onSync(PPConfig syncInstance) {
				final var config = this.config();

				// CHAINSTONE
				CHAINSTONE_TYPE = config.chainstoneType;

				// STORAGE
				PUSHABLE_CHESTS = config.pushableChests;
				PUSHABLE_BARRELS = config.pushableBarrels;
				PUSHABLE_CHISELED_BOOKSHELVES = config.pushableChiseledBookshelves;
				PUSHABLE_LECTERNS = config.pushableLecterns;
				PUSHABLE_SHELVES = config.pushableShelves;

				// UTILITY
				PUSHABLE_FURNACES = config.pushableFurnaces;
				PUSHABLE_BREWING_STANDS = config.pushableBrewingStands;
				PUSHABLE_ENCHANTING_TABLES = config.pushableEnchantingTables;

				// REDSTONE
				PUSHABLE_ITEM_TRANSPORTERS = config.pushableItemTransporters;
				PUSHABLE_EJECTORS = config.pushableEjectors;
				PUSHABLE_CRAFTERS = config.pushableCrafters;
				PUSHABLE_DAYLIGHT_DETECTORS = config.pushableDaylightDetectors;

				// COMBAT
				PUSHABLE_CREAKING_HEARTS = config.pushableCreakingHearts;
				PUSHABLE_SPAWNERS = config.pushableSpawners;
				PUSHABLE_TRIAL_SPAWNERS = config.pushableTrialSpawners;
				PUSHABLE_VAULTS = config.pushableVaults;

				// BUFFS
				PUSHABLE_BEACONS = config.pushableBeacons;
				PUSHABLE_CONDUITS = config.pushableConduits;

				// OTHER
				PUSHABLE_BEEHIVES = config.pushableBeehives;
				PUSHABLE_CAMPFIRES = config.pushableCampfires;
				PUSHABLE_SIGNS = config.pushableSigns;

				// WILDER WILD
				PUSHABLE_GEYSERS = config.pushableGeysers;

				// TRAILIER TALES
				PUSHABLE_SURVEYORS = config.pushableSurveyors;

				// NETHERIER NETHER
				PUSHABLE_NETHER_REACTOR_CORES = config.pushableNetherReactorCores;

				// SIMPLE COPPER PIPES
				PUSHABLE_COPPER_PIPES = config.pushableCopperPipes;
				PUSHABLE_COPPER_FITTINGS = config.pushableCopperFittings;
			}
		}
	);

	// CHAINSTONE
	public static volatile ChainstoneType CHAINSTONE_TYPE = ChainstoneType.CHAIN_FACING_INTO;
	@EntrySyncData("chainstoneType")
	public ChainstoneType chainstoneType = ChainstoneType.CHAIN_FACING_INTO;

	// STORAGE
	public static volatile boolean PUSHABLE_CHESTS = false;
	@EntrySyncData("pushableChests")
	public boolean pushableChests = false;

	public static volatile boolean PUSHABLE_BARRELS = false;
	@EntrySyncData("pushableBarrels")
	public boolean pushableBarrels = false;

	public static volatile boolean PUSHABLE_CHISELED_BOOKSHELVES = true;
	@EntrySyncData("pushableChiseledBookshelves")
	public boolean pushableChiseledBookshelves = true;

	public static volatile boolean PUSHABLE_LECTERNS = true;
	@EntrySyncData("pushableLecterns")
	public boolean pushableLecterns = true;

	public static volatile boolean PUSHABLE_SHELVES = true;
	@EntrySyncData("pushableShelves")
	public boolean pushableShelves = true;

	// UTILITY
	public static volatile boolean PUSHABLE_FURNACES = true;
	@EntrySyncData("pushableFurnaces")
	public boolean pushableFurnaces = true;

	public static volatile boolean PUSHABLE_BREWING_STANDS = true;
	@EntrySyncData("pushableBrewingStands")
	public boolean pushableBrewingStands = true;

	public static volatile boolean PUSHABLE_ENCHANTING_TABLES = true;
	@EntrySyncData("pushableEnchantingTables")
	public boolean pushableEnchantingTables = true;

	// REDSTONE
	public static volatile boolean PUSHABLE_ITEM_TRANSPORTERS = false;
	@EntrySyncData("pushableItemTransporters")
	public boolean pushableItemTransporters = false;

	public static volatile boolean PUSHABLE_EJECTORS = true;
	@EntrySyncData("pushableEjectors")
	public boolean pushableEjectors = true;

	public static volatile boolean PUSHABLE_CRAFTERS = true;
	@EntrySyncData("pushableCrafters")
	public boolean pushableCrafters = true;

	public static volatile boolean PUSHABLE_DAYLIGHT_DETECTORS = true;
	@EntrySyncData("pushableDaylightDetectors")
	public boolean pushableDaylightDetectors = true;

	// COMBAT
	public static volatile boolean PUSHABLE_CREAKING_HEARTS = false;
	@EntrySyncData("pushableCreakingHearts")
	public boolean pushableCreakingHearts = true;

	public static volatile boolean PUSHABLE_SPAWNERS = false;
	@EntrySyncData("pushableSpawners")
	public boolean pushableSpawners = false;

	public static volatile boolean PUSHABLE_TRIAL_SPAWNERS = false;
	@EntrySyncData("pushableTrialSpawners")
	public boolean pushableTrialSpawners = false;

	public static volatile boolean PUSHABLE_VAULTS = false;
	@EntrySyncData("pushableVaults")
	public boolean pushableVaults = false;

	// BUFFS
	public static volatile boolean PUSHABLE_BEACONS = true;
	@EntrySyncData("pushableBeacons")
	public boolean pushableBeacons = true;

	public static volatile boolean PUSHABLE_CONDUITS = true;
	@EntrySyncData("pushableConduits")
	public boolean pushableConduits = true;

	// OTHER
	public static volatile boolean PUSHABLE_BEEHIVES = true;
	@EntrySyncData("pushableBeehives")
	public boolean pushableBeehives = true;

	public static volatile boolean PUSHABLE_CAMPFIRES = true;
	@EntrySyncData("pushableCampfires")
	public boolean pushableCampfires = true;

	public static volatile boolean PUSHABLE_SIGNS = false;
	@EntrySyncData("pushableSigns")
	public boolean pushableSigns = false;

	// WILDER WILD
	public static volatile boolean PUSHABLE_GEYSERS = true;
	@EntrySyncData("pushableGeysers")
	public boolean pushableGeysers = true;

	// TRAILIER TALES
	public static volatile boolean PUSHABLE_SURVEYORS = true;
	@EntrySyncData("pushableSurveyors")
	public boolean pushableSurveyors = true;

	// NETHERIER NETHER
	public static volatile boolean PUSHABLE_NETHER_REACTOR_CORES = true;
	@EntrySyncData("pushableNetherReactorCores")
	public boolean pushableNetherReactorCores = true;

	// SIMPLE COPPER PIPES
	public static volatile boolean PUSHABLE_COPPER_PIPES = false;
	@EntrySyncData("pushableCopperPipes")
	public boolean pushableCopperPipes = false;

	public static volatile boolean PUSHABLE_COPPER_FITTINGS = false;
	@EntrySyncData("pushableCopperFittings")
	public boolean pushableCopperFittings = false;

	public static PPConfig get(boolean real) {
		if (real) return INSTANCE.instance();
		return INSTANCE.config();
	}

	public static PPConfig get() {
		return get(false);
	}

	public static PPConfig getWithSync() {
		return INSTANCE.configWithSync();
	}
}
