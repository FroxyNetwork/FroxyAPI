package com.froxynetwork.froxyapi.command;

import static com.froxynetwork.froxyapi.Froxy.$;

import org.bukkit.entity.Player;

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
	 * @param cmd
	 *            The command
	 * @param p
	 *            The player
	 * @param args
	 *            The args
	 * 
	 * @return true if no errors
	 */
	public boolean execute(String cmd, Player p, String[] args);

	/**
	 * Method to call when a player doesn't have permission to execute a command
	 * 
	 * @param sender
	 *            The player
	 */
	public default void noPermission(Player sender) {
		// TODO Change that
		String msg = $("command.nopermission");
		sender.sendMessage(msg);
	}

	/**
	 * Method to call when there is a syntax error
	 * 
	 * @param player
	 *            The player
	 * @param syntax
	 *            The correct syntax
	 */
	public default void syntaxError(Player sender, String syntax) {
		String msg = $("command.syntaxerror", syntax);
		sender.sendMessage(msg);
	}
}
