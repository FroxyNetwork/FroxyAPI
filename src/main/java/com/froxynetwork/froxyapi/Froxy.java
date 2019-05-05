package com.froxynetwork.froxyapi;

import java.io.File;
import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;
import org.slf4j.Logger;

import com.froxynetwork.froxyapi.command.Command;
import com.froxynetwork.froxyapi.command.CommandManager;
import com.froxynetwork.froxyapi.language.LanguageManager;
import com.froxynetwork.froxyapi.language.Languages;

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
 * Represents the API core, for version and API singleton handling
 */
public final class Froxy {

	private static API api;

	private Froxy() {
	}

	/**
	 * Gets the current {@link API} singleton
	 *
	 * @return API instance being ran
	 */
	public static API getAPI() {
		return api;
	}

	/**
	 * Attempts to set the {@link API} singleton.
	 * <p>
	 * This cannot be done if the API is already set.
	 *
	 * @param api API instance
	 */
	public static void setAPI(API api) {
		if (Froxy.api != null)
			throw new UnsupportedOperationException("Cannot redefine singleton API");
		Froxy.api = api;
		api.getLogger().info("");
	}

	/**
	 * @return The JavaPlugin implementation of the Core plugin
	 */
	public static JavaPlugin getCorePlugin() {
		return api.getCorePlugin();
	}

	/**
	 * @return The JavaPlugin implementation of the Game plugin
	 */
	public static JavaPlugin getGamePlugin() {
		return api.getGamePlugin();
	}

	/**
	 * @return The version of the actual Core
	 */
	public static String getVersion() {
		return api.getVersion();
	}

	/**
	 * @return The logger
	 */
	public static Logger getLogger() {
		return api.getLogger();
	}

	// -----------------------------------------
	// |                                       |
	// |           Language Manager            |
	// |                                       |
	// -----------------------------------------

	/**
	 * @return The LanguageManager
	 */
	public static LanguageManager getLanguageManager() {
		return api.getLanguageManager();
	}

	/**
	 * @return The default language
	 */
	public static Languages getDefaultLanguage() {
		return api.getDefaultLanguage();
	}

	/**
	 * Register a path as a language directory.<br />
	 * All language files MUST have the correct name to be loaded.<br />
	 * Files name MUST be of this form: "{name}.lang".<br />
	 * Example: <code>fr_FR.lang or en_US.lang</code>
	 * 
	 * @param path The directory
	 */
	public static void register(File path) {
		api.register(path);
	}

	/**
	 * Get the default translate of specific message id.<br />
	 * Same as <code>$(id, getDefaultLanguage(), params)</code>
	 * 
	 * @param id The id of the message
	 * @param params The parameters
	 * @return The message translated by default language, or the id if message id doesn't exist
	 */
	public static String $(String id, String... params) {
		return api.$(id, params);
	}

	/**
	 * Get the translation of specific message id with specific language. If message id not found, return the translation with DEFAULT language
	 * 
	 * @param id The id of the message
	 * @param lang The specific language
	 * @param params The parameters
	 * @return The message translated by specific language, or the message translated by default language, or the id if message id doesn't exist
	 */
	public static String $(String id, Languages lang, String... params) {
		return api.$(id, lang, params);
	}

	/**
	 * Get the translate of specific id with specific language
	 * 
	 * @param id The id of the message
	 * @param lang The specific language
	 * @param params The parameters
	 * @return The message translated by specific language, or the id if message id doesn't exist
	 */
	public static String $_(String id, Languages lang, String... params) {
		return api.$_(id, lang, params);
	}
	

	// -----------------------------------------
	// |                                       |
	// |            Command Manager            |
	// |                                       |
	// -----------------------------------------
	
	/**
	 * @return The CommandManager
	 */
	public static CommandManager getCommandManager() {
		return api.getCommandManager();
	}

	/**
	 * Register a command
	 * 
	 * @param cmd
	 *            The command
	 */
	public static void registerCommand(Command cmd) {
		api.registerCommand(cmd);
	}

	/**
	 * Unregister a command
	 * 
	 * @param cmd
	 *            The command
	 */
	public static void unregisterCommand(Command cmd) {
		api.unregisterCommand(cmd);
	}

	/**
	 * @return All commands
	 */
	public static List<Command> getCommands() {
		return api.getCommands();
	}

	// -----------------------------------------
	// |                                       |
	// |                 Other                 |
	// |                                       |
	// -----------------------------------------
}
