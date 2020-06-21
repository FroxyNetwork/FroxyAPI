package com.froxynetwork.froxyapi.inventory;

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
 * Interface for the Inventory Manager.<br />
 * With this interface, you can manage inventory
 */
public interface InventoryManager {

	/**
	 * Create an Inventory and open it
	 * 
	 * @param provider
	 *            The provider
	 * @param player
	 *            The player
	 * @return An inventory
	 */
	public Inventory openInventory(InventoryProvider provider, Player player);

	/**
	 * @param p
	 *            Player to check
	 * 
	 * @return true if specific Player has an opened inventory
	 */
	public boolean hasInventoryOpened(Player p);

	/**
	 * @param p
	 *            Specific player
	 * @return The inventory of specific Player. Null if not opened
	 */
	public Inventory getInventory(Player p);

	/**
	 * Close player's inventory.<br />
	 * Same as <code>p.closeInventory();</code>
	 * 
	 * @param p
	 *            The player
	 */
	public default void closeInventory(Player p) {
		p.closeInventory();
	}
}
