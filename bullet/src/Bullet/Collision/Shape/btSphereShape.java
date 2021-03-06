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

import static Bullet.Collision.Broadphase.BroadphaseNativeTypes.SPHERE_SHAPE_PROXYTYPE;
import static Bullet.LinearMath.btScalar.SIMD_EPSILON;
import Bullet.LinearMath.btTransform;
import Bullet.LinearMath.btVector3;
import java.io.Serializable;

/**
 *
 * @author Gregery Barton
 */
public class btSphereShape extends btConvexInternalShape implements Serializable {

 private static final long serialVersionUID = 1L;

 public btSphereShape(float radius) {
  super();
  m_shapeType = SPHERE_SHAPE_PROXYTYPE;
  m_implicitShapeDimensions.setX(radius);
  m_collisionMargin = radius;
 }

 @Override
 public btVector3 localGetSupportingVertex(final btVector3 vec) {
  final btVector3 supVertex = localGetSupportingVertexWithoutMargin(vec);
  final btVector3 vecnorm = new btVector3(vec);
  if (vecnorm.lengthSquared() < (SIMD_EPSILON * SIMD_EPSILON)) {
   vecnorm.set((-1.f), (-1.f), (-1.f));
  }
  vecnorm.normalize();
  supVertex.add(vecnorm.scale(getMargin()));
  return supVertex;
 }

 @Override
 public btVector3 localGetSupportingVertexWithoutMargin(final btVector3 vec) {
  return new btVector3();
 }

 //notice that the vectors should be unit length
 @Override
 public void batchedUnitVectorGetSupportingVertexWithoutMargin(
  btVector3[] vectors,
  btVector3[] supportVerticesOut, int numVectors) {
  for (int i = 0; i < numVectors; i++) {
   if (supportVerticesOut[i] == null) {
    supportVerticesOut[i] = new btVector3();
   } else {
    supportVerticesOut[i].set(0, 0, 0);
   }
  }
 }

 @Override
 public void calculateLocalInertia(float mass, final btVector3 inertia) {
  float elem = (0.4f) * mass * getMargin() * getMargin();
  inertia.set(elem, elem, elem);
 }

 @Override
 public void getAabb(final btTransform t, final btVector3 aabbMin,
  final btVector3 aabbMax) {
  final btVector3 center = t.getOrigin();
  final btVector3 extent = new btVector3(getMargin(), getMargin(), getMargin());
  aabbMin.set(center).sub(extent);
  aabbMax.set(center).add(extent);
 }

 public float getRadius() {
  return m_implicitShapeDimensions.getX() * m_localScaling.getX();
 }

 public void setUnscaledRadius(float radius) {
  m_implicitShapeDimensions.setX(radius);
  super.setMargin(radius);
 }

 //debugging
 @Override
 public String getName() {
  return "SPHERE";
 }

 @Override
 public void setMargin(float margin) {
  super.setMargin(margin);
 }

 @Override
 public float getMargin() {
  //to improve gjk behaviour, use radius+margin as the full margin, so never get into the penetration case
  //this means, non-uniform scaling is not supported anymore
  return getRadius();
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
