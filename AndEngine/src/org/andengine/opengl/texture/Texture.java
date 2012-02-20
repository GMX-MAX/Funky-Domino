package org.andengine.opengl.texture;

import java.io.IOException;

import org.andengine.opengl.texture.atlas.source.ITextureAtlasSource;
import org.andengine.opengl.util.GLState;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 * 
 * @author Nicolas Gramlich
 * @since 14:55:02 - 08.03.2010
 */
public abstract class Texture implements ITexture {
	// ===========================================================
	// Constants
	// ===========================================================

	private static final int HARDWARE_TEXTURE_ID_INVALID = -1;

	// ===========================================================
	// Fields
	// ===========================================================

        /**
         * 
         */
        protected final TextureManager mTextureManager;
        /**
         * 
         */
        protected final PixelFormat mPixelFormat;
        /**
         * 
         */
        protected final TextureOptions mTextureOptions;

        /**
         * 
         */
        protected int mHardwareTextureID = Texture.HARDWARE_TEXTURE_ID_INVALID;
        /**
         * 
         */
        protected boolean mUpdateOnHardwareNeeded = false;

        /**
         * 
         */
        protected ITextureStateListener mTextureStateListener;

	// ===========================================================
	// Constructors
	// ===========================================================

	/**
         * @param pTextureManager 
         * @param pPixelFormat
	 * @param pTextureOptions the (quality) settings of the Texture.
         * @param pTextureStateListener to be informed when this {@link Texture} is loaded, unloaded or a {@link ITextureAtlasSource} failed to load.
         * @throws IllegalArgumentException  
	 */
	public Texture(final TextureManager pTextureManager, final PixelFormat pPixelFormat, final TextureOptions pTextureOptions, final ITextureStateListener pTextureStateListener) throws IllegalArgumentException {
		this.mTextureManager = pTextureManager;
		this.mPixelFormat = pPixelFormat;
		this.mTextureOptions = pTextureOptions;
		this.mTextureStateListener = pTextureStateListener;
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

        /**
         * 
         * @return
         */
        @Override
	public int getHardwareTextureID() {
		return this.mHardwareTextureID;
	}

        /**
         * 
         * @return
         */
        @Override
	public boolean isLoadedToHardware() {
		return this.mHardwareTextureID != Texture.HARDWARE_TEXTURE_ID_INVALID;
	}

        /**
         * 
         */
        @Override
	public void setNotLoadedToHardware() {
		this.mHardwareTextureID = Texture.HARDWARE_TEXTURE_ID_INVALID;
	}

        /**
         * 
         * @return
         */
        @Override
	public boolean isUpdateOnHardwareNeeded() {
		return this.mUpdateOnHardwareNeeded;
	}

	@Override
	public void setUpdateOnHardwareNeeded(final boolean pUpdateOnHardwareNeeded) {
		this.mUpdateOnHardwareNeeded = pUpdateOnHardwareNeeded;
	}

        /**
         * 
         * @return
         */
        @Override
	public PixelFormat getPixelFormat() {
		return this.mPixelFormat;
	}

        /**
         * 
         * @return
         */
        @Override
	public TextureOptions getTextureOptions() {
		return this.mTextureOptions;
	}

        /**
         * 
         * @return
         */
        @Override
	public ITextureStateListener getTextureStateListener() {
		return this.mTextureStateListener;
	}

        /**
         * 
         * @param pTextureStateListener
         */
        @Override
	public void setTextureStateListener(final ITextureStateListener pTextureStateListener) {
		this.mTextureStateListener = pTextureStateListener;
	}

        /**
         * 
         * @return
         */
        @Override
	public boolean hasTextureStateListener() {
		return this.mTextureStateListener != null;
	}

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

        /**
         * 
         * @param pGLState
         * @throws IOException
         */
        protected abstract void writeTextureToHardware(final GLState pGLState) throws IOException;

        /**
         * 
         */
        @Override
	public void load() {
		this.mTextureManager.loadTexture(this);
	}

        /**
         * 
         */
        @Override
	public void unload() {
		this.mTextureManager.unloadTexture(this);
	}

        /**
         * 
         * @param pGLState
         * @throws IOException
         */
        @Override
	public void loadToHardware(final GLState pGLState) throws IOException {
		this.mHardwareTextureID = pGLState.generateTexture();

		pGLState.bindTexture(this.mHardwareTextureID);

		this.writeTextureToHardware(pGLState);

		this.mTextureOptions.apply();

		this.mUpdateOnHardwareNeeded = false;

		if(this.mTextureStateListener != null) {
			this.mTextureStateListener.onLoadedToHardware(this);
		}
	}

        /**
         * 
         * @param pGLState
         */
        @Override
	public void unloadFromHardware(final GLState pGLState) {
		pGLState.deleteTexture(this.mHardwareTextureID);

		this.mHardwareTextureID = Texture.HARDWARE_TEXTURE_ID_INVALID;

		if(this.mTextureStateListener != null) {
			this.mTextureStateListener.onUnloadedFromHardware(this);
		}
	}

        /**
         * 
         * @param pGLState
         * @throws IOException
         */
        @Override
	public void reloadToHardware(final GLState pGLState) throws IOException {
		this.unloadFromHardware(pGLState);
		this.loadToHardware(pGLState);
	}

        /**
         * 
         * @param pGLState
         */
        @Override
	public void bind(final GLState pGLState) {
		pGLState.bindTexture(this.mHardwareTextureID);
	}

	@Override
	public void bind(final GLState pGLState, final int pGLActiveTexture) {
		pGLState.activeTexture(pGLActiveTexture);
		pGLState.bindTexture(this.mHardwareTextureID);
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}