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
 * A joint edge is used to connect bodies and joints together in a joint graph where each body is a node and each joint is an
 * edge. A joint edge belongs to a doubly linked list maintained in each attached body. Each joint has two joint nodes, one for
 * each attached body.
 */
public class JointEdge {
    /**
     * 
     */
    public final Body other;
        /**
         * 
         */
        public final Joint joint;

        /**
         * 
         * @param other
         * @param joint
         */
        protected JointEdge (Body other, Joint joint) {
		this.other = other;
		this.joint = joint;
	}
}
