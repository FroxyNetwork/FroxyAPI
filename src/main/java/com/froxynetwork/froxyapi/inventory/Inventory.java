package com.froxynetwork.froxyapi.inventory;

import org.bukkit.entity.Player;

/**
 * FroxyAPI
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
 * An Inventory
 */
public interface Inventory {
	public static final String TICK = "tick";

	/**
	 * @return Specific player
	 */
	public Player getPlayer();

	/**
	 * @return Specific Inventory Provider
	 */
	public InventoryProvider getInventoryProvider();

	/**
	 * @return The number of rows
	 */
	public int getRows();

	/**
	 * Set an item at specific pos.<br />
	 * 
	 * @param col
	 *            The col. Must be between 1 and 9
	 * @param row
	 *            The row. Must be between 1 and the maximum number of rows
	 * @param item
	 *            The item
	 */
	public default void set(int col, int row, ClickableItem item) {
		if (col < 1 || col > 9)
			throw new IllegalArgumentException("col must be between 1 and 9");
		if (row < 1 || row > getRows())
			throw new IllegalArgumentException("row must be between 1 and " + getRows());
		set(locToPos(row, col), item);
	}

	/**
	 * Set an item at specific pos.<br />
	 * 
	 * @param pos
	 *            The position of the item. Must be between 0 and the maximum number
	 *            of case (9 * number of rows - 1)
	 * @param item
	 *            The item
	 */
	public void set(int pos, ClickableItem item);

	/**
	 * Fill the inventory with specific item
	 * 
	 * @param item
	 *            The item
	 */
	public void fill(ClickableItem item);

	/**
	 * Create a rectangle of items
	 * 
	 * @param row
	 *            The row. Must be between 1 and the maximum number of rows
	 * @param col
	 *            The col. Must be between 1 and 9
	 * @param width
	 *            The width. Must be between 1 and 9
	 * @param height
	 *            The height. Must be between 1 and the maximum number of rows
	 * @param item
	 *            The item
	 */
	public default void rectangle(int row, int col, int width, int height, ClickableItem item) {
		if (col < 1 || col > 9)
			throw new IllegalArgumentException("col must be between 1 and 9");
		if (row < 1 || row > getRows())
			throw new IllegalArgumentException("row must be between 1 and the maximum number of rows, but is " + row);
		// 10 - col because width starts with 1 and not 0
		if (width < 1 || width > 10 - col)
			throw new IllegalArgumentException("The width must be between 1 and " + (10 - col) + ", but is " + width);
		if (height < 1 || height > getRows() + 1 - row)
			throw new IllegalArgumentException("The height must be between 1 and " + (getRows() + 1 - row));
		rectangle(locToPos(row, col), width, height, item);
	}

	/**
	 * Create a rectangle of items
	 * 
	 * @param pos
	 *            The position of the item. Must be between 0 and the maximum number
	 *            of case (9 * number of rows - 1)
	 * @param width
	 *            The width. Must be between 1 and 9 and stay inside the inventory
	 * @param height
	 *            The height. Must be between 1 and the maximum number of rows and
	 *            stay inside the inventory
	 * @param item
	 *            The item
	 */
	public void rectangle(int pos, int width, int height, ClickableItem item);

	/**
	 * Create a rectangle of items and fill the rectangle
	 * 
	 * @param row
	 *            The row. Must be between 1 and the maximum number of rows
	 * @param col
	 *            The col. Must be between 1 and 9
	 * @param width
	 *            The width. Must be between 1 and 9
	 * @param height
	 *            The height. Must be between 1 and the maximum number of rows
	 * @param item
	 *            The item
	 */
	public default void fillRectangle(int row, int col, int width, int height, ClickableItem item) {
		if (col < 1 || col > 9)
			throw new IllegalArgumentException("col must be between 1 and 9, but is " + col);
		if (row < 1 || row > getRows())
			throw new IllegalArgumentException("row must be between 1 and the maximum number of rows, but is " + row);
		// 10 - col because width starts with 1 and not 0
		if (width < 1 || width > 10 - col)
			throw new IllegalArgumentException("The width must be between 1 and " + (10 - col) + ", but is " + width);
		if (height < 1 || height > getRows() + 1 - col)
			throw new IllegalArgumentException(
					"The height must be between 1 and " + (getRows() + 1 - col) + ", but is " + height);
		fillRectangle(locToPos(row, col), width, height, item);
	}

	/**
	 * Create a rectangle of items and fill the rectangle
	 * 
	 * @param pos
	 *            The position of the item. Must be between 0 and the maximum number
	 *            of case (9 * number of rows - 1)
	 * @param width
	 *            The width. Must be between 1 and 9 and stay inside the inventory
	 * @param height
	 *            The height. Must be between 1 and the maximum number of rows and
	 *            stay inside the inventory
	 * @param item
	 *            The item
	 */
	public void fillRectangle(int pos, int width, int height, ClickableItem item);

	/**
	 * Save a variable in the Inventory. If the key already exists, the old value is
	 * overrode.
	 * 
	 * @param key
	 *            The key
	 * @param value
	 *            The value
	 */
	public void save(String key, Object value);

	/**
	 * @param key
	 *            The key
	 * 
	 * @return Specific variable saved before in the Inventory. If key doesn't
	 *         exist, null is returned
	 */
	public Object get(String key);

	/**
	 * Transform a single position to two location
	 * 
	 * @param pos
	 *            The position
	 * @return an array of two integer: The row and the column
	 */
	public default int[] posToLoc(int pos) {
		return new int[] { (pos / 9) + 1, (pos % 9) + 1 };
	}

	/**
	 * Transform two location to a single position
	 * 
	 * @param row
	 *            The row
	 * @param col
	 *            The col
	 * @return The position
	 */
	public default int locToPos(int row, int col) {
		return (row - 1) * 9 + (col - 1);
	}
}
