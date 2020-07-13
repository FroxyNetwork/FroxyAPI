package com.froxynetwork.froxyapi.inventory;

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
 * An Inventory Provider<br />
 * The implementation of this class will create the inventory for the specific
 * player.
 */
public interface InventoryProvider {

	/**
	 * Return the title of the inventory.<br />
	 * This method is called only when an inventory opens.
	 * 
	 * @param inv The inventory
	 * @return The title of the inventory
	 */
	public String title(Inventory inv);

	/**
	 * @param inv The inventory
	 * 
	 * @return The number of rows. Must be between 1 and 6
	 */
	public int rows(Inventory inv);

	/**
	 * Method called to initialize an Inventory
	 * 
	 * @param inv The specific inventory
	 */
	public void init(Inventory inv);

	/**
	 * Method called each ticks to update an Inventory
	 * 
	 * @param inv The Inventory
	 */
	public void update(Inventory inv);
}
