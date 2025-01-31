package org.andengine.extension.texturepacker.opengl.texture.util.texturepacker;

import java.util.HashMap;

import android.util.SparseArray;

/**
 * (c) Zynga 2011
 *
 * @author Nicolas Gramlich <ngramlich@zynga.com>
 * @since 16:34:23 - 15.08.2011
 */
public class TexturePackTextureRegionLibrary {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	private final SparseArray<TexturePackerTextureRegion> mIDMapping;
	private final HashMap<String, TexturePackerTextureRegion> mSourceMapping;

	// ===========================================================
	// Constructors
	// ===========================================================

        /**
         * 
         * @param pInitialCapacity
         */
        public TexturePackTextureRegionLibrary(final int pInitialCapacity) {
		this.mIDMapping = new SparseArray<TexturePackerTextureRegion>(pInitialCapacity);
		this.mSourceMapping = new HashMap<String, TexturePackerTextureRegion>(pInitialCapacity);
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

        /**
         * 
         * @return
         */
        public SparseArray<TexturePackerTextureRegion> getIDMapping() {
		return this.mIDMapping;
	}

        /**
         * 
         * @return
         */
        public HashMap<String, TexturePackerTextureRegion> getSourceMapping() {
		return this.mSourceMapping;
	}

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

        /**
         * 
         * @param pTexturePackTextureRegion
         */
        public void add(final TexturePackerTextureRegion pTexturePackTextureRegion) {
		this.throwOnCollision(pTexturePackTextureRegion);

		this.mIDMapping.put(pTexturePackTextureRegion.getID(), pTexturePackTextureRegion);
		this.mSourceMapping.put(pTexturePackTextureRegion.getSource(), pTexturePackTextureRegion);
	}

        /**
         * 
         * @param pID
         */
        public void remove(final int pID) {
		this.mIDMapping.remove(pID);
	}

        /**
         * 
         * @param pID
         * @return
         */
        public TexturePackerTextureRegion get(final int pID) {
		return this.mIDMapping.get(pID);
	}

        /**
         * 
         * @param pSource
         * @return
         */
        public TexturePackerTextureRegion get(final String pSource) {
		return this.mSourceMapping.get(pSource);
	}

        /**
         * 
         * @param pSource
         * @param pStripExtension
         * @return
         */
        public TexturePackerTextureRegion get(final String pSource, final boolean pStripExtension) {
		if(pStripExtension) {
			final int indexOfExtension = pSource.lastIndexOf('.');
			if(indexOfExtension == -1) {
				return this.get(pSource);
			} else {
				final String stripped = pSource.substring(0, indexOfExtension);
				return this.mSourceMapping.get(stripped);
			}
		} else {
			return this.get(pSource);
		}
	}

	private void throwOnCollision(final TexturePackerTextureRegion pTexturePackTextureRegion) throws IllegalArgumentException {
		if(this.mIDMapping.get(pTexturePackTextureRegion.getID()) != null) {
			throw new IllegalArgumentException("Collision with ID: '" + pTexturePackTextureRegion.getID() + "'.");
		} else if(this.mSourceMapping.get(pTexturePackTextureRegion.getSource()) != null) {
			throw new IllegalArgumentException("Collision with Source: '" + pTexturePackTextureRegion.getSource() + "'.");
		}
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
