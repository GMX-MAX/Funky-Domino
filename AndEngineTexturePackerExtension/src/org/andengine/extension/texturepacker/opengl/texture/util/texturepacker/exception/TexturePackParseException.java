package org.andengine.extension.texturepacker.opengl.texture.util.texturepacker.exception;

import org.xml.sax.SAXException;

/**
 * (c) Zynga 2011
 *
 * @author Nicolas Gramlich <ngramlich@zynga.com>
 * @since 17:29:20 - 29.07.2011
 */
public class TexturePackParseException extends SAXException {
	// ===========================================================
	// Constants
	// ===========================================================

	private static final long serialVersionUID = 5773816582330137037L;

	// ===========================================================
	// Fields
	// ===========================================================

	// ===========================================================
	// Constructors
	// ===========================================================

        /**
         * 
         */
        public TexturePackParseException() {
		super();
	}

        /**
         * 
         * @param pDetailMessage
         */
        public TexturePackParseException(final String pDetailMessage) {
		super(pDetailMessage);
	}

        /**
         * 
         * @param pException
         */
        public TexturePackParseException(final Exception pException) {
		super(pException);
	}

        /**
         * 
         * @param pMessage
         * @param pException
         */
        public TexturePackParseException(final String pMessage, final Exception pException) {
		super(pMessage, pException);
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
