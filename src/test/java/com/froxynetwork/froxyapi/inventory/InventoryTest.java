package com.froxynetwork.froxyapi.inventory;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.bukkit.entity.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * FroxyAPI
 * 
 * Copyright (C) 2019 FroxyNetwork
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
@RunWith(MockitoJUnitRunner.class)
public class InventoryTest {

	@Test
	public void testPosToLoc() {
		Inventory inv = new Inventory() {
			@Override
			public void set(int pos, ClickableItem item) {
			}

			@Override
			public void save(String key, Object value) {
			}

			@Override
			public void rectangle(int col, int row, int width, int height, ClickableItem item) {
			}

			@Override
			public void rectangle(int pos, int width, int height, ClickableItem item) {
			}

			@Override
			public void fillRectangle(int col, int row, int width, int height, ClickableItem item) {
			}

			@Override
			public void fillRectangle(int pos, int width, int height, ClickableItem item) {
			}

			@Override
			public int getRows() {
				return 0;
			}

			@Override
			public Player getPlayer() {
				return null;
			}

			@Override
			public InventoryProvider getInventoryProvider() {
				return null;
			}

			@Override
			public Object get(String key) {
				return null;
			}

			@Override
			public void fill(ClickableItem item) {
			}
		};

		for (int i = 0; i < 9; i++)
			assertArrayEquals(new int[] { 1, i + 1 }, inv.posToLoc(i));
		for (int i = 0; i < 9; i++)
			assertArrayEquals(new int[] { 2, i + 1 }, inv.posToLoc(i + 9));
		for (int i = 0; i < 9; i++)
			assertArrayEquals(new int[] { 3, i + 1 }, inv.posToLoc(i + 18));
		for (int i = 0; i < 9; i++)
			assertArrayEquals(new int[] { 4, i + 1 }, inv.posToLoc(i + 27));
		for (int i = 0; i < 9; i++)
			assertArrayEquals(new int[] { 5, i + 1 }, inv.posToLoc(i + 36));
		for (int i = 0; i < 9; i++)
			assertArrayEquals(new int[] { 6, i + 1 }, inv.posToLoc(i + 45));
	}

	@Test
	public void testLocToPos() {
		Inventory inv = new Inventory() {
			@Override
			public void set(int pos, ClickableItem item) {
			}

			@Override
			public void save(String key, Object value) {
			}

			@Override
			public void rectangle(int col, int row, int width, int height, ClickableItem item) {
			}

			@Override
			public void rectangle(int pos, int width, int height, ClickableItem item) {
			}

			@Override
			public void fillRectangle(int col, int row, int width, int height, ClickableItem item) {
			}

			@Override
			public void fillRectangle(int pos, int width, int height, ClickableItem item) {
			}

			@Override
			public int getRows() {
				return 0;
			}

			@Override
			public Player getPlayer() {
				return null;
			}

			@Override
			public InventoryProvider getInventoryProvider() {
				return null;
			}

			@Override
			public Object get(String key) {
				return null;
			}

			@Override
			public void fill(ClickableItem item) {
			}
		};

		for (int i = 0; i < 9; i++)
			assertEquals(i, inv.locToPos(i + 1, 1));
		for (int i = 0; i < 9; i++)
			assertEquals(i + 9, inv.locToPos(i + 1, 2));
		for (int i = 0; i < 9; i++)
			assertEquals(i + 18, inv.locToPos(i + 1, 3));
		for (int i = 0; i < 9; i++)
			assertEquals(i + 27, inv.locToPos(i + 1, 4));
		for (int i = 0; i < 9; i++)
			assertEquals(i + 36, inv.locToPos(i + 1, 5));
		for (int i = 0; i < 9; i++)
			assertEquals(i + 45, inv.locToPos(i + 1, 6));
	}
}
