package org.andengine.opengl.view;

/**
 * (c) 2010 Nicolas Gramlich
 * (c) 2011 Zynga Inc.
 * 
 * @author Nicolas Gramlich
 * @since 11:57:29 - 08.03.2010
 */
public interface IRendererListener {
	// ===========================================================
	// Constants
	// ===========================================================

    /**
     * 
     */
    public void onSurfaceCreated();
    /**
     * 
     * @param pWidth
     * @param pHeight
     */
    public void onSurfaceChanged(final int pWidth, final int pHeight);

	// ===========================================================
	// Methods
	// ===========================================================
}