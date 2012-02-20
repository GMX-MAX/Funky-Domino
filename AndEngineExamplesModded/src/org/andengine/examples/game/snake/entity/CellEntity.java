package org.andengine.examples.game.snake.entity;

import org.andengine.entity.sprite.Sprite;
import org.andengine.examples.game.snake.util.constants.SnakeConstants;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

/**
 * (c) 2010 Nicolas Gramlich 
 * (c) 2011 Zynga Inc.
 * 
 * @author Nicolas Gramlich
 * @since 17:13:44 - 09.07.2010
 */
public abstract class CellEntity extends Sprite implements SnakeConstants, ICellEntity {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

    /**
     * 
     */
    protected int mCellX;
    /**
     * 
     */
    protected int mCellY;

	// ===========================================================
	// Constructors
	// ===========================================================

        /**
         * 
         * @param pCellX
         * @param pCellY
         * @param pWidth
         * @param pHeight
         * @param pTextureRegion
         * @param pVertexBufferObjectManager
         */
        public CellEntity(final int pCellX, final int pCellY, final int pWidth, final int pHeight, final ITextureRegion pTextureRegion, final VertexBufferObjectManager pVertexBufferObjectManager) {
		super(pCellX * CELL_WIDTH, pCellY * CELL_HEIGHT, pWidth, pHeight, pTextureRegion, pVertexBufferObjectManager);

		this.mCellX = pCellX;
		this.mCellY = pCellY;
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

        /**
         * 
         * @return
         */
        public int getCellX() {
		return this.mCellX;
	}

        /**
         * 
         * @return
         */
        public int getCellY() {
		return this.mCellY;
	}

        /**
         * 
         * @param pCellEntity
         */
        public void setCell(final ICellEntity pCellEntity) {
		this.setCell(pCellEntity.getCellX(), pCellEntity.getCellY());
	}

        /**
         * 
         * @param pCellX
         * @param pCellY
         */
        public void setCell(final int pCellX, final int pCellY) {
		this.mCellX = pCellX;
		this.mCellY = pCellY;
		this.setPosition(this.mCellX * CELL_WIDTH, this.mCellY * CELL_HEIGHT);
	}

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================
	
        /**
         * 
         * @param pCellEntity
         * @return
         */
        @Override
	public boolean isInSameCell(final ICellEntity pCellEntity) {
		return this.mCellX == pCellEntity.getCellX() && this.mCellY == pCellEntity.getCellY();
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
