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

import com.mojang.serialization.Codec;
import net.minecraft.util.StringRepresentable;

public enum ChainstoneType implements StringRepresentable {
	DISABLED("disabled"),
	CHAIN_FACING_INTO("chain_facing_into"),
	CHAINS_ALONG_SAME_AXIS("chains_along_same_axis"),
	ADJACENT_CHAINS_FACING_INTO("adjacent_chains_facing_into");
	public static final Codec<ChainstoneType> CODEC = StringRepresentable.fromEnum(ChainstoneType::values);
	private final String name;

	ChainstoneType(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public String getSerializedName() {
		return this.name;
	}
}
