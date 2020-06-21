package com.froxynetwork.froxyapi.command;

import java.util.List;

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
 * Interface for the Command Manager.<br />
 * With this interface, you can manage commands
 */
public interface CommandManager {

	/**
	 * Register a command
	 * 
	 * @param cmd
	 *            The command
	 */
	public void registerCommand(Command cmd);

	/**
	 * Unregister a command
	 * 
	 * @param cmd
	 *            The command
	 */
	public void unregisterCommand(Command cmd);

	/**
	 * @return All commands
	 */
	public List<Command> getCommands();
}
