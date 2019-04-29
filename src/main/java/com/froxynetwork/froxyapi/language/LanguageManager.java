package com.froxynetwork.froxyapi.language;

import java.io.File;

/**
 * MIT License
 *
 * Copyright (c) 2019 FroxyNetwork
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
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
