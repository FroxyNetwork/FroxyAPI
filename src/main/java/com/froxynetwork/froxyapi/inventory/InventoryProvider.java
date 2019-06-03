package com.froxynetwork.froxyapi.inventory;

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
 * An Inventory Provider<br />
 * The implementation of this class will create the inventory for the specific
 * player.
 */
public interface InventoryProvider {

	/**
	 * Return the title of the inventory.<br />
	 * This method is called only when an inventory opens.
	 * 
	 * @param inv
	 *            The inventory
	 * @return The title of the inventory
	 */
	public String title(Inventory inv);

	/**
	 * @param inv
	 *            The inventory
	 * 
	 * @return The number of rows. Must be between 1 and 6
	 */
	public int rows(Inventory inv);

	/**
	 * Method called to initialize an Inventory
	 * 
	 * @param inv
	 *            The specific inventory
	 */
	public void init(Inventory inv);

	/**
	 * Method called each ticks to update an Inventory
	 * 
	 * @param inv
	 *            The Inventory
	 */
	public void update(Inventory inv);
}
