package com.froxynetwork.froxyapi;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.froxynetwork.froxyapi.command.Command;
import com.froxynetwork.froxyapi.command.CommandManager;
import com.froxynetwork.froxyapi.inventory.Inventory;
import com.froxynetwork.froxyapi.inventory.InventoryManager;
import com.froxynetwork.froxyapi.inventory.InventoryProvider;
import com.froxynetwork.froxyapi.language.LanguageManager;
import com.froxynetwork.froxyapi.language.Languages;
import com.froxynetwork.froxyapi.player.PlayerManager;

/**
 * FroxyAPI
 * 
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
 * Interface for all methods (like {@link Server} for Spigot)
 */
public interface API {

	/**
	 * Register specific plugin as the game
	 */
	public void register(JavaPlugin plugin);

	/**
	 * @return The JavaPlugin implementation of the Core plugin
	 */
	public JavaPlugin getCorePlugin();

	/**
	 * @return The JavaPlugin implementation of the Game plugin
	 */
	public JavaPlugin getGamePlugin();
	
	/**
	 * @return The id of this server
	 */
	public String getId();
	
	/**
	 * @return The name of this server
	 */
	public String getName();
	
	/**
	 * @return The type of this server
	 */
	public String getType();

	/**
	 * @return The creation time of this server
	 */
	public Date getCreationTime();
	
	/**
	 * @return The version of the actual Core
	 */
	public String getVersion();

	// -----------------------------------------
	//
	// 				Language Manager
	//
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
	 * @param id     The id of the message
	 * @param params The parameters
	 * @return The message translated by default language, or the id if message id
	 *         doesn't exist
	 */
	public default String $(String id, String... params) {
		return getLanguageManager().$(id, params);
	}

	/**
	 * Get the translation of specific message id with specific language. If message
	 * id not found, return the translation with DEFAULT language
	 * 
	 * @param id     The id of the message
	 * @param lang   The specific language
	 * @param params The parameters
	 * @return The message translated by specific language, or the message
	 *         translated by default language, or the id if message id doesn't exist
	 */
	public default String $(String id, Languages lang, String... params) {
		return getLanguageManager().$(id, lang, params);
	}

	/**
	 * Get the translate of specific id with specific language
	 * 
	 * @param id     The id of the message
	 * @param lang   The specific language
	 * @param params The parameters
	 * @return The message translated by specific language, or the id if message id
	 *         doesn't exist
	 */
	public default String $_(String id, Languages lang, String... params) {
		return getLanguageManager().$_(id, lang, params);
	}

	// -----------------------------------------
	// | 
	// | 			Command Manager
	// | 
	// -----------------------------------------

	/**
	 * @return The CommandManager
	 */
	public CommandManager getCommandManager();

	/**
	 * Register a command
	 * 
	 * @param cmd The command
	 */
	public default void registerCommand(Command cmd) {
		getCommandManager().registerCommand(cmd);
	}

	/**
	 * Unregister a command
	 * 
	 * @param cmd The command
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
	// |
	// | 			Inventory Manager
	// |
	// -----------------------------------------

	/**
	 * @return The InventoryManager
	 */
	public InventoryManager getInventoryManager();

	/**
	 * Create an Inventory and open it
	 * 
	 * @param provider The provider
	 * @param player   The player
	 * @return An inventory
	 */
	public default Inventory openInventory(InventoryProvider provider, Player player) {
		return getInventoryManager().openInventory(provider, player);
	}

	/**
	 * @param p Player to check
	 * 
	 * @return true if specific Player has an opened inventory
	 */
	public default boolean hasInventoryOpened(Player p) {
		return getInventoryManager().hasInventoryOpened(p);
	}

	/**
	 * @param p Specific player
	 * @return The inventory of specific Player. Null if not opened
	 */
	public default Inventory getInventory(Player p) {
		return getInventoryManager().getInventory(p);
	}

	/**
	 * Close player's inventory.<br />
	 * Same as <code>p.closeInventory();</code>
	 * 
	 * @param p The player
	 */
	public default void closeInventory(Player p) {
		getInventoryManager().closeInventory(p);
	}

	// -----------------------------------------
	// |
	// | 			Player Manager
	// |
	// -----------------------------------------

	/**
	 * @return The PlayerManager
	 */
	public PlayerManager getPlayerManager();

	/**
	 * @param name The name of the player
	 * @return The player or null if not found
	 */
	public default com.froxynetwork.froxyapi.player.Player getPlayer(String name) {
		return getPlayerManager().getPlayer(name);
	}

	/**
	 * @param uuid The uuid of the player
	 * @return The player or null if not found
	 */
	public default com.froxynetwork.froxyapi.player.Player getPlayer(UUID uuid) {
		return getPlayerManager().getPlayer(uuid);
	}

	/**
	 * @return An immutable list containing all players
	 */
	public default List<? extends com.froxynetwork.froxyapi.player.Player> getPlayers() {
		return getPlayerManager().getPlayers();
	}

	/**
	 * Edit kill time. Set to -1 to keep last kill or 0 to disable it
	 * 
	 * @param time The new time in seconds
	 */
	public default void setKillTime(int time) {
		getPlayerManager().setKillTime(time);
	}

	/**
	 * @return The current kill time
	 */
	public default int getKillTime() {
		return getPlayerManager().getKillTime();
	}

	/**
	 * Edit assist time. Set to -1 to keep all assists or 0 to disable it
	 * 
	 * @param time The new time in seconds
	 */
	public default void setAssistTime(int time) {
		getPlayerManager().setAssistTime(time);
	}

	/**
	 * @return The current assist time
	 */
	public default int getAssistTime() {
		return getPlayerManager().getAssistTime();
	}
}
