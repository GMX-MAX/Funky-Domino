/*******************************************************************************
 * Copyright 2011 See AUTHORS file.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.badlogic.gdx.physics.box2d.joints;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.World;

/**
 * A mouse joint is used to make a point on a body track a specified world point. This a soft constraint with a maximum force.
 * This allows the constraint to stretch and without applying huge forces. NOTE: this joint is not documented in the manual
 * because it was developed to be used in the testbed. If you want to learn how to use the mouse joint, look at the testbed.
 */
public class MouseJoint extends Joint {
    /**
     * 
     * @param world
     * @param addr
     */
    public MouseJoint (World world, long addr) {
		super(world, addr);
	}

	/**
	 * Use this to update the target point.
     * 
     * @param target 
     */
	public void setTarget (Vector2 target) {
		jniSetTarget(addr, target.x, target.y);
	}

	private native void jniSetTarget (long addr, float x, float y);

	/**
	 * Use this to update the target point.
	 */
	final float[] tmp = new float[2];
	private final Vector2 target = new Vector2();

        /**
         * 
         * @return
         */
        public Vector2 getTarget () {
		jniGetTarget(addr, tmp);
		target.x = tmp[0];
		target.y = tmp[1];
		return target;
	}

	private native void jniGetTarget (long addr, float[] target);

	/**
	 * Set/get the maximum force in Newtons.
         * 
         * @param force 
         */
	public void setMaxForce (float force) {
		jniSetMaxForce(addr, force);
	}

	private native void jniSetMaxForce (long addr, float force);

	/**
	 * Set/get the maximum force in Newtons.
         * 
         * @return 
         */
	public float getMaxForce () {
		return jniGetMaxForce(addr);
	}

	private native float jniGetMaxForce (long addr);

	/**
	 * Set/get the frequency in Hertz.
         * 
         * @param hz 
         */
	public void setFrequency (float hz) {
		jniSetFrequency(addr, hz);
	}

	private native void jniSetFrequency (long addr, float hz);

	/**
	 * Set/get the frequency in Hertz.
         * 
         * @return 
         */
	public float getFrequency () {
		return jniGetFrequency(addr);
	}

	private native float jniGetFrequency (long addr);

	/**
	 * Set/get the damping ratio (dimensionless).
         * 
         * @param ratio 
         */
	public void setDampingRatio (float ratio) {
		jniSetDampingRatio(addr, ratio);
	}

	private native void jniSetDampingRatio (long addr, float ratio);

	/**
	 * Set/get the damping ratio (dimensionless).
         * 
         * @return 
         */
	public float getDampingRatio () {
		return jniGetDampingRatio(addr);
	}

	private native float jniGetDampingRatio (long addr);
}
