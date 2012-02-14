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

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import com.gmxteam.funkydomino.utils.xmlparser.GameActivityXMLParser;

/**
 *
 * @author Guillaume Poirier-Morency
 */
public class GameActivity extends JBox2DCanvasActivity {
    
    @Override
    public void onCreate(Bundle ressources) {
        
        super.onCreate(ressources);
        GameActivityXMLParser.buildGameInstance(this, ressources.getInt("LEVEL"));        
    }

    @Override
    void drawActivityDebug(Canvas c, float initP, Paint p) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
