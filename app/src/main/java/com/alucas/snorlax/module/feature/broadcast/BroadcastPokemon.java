/*
 * Copyright (c) 2016. Pedro Diaz <igoticecream@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alucas.snorlax.module.feature.broadcast;

import java.util.List;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
@SuppressWarnings({"unused", "FieldCanBeLocal", "WeakerAccess"})
public abstract class BroadcastPokemon {

	static BroadcastPokemon create(@Nullable List<BroadcastPokemonMap> maps, @Nullable List<BroadcastPokemonWild> wilds, @Nullable List<BroadcastPokemonNearby> nearbies, @Nullable List<BroadcastPokemonDisk> disks) {
		return new AutoValue_BroadcastPokemon(wilds, maps, nearbies, disks);
	}

	public static TypeAdapter<BroadcastPokemon> typeAdapter(Gson gson) {
		return new AutoValue_BroadcastPokemon.GsonTypeAdapter(gson);
	}

	boolean hasData() {
		return getWildPokemons() != null && getWildPokemons().size() > 0 || getMapPokemons() != null && getMapPokemons().size() > 0 || getNearbyPokemons() != null && getNearbyPokemons().size() > 0 || getDiskPokemons() != null && getDiskPokemons().size() > 0;
	}

	@SerializedName("wild")
	@Nullable
	abstract List<BroadcastPokemonWild> getWildPokemons();

	@SerializedName("map")
	@Nullable
	abstract List<BroadcastPokemonMap> getMapPokemons();

	@SerializedName("nearby")
	@Nullable
	abstract List<BroadcastPokemonNearby> getNearbyPokemons();

	@SerializedName("disk")
	@Nullable
	abstract List<BroadcastPokemonDisk> getDiskPokemons();
}
