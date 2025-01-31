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
package com.badlogic.gdx.physics.box2d;

/**
 * A shape is used for collision detection. You can create a shape however you like. Shapes used for simulation in b2World are
 * created automatically when a b2Fixture is created.
 * 
 * NOTE: YOU NEED TO DISPOSE SHAPES AFTER YOU NO LONGER USE THEM! E.g. after calling body.createFixture();
 * @author mzechner
 * 
 */
public abstract class Shape {
	/**
	 * Enum describing the type of a shape
	 * @author mzechner
	 * 
	 */
	public enum Type {
            /**
             * 
             */
            Circle,
            /**
             * 
             */
            Polygon,
	};

	/** the address of the shape **/
	protected long addr;

	/**
	 * Get the type of this shape. You can use this to down cast to the concrete shape.
	 * @return the shape type.
	 */
	public abstract Type getType ();

	/**
	 * Returns the radius of this shape
         * 
         * @return 
         */
	public float getRadius () {
		return jniGetRadius(addr);
	}

	private native float jniGetRadius (long addr);

	/**
	 * Sets the radius of this shape
         * 
         * @param radius 
         */
	public void setRadius (float radius) {
		jniSetRadius(addr, radius);
	}

	private native void jniSetRadius (long addr, float radius);

	/**
	 * Needs to be called when the shape is no longer used, e.g. after a fixture was created based on the shape.
	 */
	public void dispose () {
		jniDispose(addr);
	}

	private native void jniDispose (long addr);

        /**
         * 
         * @param addr
         * @return
         */
        protected static native int jniGetType (long addr);

// /// Test a point for containment in this shape. This only works for convex shapes.
// /// @param xf the shape world transform.
// /// @param p a point in world coordinates.
// virtual bool TestPoint(const b2Transform& xf, const b2Vec2& p) const = 0;
//
// /// Cast a ray against this shape.
// /// @param output the ray-cast results.
// /// @param input the ray-cast input parameters.
// /// @param transform the transform to be applied to the shape.
// virtual bool RayCast(b2RayCastOutput* output, const b2RayCastInput& input, const b2Transform& transform) const = 0;
//
// /// Given a transform, compute the associated axis aligned bounding box for this shape.
// /// @param aabb returns the axis aligned box.
// /// @param xf the world transform of the shape.
// virtual void ComputeAABB(b2AABB* aabb, const b2Transform& xf) const = 0;
//
// /// Compute the mass properties of this shape using its dimensions and density.
// /// The inertia tensor is computed about the local origin.
// /// @param massData returns the mass data for this shape.
// /// @param density the density in kilograms per meter squared.
// virtual void ComputeMass(b2MassData* massData, float32 density) const = 0;
}
