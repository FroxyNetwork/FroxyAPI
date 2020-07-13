package com.froxynetwork.froxyapi.player;

import java.util.List;
import java.util.UUID;

/**
 * FroxyAPI
 * 
 * Copyright (C) 2020 FroxyNetwork
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 *
 * @author 0ddlyoko
 */
public interface PlayerManager {

	/**
	 * @param name The name of the player
	 * @return The player or null if not found
	 */
	public Player getPlayer(String name);

	/**
	 * @param uuid The uuid of the player
	 * @return The player or null if not found
	 */
	public Player getPlayer(UUID uuid);

	/**
	 * @return An immutable list containing all players
	 */
	public List<? extends Player> getPlayers();

	/**
	 * Edit kill time. Set to -1 to keep last kill or 0 to disable it
	 * 
	 * @param time The new time in seconds
	 */
	public void setKillTime(int time);

	/**
	 * @return The current kill time
	 */
	public int getKillTime();

	/**
	 * Edit assist time. Set to -1 to keep all assists or 0 to disable it
	 * 
	 * @param time The new time in seconds
	 */
	public void setAssistTime(int time);

	/**
	 * @return The current assist time
	 */
	public int getAssistTime();
}
