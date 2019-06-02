package com.froxynetwork.froxyapi.inventory;

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
