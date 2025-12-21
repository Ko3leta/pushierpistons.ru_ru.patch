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

package net.frozenblock.pushierpistons.config.gui;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;
import net.frozenblock.lib.FrozenBools;
import net.frozenblock.lib.config.api.instance.Config;
import net.frozenblock.lib.config.clothconfig.FrozenClothConfig;
import net.frozenblock.pushierpistons.PPConstants;
import net.frozenblock.pushierpistons.chainstone.ChainstoneType;
import net.frozenblock.pushierpistons.config.PPConfig;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.Contract;

@Environment(EnvType.CLIENT)
public final class PPConfigGui {
	private static final boolean WILDERWILD = FrozenBools.HAS_WILDERWILD;
	private static final boolean TRAILIERTALES = FrozenBools.HAS_TRAILIERTALES;
	private static final boolean NETHERIERNETHER = FabricLoader.getInstance().isModLoaded("netheriernether");
	private static final boolean SIMPLE_COPPER_PIPES = FrozenBools.HAS_SIMPLE_COPPER_PIPES;

	private static void setupEntries(ConfigCategory category, ConfigEntryBuilder entryBuilder) {
		final PPConfig config = PPConfig.get(true);
		final PPConfig modifiedConfig = PPConfig.getWithSync();
		final Config<?> configInstance = PPConfig.INSTANCE;
		final PPConfig defaultConfig = PPConfig.INSTANCE.defaultInstance();

		final var chainstoneType = category.addEntry(
			FrozenClothConfig.syncedEntry(
				entryBuilder.startEnumSelector(text("chainstone_type"), ChainstoneType.class, modifiedConfig.chainstoneType)
					.setDefaultValue(defaultConfig.chainstoneType)
					.setSaveConsumer(newValue -> config.chainstoneType = newValue)
					.setEnumNameProvider(value -> enumNameProvider("chainstone_type." + value.toString()))
					.setTooltip(tooltip("chainstone_type"))
					.build(),
				config.getClass(),
				"chainstoneType",
				configInstance
			)
		);

		// STORAGE
		final var pushableChests = FrozenClothConfig.syncedEntry(
			entryBuilder.startBooleanToggle(text("pushable_chests"), modifiedConfig.pushableChests)
				.setDefaultValue(defaultConfig.pushableChests)
				.setSaveConsumer(newValue -> config.pushableChests = newValue)
				.setTooltip(tooltip("pushable_chests"))
				.build(),
			config.getClass(),
			"pushableChests",
			configInstance
		);
		final var pushableBarrels = FrozenClothConfig.syncedEntry(
			entryBuilder.startBooleanToggle(text("pushable_barrels"), modifiedConfig.pushableBarrels)
				.setDefaultValue(defaultConfig.pushableBarrels)
				.setSaveConsumer(newValue -> config.pushableBarrels = newValue)
				.setTooltip(tooltip("pushable_barrels"))
				.build(),
			config.getClass(),
			"pushableBarrels",
			configInstance
		);
		final var pushableChiseledBookshelves = FrozenClothConfig.syncedEntry(
			entryBuilder.startBooleanToggle(text("pushable_chiseled_bookshelves"), modifiedConfig.pushableChiseledBookshelves)
				.setDefaultValue(defaultConfig.pushableChiseledBookshelves)
				.setSaveConsumer(newValue -> config.pushableChiseledBookshelves = newValue)
				.setTooltip(tooltip("pushable_chiseled_bookshelves"))
				.build(),
			config.getClass(),
			"pushableChiseledBookshelves",
			configInstance
		);
		final var pushableLecterns = FrozenClothConfig.syncedEntry(
			entryBuilder.startBooleanToggle(text("pushable_lecterns"), modifiedConfig.pushableLecterns)
				.setDefaultValue(defaultConfig.pushableLecterns)
				.setSaveConsumer(newValue -> config.pushableLecterns = newValue)
				.setTooltip(tooltip("pushable_lecterns"))
				.build(),
			config.getClass(),
			"pushableLecterns",
			configInstance
		);
		final var pushableShelves = FrozenClothConfig.syncedEntry(
			entryBuilder.startBooleanToggle(text("pushable_shelves"), modifiedConfig.pushableShelves)
				.setDefaultValue(defaultConfig.pushableShelves)
				.setSaveConsumer(newValue -> config.pushableShelves = newValue)
				.setTooltip(tooltip("pushable_shelves"))
				.build(),
			config.getClass(),
			"pushableShelves",
			configInstance
		);
		final var storageCategory = FrozenClothConfig.createSubCategory(entryBuilder, category, text("storage"),
			false,
			tooltip("storage"),
			pushableChests, pushableBarrels, pushableChiseledBookshelves, pushableLecterns, pushableShelves
		);

		// STORAGE
		final var pushableFurnaces = FrozenClothConfig.syncedEntry(
			entryBuilder.startBooleanToggle(text("pushable_furnaces"), modifiedConfig.pushableFurnaces)
				.setDefaultValue(defaultConfig.pushableFurnaces)
				.setSaveConsumer(newValue -> config.pushableFurnaces = newValue)
				.setTooltip(tooltip("pushable_furnaces"))
				.build(),
			config.getClass(),
			"pushableFurnaces",
			configInstance
		);
		final var pushableBrewingStands = FrozenClothConfig.syncedEntry(
			entryBuilder.startBooleanToggle(text("pushable_brewing_stands"), modifiedConfig.pushableBrewingStands)
				.setDefaultValue(defaultConfig.pushableBrewingStands)
				.setSaveConsumer(newValue -> config.pushableBrewingStands = newValue)
				.setTooltip(tooltip("pushable_brewing_stands"))
				.build(),
			config.getClass(),
			"pushableBrewingStands",
			configInstance
		);
		final var pushableEnchantingTables = FrozenClothConfig.syncedEntry(
			entryBuilder.startBooleanToggle(text("pushable_enchanting_tables"), modifiedConfig.pushableEnchantingTables)
				.setDefaultValue(defaultConfig.pushableEnchantingTables)
				.setSaveConsumer(newValue -> config.pushableEnchantingTables = newValue)
				.setTooltip(tooltip("pushable_enchanting_tables"))
				.build(),
			config.getClass(),
			"pushableEnchantingTables",
			configInstance
		);
		final var utilityCategory = FrozenClothConfig.createSubCategory(entryBuilder, category, text("utility"),
			false,
			tooltip("utility"),
			pushableFurnaces, pushableBrewingStands, pushableEnchantingTables
		);

		// REDSTONE
		final var pushableItemTransporters = FrozenClothConfig.syncedEntry(
			entryBuilder.startBooleanToggle(text("pushable_item_transporters"), modifiedConfig.pushableItemTransporters)
				.setDefaultValue(defaultConfig.pushableItemTransporters)
				.setSaveConsumer(newValue -> config.pushableItemTransporters = newValue)
				.setTooltip(tooltip("pushable_item_transporters"))
				.build(),
			config.getClass(),
			"pushableItemTransporters",
			configInstance
		);
		final var pushableEjectors = FrozenClothConfig.syncedEntry(
			entryBuilder.startBooleanToggle(text("pushable_ejectors"), modifiedConfig.pushableEjectors)
				.setDefaultValue(defaultConfig.pushableEjectors)
				.setSaveConsumer(newValue -> config.pushableEjectors = newValue)
				.setTooltip(tooltip("pushable_ejectors"))
				.build(),
			config.getClass(),
			"pushableEjectors",
			configInstance
		);
		final var pushableCrafters = FrozenClothConfig.syncedEntry(
			entryBuilder.startBooleanToggle(text("pushable_crafters"), modifiedConfig.pushableCrafters)
				.setDefaultValue(defaultConfig.pushableCrafters)
				.setSaveConsumer(newValue -> config.pushableCrafters = newValue)
				.setTooltip(tooltip("pushable_crafters"))
				.build(),
			config.getClass(),
			"pushableCrafters",
			configInstance
		);
		final var pushableDaylightDetectors = FrozenClothConfig.syncedEntry(
			entryBuilder.startBooleanToggle(text("pushable_daylight_detectors"), modifiedConfig.pushableDaylightDetectors)
				.setDefaultValue(defaultConfig.pushableDaylightDetectors)
				.setSaveConsumer(newValue -> config.pushableDaylightDetectors = newValue)
				.setTooltip(tooltip("pushable_daylight_detectors"))
				.build(),
			config.getClass(),
			"pushableDaylightDetectors",
			configInstance
		);
		final var redstoneCategory = FrozenClothConfig.createSubCategory(entryBuilder, category, text("redstone"),
			false,
			tooltip("redstone"),
			pushableItemTransporters, pushableEjectors, pushableCrafters, pushableDaylightDetectors
		);

		// COMBAT
		final var pushableCreakingHearts = FrozenClothConfig.syncedEntry(
			entryBuilder.startBooleanToggle(text("pushable_creaking_hearts"), modifiedConfig.pushableCreakingHearts)
				.setDefaultValue(defaultConfig.pushableCreakingHearts)
				.setSaveConsumer(newValue -> config.pushableCreakingHearts = newValue)
				.setTooltip(tooltip("pushable_creaking_hearts"))
				.build(),
			config.getClass(),
			"pushableCreakingHearts",
			configInstance
		);
		final var pushableSpawners = FrozenClothConfig.syncedEntry(
			entryBuilder.startBooleanToggle(text("pushable_spawners"), modifiedConfig.pushableSpawners)
				.setDefaultValue(defaultConfig.pushableSpawners)
				.setSaveConsumer(newValue -> config.pushableSpawners = newValue)
				.setTooltip(tooltip("pushable_spawners"))
				.build(),
			config.getClass(),
			"pushableSpawners",
			configInstance
		);
		final var pushableTrialSpawners = FrozenClothConfig.syncedEntry(
			entryBuilder.startBooleanToggle(text("pushable_trial_spawners"), modifiedConfig.pushableTrialSpawners)
				.setDefaultValue(defaultConfig.pushableTrialSpawners)
				.setSaveConsumer(newValue -> config.pushableTrialSpawners = newValue)
				.setTooltip(tooltip("pushable_trial_spawners"))
				.build(),
			config.getClass(),
			"pushableTrialSpawners",
			configInstance
		);
		final var pushableVaults = FrozenClothConfig.syncedEntry(
			entryBuilder.startBooleanToggle(text("pushable_vaults"), modifiedConfig.pushableVaults)
				.setDefaultValue(defaultConfig.pushableVaults)
				.setSaveConsumer(newValue -> config.pushableVaults = newValue)
				.setTooltip(tooltip("pushable_vaults"))
				.build(),
			config.getClass(),
			"pushableVaults",
			configInstance
		);
		final var combatCategory = FrozenClothConfig.createSubCategory(entryBuilder, category, text("combat"),
			false,
			tooltip("combat"),
			pushableCreakingHearts, pushableSpawners, pushableTrialSpawners, pushableVaults
		);

		// BUFFS
		final var pushableBeacons = FrozenClothConfig.syncedEntry(
			entryBuilder.startBooleanToggle(text("pushable_beacons"), modifiedConfig.pushableBeacons)
				.setDefaultValue(defaultConfig.pushableBeacons)
				.setSaveConsumer(newValue -> config.pushableBeacons = newValue)
				.setTooltip(tooltip("pushable_beacons"))
				.build(),
			config.getClass(),
			"pushableBeacons",
			configInstance
		);
		final var pushableConduits = FrozenClothConfig.syncedEntry(
			entryBuilder.startBooleanToggle(text("pushable_conduits"), modifiedConfig.pushableConduits)
				.setDefaultValue(defaultConfig.pushableConduits)
				.setSaveConsumer(newValue -> config.pushableConduits = newValue)
				.setTooltip(tooltip("pushable_conduits"))
				.build(),
			config.getClass(),
			"pushableConduits",
			configInstance
		);
		final var buffCategory = FrozenClothConfig.createSubCategory(entryBuilder, category, text("buff"),
			false,
			tooltip("buff"),
			pushableBeacons, pushableConduits
		);

		// OTHER
		final var pushableBeehives = FrozenClothConfig.syncedEntry(
			entryBuilder.startBooleanToggle(text("pushable_beehives"), modifiedConfig.pushableBeehives)
				.setDefaultValue(defaultConfig.pushableBeehives)
				.setSaveConsumer(newValue -> config.pushableBeehives = newValue)
				.setTooltip(tooltip("pushable_beehives"))
				.build(),
			config.getClass(),
			"pushableBeehives",
			configInstance
		);
		final var pushableCampfires = FrozenClothConfig.syncedEntry(
			entryBuilder.startBooleanToggle(text("pushable_campfires"), modifiedConfig.pushableCampfires)
				.setDefaultValue(defaultConfig.pushableCampfires)
				.setSaveConsumer(newValue -> config.pushableCampfires = newValue)
				.setTooltip(tooltip("pushable_campfires"))
				.build(),
			config.getClass(),
			"pushableCampfires",
			configInstance
		);
		final var pushableSigns = FrozenClothConfig.syncedEntry(
			entryBuilder.startBooleanToggle(text("pushable_signs"), modifiedConfig.pushableSigns)
				.setDefaultValue(defaultConfig.pushableSigns)
				.setSaveConsumer(newValue -> config.pushableSigns = newValue)
				.setTooltip(tooltip("pushable_signs"))
				.build(),
			config.getClass(),
			"pushableSigns",
			configInstance
		);
		final var otherCategory = FrozenClothConfig.createSubCategory(entryBuilder, category, text("other"),
			false,
			tooltip("other"),
			pushableBeehives, pushableCampfires, pushableSigns
		);

		// WILDER WILD
		if (WILDERWILD) {
			final var pushableGeysers = FrozenClothConfig.syncedEntry(
				entryBuilder.startBooleanToggle(text("pushable_geysers"), modifiedConfig.pushableGeysers)
					.setDefaultValue(defaultConfig.pushableGeysers)
					.setSaveConsumer(newValue -> config.pushableGeysers = newValue)
					.setTooltip(tooltip("pushable_geysers"))
					.build(),
				config.getClass(),
				"pushableGeysers",
				configInstance
			);
			final var wilderWildCategory = FrozenClothConfig.createSubCategory(entryBuilder, category, text("wilderwild"),
				false,
				tooltip("wilderwild"),
				pushableGeysers
			);
		}

		// TRAILIER TALES
		if (TRAILIERTALES) {
			final var pushableSurveyors = FrozenClothConfig.syncedEntry(
				entryBuilder.startBooleanToggle(text("pushable_surveyors"), modifiedConfig.pushableSurveyors)
					.setDefaultValue(defaultConfig.pushableSurveyors)
					.setSaveConsumer(newValue -> config.pushableSurveyors = newValue)
					.setTooltip(tooltip("pushable_surveyors"))
					.build(),
				config.getClass(),
				"pushableSurveyors",
				configInstance
			);
			final var trailierTalesCategory = FrozenClothConfig.createSubCategory(entryBuilder, category, text("trailiertales"),
				false,
				tooltip("trailiertales"),
				pushableSurveyors
			);
		}

		// NETHERIER NETHER
		if (NETHERIERNETHER) {
			final var pushableNetherReactorCores = FrozenClothConfig.syncedEntry(
				entryBuilder.startBooleanToggle(text("pushable_nether_reactor_cores"), modifiedConfig.pushableNetherReactorCores)
					.setDefaultValue(defaultConfig.pushableNetherReactorCores)
					.setSaveConsumer(newValue -> config.pushableNetherReactorCores = newValue)
					.setTooltip(tooltip("pushable_nether_reactor_cores"))
					.build(),
				config.getClass(),
				"pushableNetherReactorCores",
				configInstance
			);
			final var netherierNetherCategory = FrozenClothConfig.createSubCategory(entryBuilder, category, text("netheriernether"),
				false,
				tooltip("netheriernether"),
				pushableNetherReactorCores
			);
		}

		// SIMPLE COPPER PIPES
		if (SIMPLE_COPPER_PIPES) {
			final var pushableCopperPipes = FrozenClothConfig.syncedEntry(
				entryBuilder.startBooleanToggle(text("pushable_copper_pipes"), modifiedConfig.pushableCopperPipes)
					.setDefaultValue(defaultConfig.pushableCopperPipes)
					.setSaveConsumer(newValue -> config.pushableCopperPipes = newValue)
					.setTooltip(tooltip("pushable_copper_pipes"))
					.build(),
				config.getClass(),
				"pushableCopperPipes",
				configInstance
			);
			final var pushableCopperFittings = FrozenClothConfig.syncedEntry(
				entryBuilder.startBooleanToggle(text("pushable_copper_fittings"), modifiedConfig.pushableCopperFittings)
					.setDefaultValue(defaultConfig.pushableCopperFittings)
					.setSaveConsumer(newValue -> config.pushableCopperFittings = newValue)
					.setTooltip(tooltip("pushable_copper_fittings"))
					.build(),
				config.getClass(),
				"pushableCopperFittings",
				configInstance
			);
			final var simpleCopperPipesCategory = FrozenClothConfig.createSubCategory(entryBuilder, category, text("simple_copper_pipes"),
				false,
				tooltip("simple_copper_pipes"),
				pushableCopperPipes, pushableCopperFittings
			);
		}
	}

	public static Screen buildScreen(Screen parent) {
		final var configBuilder = ConfigBuilder.create().setParentScreen(parent).setTitle(text("component.title"));
		configBuilder.setSavingRunnable(PPConfig.INSTANCE::save);
		final var config = configBuilder.getOrCreateCategory(text("config"));
		final ConfigEntryBuilder entryBuilder = configBuilder.entryBuilder();
		setupEntries(config, entryBuilder);
		return configBuilder.build();
	}

	@Contract(value = "_ -> new", pure = true)
	public static Component text(String key) {
		return Component.translatable("option." + PPConstants.MOD_ID + "." + key);
	}

	@Contract(value = "_ -> new", pure = true)
	public static Component tooltip(String key) {
		return Component.translatable("tooltip." + PPConstants.MOD_ID + "." + key);
	}

	@Contract(value = "_ -> new", pure = true)
	public static Component enumNameProvider(String key) {
		return Component.translatable("enum." + PPConstants.MOD_ID + "." + key);
	}
}
