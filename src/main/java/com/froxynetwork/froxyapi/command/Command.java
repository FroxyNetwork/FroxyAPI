package com.froxynetwork.froxyapi.command;

import static com.froxynetwork.froxyapi.Froxy.$;

import org.bukkit.entity.Player;

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
 * A command
 */
public interface Command {

	/**
	 * The name of the command
	 * 
	 * @return The name of the command
	 */
	public String getCommand();

	/**
	 * Aliases of command<br />
	 * Can be null
	 * 
	 * @return A list of aliases
	 */
	public String[] getAliases();

	/**
	 * Permission to execute specific command
	 * 
	 * @return Permission associated with specific command
	 */
	public String getPermission();

	/**
	 * Execute command
	 * 
	 * @param cmd  The command
	 * @param p    The player
	 * @param args The args
	 * 
	 * @return true if no errors
	 */
	public boolean execute(String cmd, Player p, String[] args);

	/**
	 * Method to call when a player doesn't have permission to execute a command
	 * 
	 * @param sender The player
	 */
	public default void noPermission(Player sender) {
		// TODO Change that
		String msg = $("command.nopermission");
		sender.sendMessage(msg);
	}

	/**
	 * Method to call when there is a syntax error
	 * 
	 * @param player The player
	 * @param syntax The correct syntax
	 */
	public default void syntaxError(Player sender, String syntax) {
		String msg = $("command.syntaxerror", syntax);
		sender.sendMessage(msg);
	}
}
