package org.andengine.entity.modifier;

import org.andengine.entity.IEntity;
import org.andengine.util.modifier.BaseSingleValueSpanModifier;
import org.andengine.util.modifier.ease.IEaseFunction;

/**
 * (c) 2010 Nicolas Gramlich 
 * (c) 2011 Zynga Inc.
 * 
 * @author Nicolas Gramlich
 * @since 23:29:22 - 19.03.2010
 */
public abstract class SingleValueSpanEntityModifier extends BaseSingleValueSpanModifier<IEntity> implements IEntityModifier {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	// ===========================================================
	// Constructors
	// ===========================================================

    /**
     * 
     * @param pDuration
     * @param pFromValue
     * @param pToValue
     */
    public SingleValueSpanEntityModifier(final float pDuration, final float pFromValue, final float pToValue) {
		super(pDuration, pFromValue, pToValue);
	}

    /**
     * 
     * @param pDuration
     * @param pFromValue
     * @param pToValue
     * @param pEaseFunction
     */
    public SingleValueSpanEntityModifier(final float pDuration, final float pFromValue, final float pToValue, final IEaseFunction pEaseFunction) {
		super(pDuration, pFromValue, pToValue, pEaseFunction);
	}

    /**
     * 
     * @param pDuration
     * @param pFromValue
     * @param pToValue
     * @param pEntityModifierListener
     */
    public SingleValueSpanEntityModifier(final float pDuration, final float pFromValue, final float pToValue, final IEntityModifierListener pEntityModifierListener) {
		super(pDuration, pFromValue, pToValue, pEntityModifierListener);
	}

        /**
         * 
         * @param pDuration
         * @param pFromValue
         * @param pToValue
         * @param pEntityModifierListener
         * @param pEaseFunction
         */
        public SingleValueSpanEntityModifier(final float pDuration, final float pFromValue, final float pToValue, final IEntityModifierListener pEntityModifierListener, final IEaseFunction pEaseFunction) {
		super(pDuration, pFromValue, pToValue, pEntityModifierListener, pEaseFunction);
	}

        /**
         * 
         * @param pSingleValueSpanEntityModifier
         */
        protected SingleValueSpanEntityModifier(final SingleValueSpanEntityModifier pSingleValueSpanEntityModifier) {
		super(pSingleValueSpanEntityModifier);
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
