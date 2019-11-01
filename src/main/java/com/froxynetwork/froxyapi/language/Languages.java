package com.froxynetwork.froxyapi.language;

import com.froxynetwork.froxyapi.Froxy;

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
 * List of all languages managed by the app.<br />
 * Same as <a href="https://github.com/FroxyNetwork/FroxyGame/blob/master/src/main/java/com/froxynetwork/froxygame/languages/LanguageManager.java">this</a> enum.
 */
public enum Languages {
	FRENCH("fr_FR"),
	ENGLISH("en_US");

	@Getter
	private String lang;

	private Languages(String lang) {
		this.lang = lang;
	}

	public static Languages fromLang(String lang) {
		for (Languages l : values())
			if (l.lang.equalsIgnoreCase(lang))
				return l;
		return Froxy.getDefaultLanguage();
	}
}
