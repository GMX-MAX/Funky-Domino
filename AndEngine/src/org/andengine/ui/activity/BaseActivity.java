package org.andengine.ui.activity;

import org.andengine.util.ActivityUtils;
import org.andengine.util.call.AsyncCallable;
import org.andengine.util.call.Callable;
import org.andengine.util.call.Callback;
import org.andengine.util.progress.ProgressCallable;

import android.app.Activity;
import android.app.ProgressDialog;

/**
 * (c) 2010 Nicolas Gramlich 
 * (c) 2011 Zynga Inc.
 * 
 * @author Nicolas Gramlich
 * @since 18:35:28 - 29.08.2009
 */
public abstract class BaseActivity extends Activity {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	// ===========================================================
	// Constructors
	// ===========================================================

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================

	/**
	 * Performs a task in the background, showing a {@link ProgressDialog},
	 * while the {@link Callable} is being processed.
	 * 
	 * @param <T>
	 * @param pTitleResourceID
	 * @param pMessageResourceID
	 * @param pCallable
	 * @param pCallback
	 */
	protected <T> void doAsync(final int pTitleResourceID, final int pMessageResourceID, final Callable<T> pCallable, final Callback<T> pCallback) {
		this.doAsync(pTitleResourceID, pMessageResourceID, pCallable, pCallback, null);
	}

	/**
	 * Performs a task in the background, showing a indeterminate {@link ProgressDialog},
	 * while the {@link Callable} is being processed.
	 * 
	 * @param <T>
	 * @param pTitleResourceID
	 * @param pMessageResourceID
	 * @param pCallable
	 * @param pCallback
	 * @param pExceptionCallback
	 */
	protected <T> void doAsync(final int pTitleResourceID, final int pMessageResourceID, final Callable<T> pCallable, final Callback<T> pCallback, final Callback<Exception> pExceptionCallback) {
		ActivityUtils.doAsync(this, pTitleResourceID, pMessageResourceID, pCallable, pCallback, pExceptionCallback);
	}

	/**
	 * Performs a task in the background, showing a {@link ProgressDialog} with an ProgressBar,
	 * while the {@link AsyncCallable} is being processed.
	 * 
	 * @param <T>
	 * @param pTitleResourceID
         * @param pIconResourceID 
         * @param pCallable 
	 * @param pCallback
	 */
	protected <T> void doProgressAsync(final int pTitleResourceID, final int pIconResourceID, final ProgressCallable<T> pCallable, final Callback<T> pCallback) {
		this.doProgressAsync(pTitleResourceID, pIconResourceID, pCallable, pCallback, null);
	}

	/**
	 * Performs a task in the background, showing a {@link ProgressDialog} with a ProgressBar,
	 * while the {@link AsyncCallable} is being processed.
	 * 
	 * @param <T>
	 * @param pTitleResourceID
         * @param pIconResourceID 
         * @param pCallable 
	 * @param pCallback
	 * @param pExceptionCallback
	 */
	protected <T> void doProgressAsync(final int pTitleResourceID, final int pIconResourceID, final ProgressCallable<T> pCallable, final Callback<T> pCallback, final Callback<Exception> pExceptionCallback) {
		ActivityUtils.doProgressAsync(this, pTitleResourceID, pIconResourceID, pCallable, pCallback, pExceptionCallback);
	}

	/**
	 * Performs a task in the background, showing an indeterminate {@link ProgressDialog},
	 * while the {@link AsyncCallable} is being processed.
	 * 
	 * @param <T>
	 * @param pTitleResourceID
	 * @param pMessageResourceID
	 * @param pAsyncCallable
	 * @param pCallback
	 * @param pExceptionCallback
	 */
	protected <T> void doAsync(final int pTitleResourceID, final int pMessageResourceID, final AsyncCallable<T> pAsyncCallable, final Callback<T> pCallback, final Callback<Exception> pExceptionCallback) {
		ActivityUtils.doAsync(this, pTitleResourceID, pMessageResourceID, pAsyncCallable, pCallback, pExceptionCallback);
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================

        /**
         * 
         */
        public static class CancelledException extends Exception {
		private static final long serialVersionUID = -78123211381435596L;
	}
}
