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

package com.alucas.snorlax.module.feature.rename;

import javax.inject.Inject;
import javax.inject.Singleton;

import android.content.res.Resources;

import com.alucas.snorlax.R;
import com.alucas.snorlax.module.context.snorlax.Snorlax;

import de.robv.android.xposed.XSharedPreferences;

@Singleton
final class RenamePreferences {

	private final Resources mResources;
	private final XSharedPreferences mPreferences;

	@Inject
	RenamePreferences(@Snorlax Resources resources, XSharedPreferences preferences) {
		mResources = resources;
		mPreferences = preferences;
	}

	String getFormat() {
		mPreferences.reload();

		return mPreferences.getString(
			mResources.getString(R.string.preference_rename_format_enable_key),
			mResources.getString(R.string.preference_rename_format_enable_default)
		);
	}

	boolean isEnabled() {
		mPreferences.reload();
		final boolean expected = mResources.getBoolean(R.bool.preference_rename_enable);
		return expected == mPreferences.getBoolean(mResources.getString(R.string.preference_rename_enable_key), expected);
	}

	boolean isFavoriteEnabled() {
		mPreferences.reload();
		final boolean expected = mResources.getBoolean(R.bool.preference_rename_favorite_enable);
		return expected == mPreferences.getBoolean(mResources.getString(R.string.preference_rename_favorite_enable_key), expected);
	}

	boolean isNicknamedEnabled() {
		mPreferences.reload();
		final boolean expected = mResources.getBoolean(R.bool.preference_rename_already_enable);
		return expected == mPreferences.getBoolean(mResources.getString(R.string.preference_rename_already_enable_key), expected);
	}
}
