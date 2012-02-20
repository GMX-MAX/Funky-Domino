package org.andengine.util.adt.queue;

import org.andengine.util.adt.list.SortedList;

/**
 * (c) Zynga 2012
 *
 * @param <T> 
 * @author Nicolas Gramlich <ngramlich@zynga.com>
 * @since 17:17:33 PM - 03.022012
 */
public class SortedQueue<T extends Comparable<T>> extends SortedList<T> implements ISortedQueue<T>{
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
     * @param pQueue
     */
    public SortedQueue(final IQueue<T> pQueue) {
		super(pQueue);
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	public T peek() {
		if(this.isEmpty()) {
			return null;
		} else {
			return this.get(0);
		}
	}

        /**
         * 
         * @return
         */
        @Override
	public T poll() {
		if(this.isEmpty()) {
			return null;
		} else {
			return this.remove(0);
		}
	}

        /**
         * 
         * @param pItem
         */
        @Override
	public void enter(final T pItem) {
		this.add(pItem);
	}

        /**
         * 
         * @param pIndex
         * @param pItem
         * @throws IndexOutOfBoundsException
         * @deprecated
         */
        @Deprecated
	@Override
	public void enter(final int pIndex, final T pItem) throws IndexOutOfBoundsException {
		this.add(pIndex, pItem);
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
