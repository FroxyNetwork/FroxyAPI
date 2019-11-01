package com.froxynetwork.froxyapi;

import java.io.File;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.froxynetwork.froxyapi.command.Command;
import com.froxynetwork.froxyapi.command.CommandManager;
import com.froxynetwork.froxyapi.inventory.Inventory;
import com.froxynetwork.froxyapi.inventory.InventoryManager;
import com.froxynetwork.froxyapi.inventory.InventoryProvider;
import com.froxynetwork.froxyapi.language.LanguageManager;
import com.froxynetwork.froxyapi.language.Languages;

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
	// |          Inventory Manager            |
	// |                                       |
	// -----------------------------------------

	/**
	 * @return The InventoryManager
	 */
	public static InventoryManager getInventoryManager() {
		return api.getInventoryManager();
	}

	/**
	 * Create an Inventory and open it
	 * 
	 * @param provider
	 *            The provider
	 * @param player
	 *            The player
	 * @return An inventory
	 */
	public static Inventory openInventory(InventoryProvider provider, Player player) {
		return api.openInventory(provider, player);
	}

	/**
	 * @param p
	 *            Player to check
	 * 
	 * @return true if specific Player has an opened inventory
	 */
	public static boolean hasInventoryOpened(Player p) {
		return api.hasInventoryOpened(p);
	}

	/**
	 * @param p
	 *            Specific player
	 * @return The inventory of specific Player. Null if not opened
	 */
	public static Inventory getInventory(Player p) {
		return api.getInventory(p);
	}

	/**
	 * Close player's inventory.<br />
	 * Same as <code>p.closeInventory();</code>
	 * 
	 * @param p
	 *            The player
	 */
	public static void closeInventory(Player p) {
		api.closeInventory(p);
	}
}
