/*
 * Bullet Continuous Collision Detection and Physics Library
 * Copyright (c) 2003-2009 Erwin Coumans  http://bulletphysics.org
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
package Bullet.Collision;

import Bullet.LinearMath.btVector3;
import java.io.Serializable;

/**
 *
 * @author Gregery Barton
 */
public interface btTriangleCallback extends Serializable {

 /**
  *
  * @param triangle 3 vertices of the triangle, may return the same array every
  * time so make copies if the vertices are going to be stored elsewhere.
  * @param partId the mesh part
  * @param triangleIndex index of the triangle, an arbitrary but consistent
  * number
  * @return false to stop batch processing, may be ignored if bullet is
  * internally processing one triangle at a time. A call back that
  * unconditionally returns false will only ever process one triangle.
  */
 boolean processTriangle(btVector3[] triangle, int partId, int triangleIndex);

}
