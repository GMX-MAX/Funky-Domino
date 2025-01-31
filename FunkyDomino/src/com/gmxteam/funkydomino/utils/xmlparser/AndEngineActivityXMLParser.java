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

import com.gmxteam.funkydomino.activities.AndEngineActivity;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/**
 * Classe statique contenant les fonctions utiles pour convertir les niveaux
 * encrypté asymétriquement en Activity.
 * @author Guillaume Poirier-morency
 */
public final class AndEngineActivityXMLParser { 

    /**
     * Décode la ressource XML en entrée et l'interprète afin de générer le code
     * d'un niveau. Le GameActivity ainsi retourné est prêt à être joué !
     * @param aea 
     * @param resourceStream
     * @param publicKey 
     * @throws ParserConfigurationException 
     * @throws IOException
     * @throws SAXException  
     */
    public static void buildGameInstance(AndEngineActivity aea, InputStream resourceStream, String publicKey) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        XMLReader xr = sp.getXMLReader();
        XMLHandler xh = new XMLHandler( aea);
        xr.setContentHandler(xh);
        xr.parse(new InputSource(decrypt(resourceStream, publicKey)));
    }

    /**
     * Récupère un dictionnaire contenant les informations générales du fichier
     * XML. Permet une récupération rapide sans génération de code. 
     * Des constantes sont définies afin de récupérer les bonnes informations.
     * @param publicKey 
     * @param resourceStream 
     * @return
     * @throws ParserConfigurationException 
     * @throws SAXException
     * @throws IOException  
     */
    public static GameInformation obtainGameInformations(InputStream resourceStream, String publicKey) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        XMLReader xr = sp.getXMLReader();
        XMLHandler xh = new XMLHandler();
        xr.setContentHandler(xh);
        xr.parse(new InputSource(decrypt(resourceStream, publicKey)));
        return xh.getGameInformation();
    }

    /**
     * 
     * @param ga
     * @param resourceStream     
     * @return 
     */
    private static InputStream decrypt(InputStream resourceStream, String publicKey) {
        // On récupère la clé publique...

        // On décrypte le niveau avec cette clé...


        // On retourne l'inputstream du niveau décrypté

        return resourceStream;


    }
}
