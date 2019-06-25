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
		if (row < 1 || row > 6)
			throw new IllegalArgumentException("row must be between 1 and the maximum number of rows");
		// 10 - col because width starts with 1 and not 0
		if (width < 1 || width > 10 - col)
			throw new IllegalArgumentException("The width must be between 1 and " + (10 - col));
		if (height < 1 || height > getRows() + 1 - col)
			throw new IllegalArgumentException("The height must be between 1 and " + (getRows() + 1 - col));
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
			throw new IllegalArgumentException("col must be between 1 and 9");
		if (row < 1 || row > 6)
			throw new IllegalArgumentException("row must be between 1 and the maximum number of rows");
		// 10 - col because width starts with 1 and not 0
		if (width < 1 || width > 10 - col)
			throw new IllegalArgumentException("The width must be between 1 and " + (10 - col));
		if (height < 1 || height > getRows() + 1 - col)
			throw new IllegalArgumentException("The height must be between 1 and " + (getRows() + 1 - col));
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
