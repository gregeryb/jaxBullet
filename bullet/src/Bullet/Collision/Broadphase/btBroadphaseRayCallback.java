/*
 * Bullet Continuous Collision Detection and Physics Library
 * Copyright (c) 2003-2006 Erwin Coumans  http://continuousphysics.com/Bullet/
 *
 * This software is provided 'as-is', without any express or implied warranty.
 * In no event will the authors be held liable for any damages arising from the use of this software.
 * Permission is granted to anyone to use this software for any purpose,
 * including commercial applications, and to alter it and redistribute it freely,
 * subject to the following restrictions:
 *
 * 1. The origin of this software must not be misrepresented; you must not claim that you wrote the original software. If you use this software in a product, an acknowledgment in the product documentation would be appreciated but is not required.
 * 2. Altered source versions must be plainly marked as such, and must not be misrepresented as being the original software.
 * 3. This notice may not be removed or altered from any source distribution.
 */
package Bullet.Collision.Broadphase;

import Bullet.LinearMath.btVector3;
import java.io.Serializable;

/**
 *
 * @author Gregery Barton
 */
abstract public class btBroadphaseRayCallback implements
 btBroadphaseAabbCallback, Serializable {
 ///added some cached data to accelerate ray-AABB tests

 final btVector3 m_rayDirectionInverse = new btVector3();
 final int[] m_signs = new int[3];
 float m_lambda_max;
}
