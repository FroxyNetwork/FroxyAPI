package com.froxynetwork.froxyapi;

import java.io.File;
import java.util.List;

import org.bukkit.Server;
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
 * Interface for all methods (like {@link Server} for Spigot)
 */
public interface API {

	/**
	 * @return The JavaPlugin implementation of the Core plugin
	 */
	public JavaPlugin getCorePlugin();

	/**
	 * @return The JavaPlugin implementation of the Game plugin
	 */
	public JavaPlugin getGamePlugin();

	/**
	 * @return The version of the actual Core
	 */
	public String getVersion();

	/**
	 * @return The logger
	 */
	public Logger getLogger();

	// -----------------------------------------
	// |                                       |
	// |           Language Manager            |
	// |                                       |
	// -----------------------------------------

	/**
	 * @return The LanguageManager
	 */
	public LanguageManager getLanguageManager();

	/**
	 * @return The default language
	 */
	public default Languages getDefaultLanguage() {
		return getLanguageManager().getDefaultLanguage();
	}

	/**
	 * Register a path as a language directory.<br />
	 * All language files MUST have the correct name to be loaded.<br />
	 * Files name MUST be of this form: "{name}.lang".<br />
	 * Example: <code>fr_FR.lang or en_US.lang</code>
	 * 
	 * @param path The directory
	 */
	public default void register(File path) {
		getLanguageManager().register(path);
	}

	/**
	 * Get the default translate of specific message id.<br />
	 * Same as <code>$(id, getDefaultLanguage(), params)</code>
	 * 
	 * @param id The id of the message
	 * @param params The parameters
	 * @return The message translated by default language, or the id if message id doesn't exist
	 */
	public default String $(String id, String... params) {
		return getLanguageManager().$(id, params);
	}

	/**
	 * Get the translation of specific message id with specific language. If message id not found, return the translation with DEFAULT language
	 * 
	 * @param id The id of the message
	 * @param lang The specific language
	 * @param params The parameters
	 * @return The message translated by specific language, or the message translated by default language, or the id if message id doesn't exist
	 */
	public default String $(String id, Languages lang, String... params) {
		return getLanguageManager().$(id, lang, params);
	}

	/**
	 * Get the translate of specific id with specific language
	 * 
	 * @param id The id of the message
	 * @param lang The specific language
	 * @param params The parameters
	 * @return The message translated by specific language, or the id if message id doesn't exist
	 */
	public default String $_(String id, Languages lang, String... params) {
		return getLanguageManager().$_(id, lang, params);
	}
	

	// -----------------------------------------
	// |                                       |
	// |            Command Manager            |
	// |                                       |
	// -----------------------------------------
	
	/**
	 * @return The CommandManager
	 */
	public CommandManager getCommandManager();

	/**
	 * Register a command
	 * 
	 * @param cmd
	 *            The command
	 */
	public default void registerCommand(Command cmd) {
		getCommandManager().registerCommand(cmd);
	}

	/**
	 * Unregister a command
	 * 
	 * @param cmd
	 *            The command
	 */
	public default void unregisterCommand(Command cmd) {
		getCommandManager().unregisterCommand(cmd);
	}

	/**
	 * @return All commands
	 */
	public default List<Command> getCommands() {
		return getCommandManager().getCommands();
	}

	// -----------------------------------------
	// |                                       |
	// |                 Other                 |
	// |                                       |
	// -----------------------------------------

}
