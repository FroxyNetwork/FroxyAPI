package com.froxynetwork.froxyapi.language;

import java.io.File;

/**
 * FroxyAPI
 * Copyright (C) 2019 FroxyNetwork
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * @author 0ddlyoko
 */
/**
 * Interface for the Language Manager.<br />
 * With this interface, you can manage language
 */
public interface LanguageManager {

	/**
	 * @return The default language of the server
	 */
	public Languages getDefaultLanguage();

	/**
	 * Register a path as a language directory.<br />
	 * All language files MUST have the correct name to be loaded.<br />
	 * Files name MUST be of this form: "{name}.lang".<br />
	 * Example: <code>fr_FR.lang or en_US.lang</code>
	 * 
	 * @param path The directory
	 */
	public void register(File path);

	/**
	 * Get the default translate of specific message id.<br />
	 * Same as <code>$(id, getDefaultLanguage(), params)</code>
	 * 
	 * @param id The id of the message
	 * @param params The parameters
	 * @return The message translated by default language, or the id if message id doesn't exist
	 */
	public default String $(String id, String... params) {
		return $(id, getDefaultLanguage(), params);
	}

	/**
	 * Get the translation of specific message id with specific language. If message id not found, return the translation with DEFAULT language
	 * 
	 * @param id The id of the message
	 * @param lang The specific language
	 * @param params The parameters
	 * @return The message translated by specific language, or the message translated by default language, or the id if message id doesn't exist
	 */
	public String $(String id, Languages lang, String... params);

	/**
	 * Get the translate of specific id with specific language
	 * 
	 * @param id The id of the message
	 * @param lang The specific language
	 * @param params The parameters
	 * @return The message translated by specific language, or the id if message id doesn't exist
	 */
	public String $_(String id, Languages lang, String... params);
}
