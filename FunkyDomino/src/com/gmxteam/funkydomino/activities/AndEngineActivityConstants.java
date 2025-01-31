/*
 *   This file is part of Funky Domino.
 *
 *   Funky Domino is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   Funky Domino is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with Funky Domino.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.gmxteam.funkydomino.activities;

/**
 *
 * @author guillaume
 */
public interface AndEngineActivityConstants {

    ////////////////////////////////////////////////////////////////////////////
    // Constantes publiques. Elles sont disponibles dans tout le projet.
    /**
     * 
     */
    public static final String APP_LOG_NAME = "funky-domino";
    ////////////////////////////////////////////////////////////////////////////
    // Constantes spécifiques aux activités
    /**
     * 
     */
    static final int CELLS_HORIZONTAL = 16;
    /**
     * 
     */
    static final int CELLS_VERTICAL = 12;
    /**
     * 
     */
    static final int CELL_WIDTH = 32;
    /**
     * 
     */
    static final int CELL_HEIGHT = CELL_WIDTH;
    /**
     * 
     */
    static final String LEVEL_KEY_IN_BUNDLE = "level";
}
