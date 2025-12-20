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

package net.frozenblock.pushierpistons.datagen.tag;

import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.frozenblock.lib.tag.api.FrozenBlockTags;
import net.frozenblock.pushierpistons.tag.PPBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public final class PPBlockTagProvider extends FabricTagProvider.BlockTagProvider {

	public PPBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registries) {
		super(output, registries);
	}

	@Override
	protected void addTags(HolderLookup.Provider registries) {
		this.valueLookupBuilder(FrozenBlockTags.HAS_PUSHABLE_BLOCK_ENTITY)
			// STORAGE
			.addOptionalTag(PPBlockTags.PUSHABLE_CHESTS)
			.addOptionalTag(PPBlockTags.PUSHABLE_BARRELS)
			.addOptionalTag(PPBlockTags.PUSHABLE_CHISELED_BOOKSHELVES)
			// UTILITY
			.addOptionalTag(PPBlockTags.PUSHABLE_FURNACES)
			.addOptionalTag(PPBlockTags.PUSHABLE_BREWING_STANDS)
			.addOptionalTag(PPBlockTags.PUSHABLE_ENCHANTING_TABLES)
			// REDSTONE
			.addOptionalTag(PPBlockTags.PUSHABLE_ITEM_TRANSPORTERS)
			.addOptionalTag(PPBlockTags.PUSHABLE_EJECTORS)
			.addOptionalTag(PPBlockTags.PUSHABLE_CRAFTERS)
			.addOptionalTag(PPBlockTags.PUSHABLE_DAYLIGHT_DETECTORS)
			// COMBAT
			.addOptionalTag(PPBlockTags.PUSHABLE_SPAWNERS)
			.addOptionalTag(PPBlockTags.PUSHABLE_TRIAL_SPAWNERS)
			.addOptionalTag(PPBlockTags.PUSHABLE_VAULTS)
			// BUFFS
			.addOptionalTag(PPBlockTags.PUSHABLE_BEACONS)
			.addOptionalTag(PPBlockTags.PUSHABLE_CONDUITS)
			// OTHER
			.addOptionalTag(PPBlockTags.PUSHABLE_BEEHIVES)
			.addOptionalTag(PPBlockTags.PUSHABLE_CAMPFIRES)
			// WILDER WILD
			.addOptionalTag(PPBlockTags.PUSHABLE_GEYSERS)
			// TRAILIER TALES
			.addOptionalTag(PPBlockTags.PUSHABLE_SURVEYORS)
			// NETHERIER NETHER
			.addOptionalTag(PPBlockTags.PUSHABLE_NETHER_REACTOR_CORES)
			// SIMPLE COPPER PIPES
			.addOptionalTag(PPBlockTags.PUSHABLE_COPPER_PIPES)
			.addOptionalTag(PPBlockTags.PUSHABLE_COPPER_FITTINGS);

		// STORAGE
		this.valueLookupBuilder(PPBlockTags.PUSHABLE_CHESTS)
			.addOptionalTag(ConventionalBlockTags.CHESTS);

		this.valueLookupBuilder(PPBlockTags.PUSHABLE_BARRELS)
			.addOptionalTag(ConventionalBlockTags.BARRELS);

		this.valueLookupBuilder(PPBlockTags.PUSHABLE_CHISELED_BOOKSHELVES)
			.add(Blocks.CHISELED_BOOKSHELF);

		// UTILITY
		this.valueLookupBuilder(PPBlockTags.PUSHABLE_FURNACES)
			.add(Blocks.FURNACE, Blocks.BLAST_FURNACE, Blocks.SMOKER);

		this.valueLookupBuilder(PPBlockTags.PUSHABLE_BREWING_STANDS)
			.add(Blocks.BREWING_STAND);

		this.valueLookupBuilder(PPBlockTags.PUSHABLE_ENCHANTING_TABLES)
			.add(Blocks.ENCHANTING_TABLE);

		// REDSTONE
		this.valueLookupBuilder(PPBlockTags.PUSHABLE_ITEM_TRANSPORTERS)
			.add(Blocks.HOPPER);

		this.valueLookupBuilder(PPBlockTags.PUSHABLE_EJECTORS)
			.add(Blocks.DISPENSER, Blocks.DROPPER);

		this.valueLookupBuilder(PPBlockTags.PUSHABLE_CRAFTERS)
			.add(Blocks.CRAFTER);

		this.valueLookupBuilder(PPBlockTags.PUSHABLE_DAYLIGHT_DETECTORS)
			.add(Blocks.DAYLIGHT_DETECTOR);

		// COMBAT
		this.valueLookupBuilder(PPBlockTags.PUSHABLE_SPAWNERS)
			.add(Blocks.SPAWNER);

		this.valueLookupBuilder(PPBlockTags.PUSHABLE_TRIAL_SPAWNERS)
			.add(Blocks.TRIAL_SPAWNER);

		this.valueLookupBuilder(PPBlockTags.PUSHABLE_VAULTS)
			.add(Blocks.VAULT);

		// BUFFS
		this.valueLookupBuilder(PPBlockTags.PUSHABLE_BEACONS)
			.add(Blocks.BEACON);

		this.valueLookupBuilder(PPBlockTags.PUSHABLE_CONDUITS)
			.add(Blocks.CONDUIT);

		// OTHER
		this.valueLookupBuilder(PPBlockTags.PUSHABLE_BEEHIVES)
			.addOptionalTag(BlockTags.BEEHIVES);

		this.valueLookupBuilder(PPBlockTags.PUSHABLE_CAMPFIRES)
			.addOptionalTag(BlockTags.CAMPFIRES);

		// WILDER WILD
		this.builder(PPBlockTags.PUSHABLE_GEYSERS)
			.addOptional(getKey("wilderwild", "geyser"));

		// TRAILIER TALES
		this.builder(PPBlockTags.PUSHABLE_SURVEYORS)
			.addOptional(getKey("trailiertales", "surveyor"));

		// NETHERIER NETHER
		this.builder(PPBlockTags.PUSHABLE_NETHER_REACTOR_CORES)
			.addOptional(getKey("netheriernether", "nether_reactor_core"));

		// SIMPLE_COPPER_PIPES
		this.builder(PPBlockTags.PUSHABLE_COPPER_PIPES)
			.addOptionalTag(getTag("simple_copper_pipes", "copper_pipes"));

		this.builder(PPBlockTags.PUSHABLE_COPPER_FITTINGS)
			.addOptionalTag(getTag("simple_copper_pipes", "copper_fittings"));

		// EXCLUSIONS
		this.valueLookupBuilder(PPBlockTags.EXCLUDED_BLOCK_ENTITIES)
			.add(Blocks.END_PORTAL, Blocks.END_GATEWAY);

		this.builder(PPBlockTags.EXCLUDED_BLOCK_ENTITIES)
			.addOptional(getKey("trailiertales", "coffin"));

		// CHAINSTONE
		this.valueLookupBuilder(PPBlockTags.CHAINSTONE_BLOCKS)
			.addOptionalTag(ConventionalBlockTags.CHAINS)
			.addOptionalTag(BlockTags.CHAINS);
	}

	private TagKey<Block> getTag(String namespace, String path) {
		return TagKey.create(this.registryKey, ResourceLocation.fromNamespaceAndPath(namespace, path));
	}

	private ResourceKey<Block> getKey(String namespace, String path) {
		return ResourceKey.create(this.registryKey, ResourceLocation.fromNamespaceAndPath(namespace, path));
	}
}
