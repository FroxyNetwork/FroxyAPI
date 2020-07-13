package com.froxynetwork.froxyapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.froxynetwork.froxyapi.player.Player;

import lombok.Getter;

/**
 * FroxyAPI
 * 
 * Copyright (C) 2020 FroxyNetwork
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
 * Called when a player wants to leave or is leaving a server and he is
 * loaded.<br />
 * This event can be called either when a player wants to leave this server or
 * has already leaved this server.<br />
 * The saved method is automatically called after this event if datas have been
 * edited.<br />
 * This method isn't called if player leaves before {@link PlayerLoadEvent}
 */
public class PlayerUnloadEvent extends Event {
	private static final HandlerList handlers = new HandlerList();
	@Getter
	private Player player;

	public PlayerUnloadEvent(Player player) {
		this.player = player;
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
}
