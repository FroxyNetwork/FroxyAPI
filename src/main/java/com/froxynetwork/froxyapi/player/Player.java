package com.froxynetwork.froxyapi.player;

import static com.froxynetwork.froxyapi.Froxy.$;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;

import com.froxynetwork.froxyapi.language.Languages;

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
 * A player
 */
public interface Player {

	/**
	 * @return The Unique Identifier associated with this player
	 */
	public UUID getUUID();

	/**
	 * @return The real name (nickname) of this player
	 */
	public String getRealName();

	/**
	 * @return The display name of this player
	 */
	public String getDisplayName();

	/**
	 * @return The first time this player joined the server
	 */
	public Date getFirstLogin();

	/**
	 * @return The actual language of this player
	 */
	public Languages getLanguage();

	/**
	 * Send a plain message to this player if he's online
	 * 
	 * @param message The plain message to send
	 * 
	 * @deprecated This message is not converted to user's language
	 */
	@Deprecated
	public void sendMessage(String message);

	public default void sendLanguageMessage(String id, String... args) {
		sendMessage($(id, getLanguage(), args));
	}

	/**
	 * Retrieve the last player that killed this player x seconds before calling
	 * this method
	 * 
	 * @return Player that killed this player
	 */
	public UUID getKiller();

	/**
	 * Retrieve players that damaged this player x seconds before calling this
	 * method
	 * 
	 * @return Players that damages this player
	 */
	public List<UUID> getAssists();

	/**
	 * @return The Bukkit class associated with this player
	 */
	public default org.bukkit.entity.Player getBukkitPlayer() {
		return Bukkit.getPlayer(getUUID());
	}
}
