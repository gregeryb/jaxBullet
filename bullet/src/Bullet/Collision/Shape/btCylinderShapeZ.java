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
package Bullet.Collision.Shape;

import Bullet.LinearMath.btVector3;
import java.io.Serializable;

/**
 *
 * @author Gregery Barton
 */
public class btCylinderShapeZ extends btCylinderShape implements Serializable {

 public btCylinderShapeZ(final btVector3 halfExtents) {
  super(halfExtents);
  m_upAxis = 2;
 }

 public btVector3 localGetSupportingVertexWithoutMargin(final btVector3 vec) {
  return CylinderLocalSupportZ(getHalfExtentsWithoutMargin(), vec);
 }

 public void batchedUnitVectorGetSupportingVertexWithoutMargin(
  btVector3[] vectors,
  btVector3[] supportVerticesOut, int numVectors) {
  for (int i = 0; i < numVectors; i++) {
   if (supportVerticesOut[i] == null) {
    supportVerticesOut[i] = new btVector3();
   }
   supportVerticesOut[i].set(
    CylinderLocalSupportZ(getHalfExtentsWithoutMargin(), vectors[i]));
  }
 }

 //debugging
 public String getName() {
  return "CylinderZ";
 }

 public float getRadius() {
  return getHalfExtentsWithMargin().getX();
 }

 @Override
 public boolean equals(Object obj) {
  return super.equals(obj);
 }

 @Override
 public int hashCode() {
  return super.hashCode();
 }

}
