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

import android.app.Activity;
import android.os.Bundle;

/**
 * Activité utilisée pour configurer Funky Domino. Il s'agit d'une simple
 * activité de type liste.
 * @author Guillaume Poirier-Morency
 */
public final class PreferencesActivity extends Activity {

    /**
     * 
     * @param b
     */
    @Override
    public void onCreate(Bundle b) {

        setContentView(R.layout.preferences);

    }
}
