package com.froxynetwork.froxyapi.inventory;

import java.util.function.Consumer;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import lombok.Getter;

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
 * An item that is clickable in the Inventory
 */
public class ClickableItem {
	@Getter
	private ItemStack item;
	private Consumer<InventoryClickEvent> event;

	private ClickableItem(ItemStack item, Consumer<InventoryClickEvent> event) {
		this.item = item;
		this.event = event;
	}

	public void run(InventoryClickEvent e) {
		event.accept(e);
	}

	public static ClickableItem of(ItemStack is) {
		return new ClickableItem(is, e -> {
		});
	}

	public static ClickableItem of(ItemStack is, Consumer<InventoryClickEvent> event) {
		return new ClickableItem(is, event);
	}
}
