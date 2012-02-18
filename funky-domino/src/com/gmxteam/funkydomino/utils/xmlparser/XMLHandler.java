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
package com.gmxteam.funkydomino.utils.xmlparser;

import android.util.Log;

import org.anddev.andengine.ui.activity.BaseGameActivity;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Guillaume Poirier-Morency
 */
public final class XMLHandler extends DefaultHandler {

    // booleans that check whether it's in a specific tag or not 
    private boolean inComponent;
    private boolean inWidget, inLevel;
    private boolean inDomino, inCog, inWater, inBall, inGround, inAddBall, inAddDomino;
    // this holds the data 
    private GameInformation gameInformationData;
    private BaseGameActivity gameActivity;

    /**
     * 
     */
    public XMLHandler() {

        gameActivity = null;


    }

    /**
     * 
     * @param ga
     */
    public XMLHandler(BaseGameActivity ga) {

        gameActivity = ga;

    }

    /** 
     * Returns the data object 
     * 
     * @return 
     */
    public GameInformation getGameInformation() {
        return gameInformationData;
    }

    /** 
     * This gets called when the xml document is first opened 
     * 
     * @throws SAXException 
     */
    @Override
    public void startDocument() throws SAXException {
        gameInformationData = new GameInformation();
    }

    /** 
     * Called when it's finished handling the document 
     * 
     * @throws SAXException 
     */
    @Override
    public void endDocument() throws SAXException {
    }

    /** 
     * This gets called at the start of an element. Here we're also setting the booleans to true if it's at that specific tag. (so we 
     * know where we are) 
     * 
     * @param namespaceURI 
     * @param localName 
     * @param qName 
     * @param atts 
     * @throws SAXException 
     */
    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {


        if (localName.equals("level")) {
            inLevel = true;
            gameInformationData.id = atts.getValue("id");
            gameInformationData.previousLevel = atts.getValue("previousLevel=");
            gameInformationData.nextLevel = atts.getValue("nextLevel");
            gameInformationData.name = atts.getValue("name");
            gameInformationData.description = atts.getValue("description");
        } else {
            throw new IllegalXMLNameException("Balise inconnue " + localName);
        }

        if (inLevel) {
            if (localName.equals("component")) {
                gameInformationData.componentTheme = atts.getValue("theme");
                inComponent = true;
            } else if (localName.equals("widget")) {
                gameInformationData.widgetTheme = atts.getValue("theme");
                inWidget = true;
            } else {

                throw new IllegalXMLNameException("Balise inconnue " + localName + " dans level.");

            }
        }


        if (inComponent) {
            if (gameActivity == null) {
                return;
            }
            if (localName.equals("domino")) {
                //new Domino(gameActivity.world, atts);
                inDomino = true;

            } else if (localName.equals("cog")) {
                //new Cog(gameActivity.world, atts);
                inCog = true;
            } else if (localName.equals("ball")) {
                //new Ball(gameActivity.world, atts);
                inBall = true;
            } else if (localName.equals("ground")) {
                //new Ground(gameActivity.world, atts);
                inGround = true;
            } else if (localName.equals("water")) {
                //new Water(gameActivity.world, atts);
                inWater = true;
            } else {
                throw new IllegalXMLNameException("Balise inconnue " + localName + " dans component.");
            }


        } else if (inWidget) {
            if (gameActivity == null) {
                return;
            }
            if (localName.equals("addball")) {
                //new AddBall(gameActivity.world, atts);
                inDomino = true;

            } else if (localName.equals("adddomino")) {
                //new AddDomino(gameActivity.world, atts);
                inCog = true;
            } else {
                throw new IllegalXMLNameException("Balise inconnue " + localName + " dans widget.");
            }
        }


    }

    /** 
     * Called at the end of the element. Setting the booleans to false, so we know that we've just left that tag. 
     * 
     * @param namespaceURI 
     * @param localName 
     * @param qName 
     * @throws SAXException 
     */
    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        Log.v("endElement", localName);



        if (localName.equals("level")) {
            inLevel = false;

        } else {
            throw new IllegalXMLNameException("Balise inconnue " + localName);

        }

        if (inLevel) {
            if (localName.equals("component")) {

                inComponent = false;
            } else if (localName.equals("widget")) {

                inWidget = false;
            } else {
                throw new IllegalXMLNameException("Balise inconnue " + localName + " dans level.");
            }
        }

        if (inComponent) {
            if (localName.equals("domino")) {
                inDomino = false;
            } else if (localName.equals("cog")) {
                inCog = false;
            } else if (localName.equals("ball")) {
                inBall = false;
            } else if (localName.equals("ground")) {
                inGround = false;
            } else if (localName.equals("water")) {
                inWater = false;
            } else {
                throw new IllegalXMLNameException("Balise inconnue " + localName + " dans les composants.");
            }
        } else if (inWidget) {
            if (localName.equals("adddomino")) {
                inAddDomino = false;
            } else if (localName.equals("addcog")) {
                inAddBall = false;
            } else {
                throw new IllegalXMLNameException("Balise inconnue " + localName + " dans les widgets.");
            }
        }
    }

    /** 
     * Calling when we're within an element. Here we're checking to see if there is any content in the tags that we're interested in 
     * and populating it in the Config object. 
     * 
     * On ne devrait pas avoir à utiliser cette section.
     * @param ch 
     * @param start 
     * @param length 
     */
    @Override
    public void characters(char ch[], int start, int length) {
        String chars = new String(ch, start, length);
        chars = chars.trim();

    }
}
