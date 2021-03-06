/*
 * Bullet Continuous Collision Detection and Physics Library
 * Copyright (c) 2003-2006 Erwin Coumans  http://continuousphysics.com/Bullet/
 *
 * EPA Copyright (c) Ricardo Padrela 2006  *
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

import Bullet.Collision.Shape.btConvexShape;
import Bullet.LinearMath.btTransform;
import Bullet.LinearMath.btVector3;
import java.io.Serializable;

/**
 *
 * @author Gregery Barton
 */
public class btGjkEpaPenetrationDepthSolver implements
 btConvexPenetrationDepthSolver, Serializable {

 /**
  *
  * @param simplexSolver
  * @param convexA
  * @param convexB
  * @param transformA
  * @param transformB
  * @param v
  * @param wWitnessOnA
  * @param wWitnessOnB
  * @param debugDraw
  * @return
  */
 @Override
 public boolean calcPenDepth(btSimplexSolverInterface simplexSolver,
  btConvexShape convexA,
  btConvexShape convexB, final btTransform transformA,
  final btTransform transformB,
  final btVector3 v, final btVector3 wWitnessOnA, final btVector3 wWitnessOnB,
  btIDebugDraw debugDraw) {
//	  float				radialmargin(float(0.));
  final btVector3 guessVector = transformB.getOrigin().sub(transformA
   .getOrigin());
  btGjkEpaSolver2.sResults results = new btGjkEpaSolver2.sResults();
  if (btGjkEpaSolver2.Penetration(convexA, transformA,
   convexB, transformB,
   guessVector, results)) {
   //	debugDraw.drawLine(results.witnesses[1],results.witnesses[1]+results.normal,btVector3(255,0,0));
   //resultOut.addContactPoint(results.normal,results.witnesses[1],-results.depth);
   wWitnessOnA.set(results.witnesses[0]);
   wWitnessOnB.set(results.witnesses[1]);
   v.set(results.normal);
   return true;
  } else if (btGjkEpaSolver2
   .Distance(convexA, transformA, convexB, transformB, guessVector, results)) {
   wWitnessOnA.set(results.witnesses[0]);
   wWitnessOnB.set(results.witnesses[1]);
   v.set(results.normal);
   return false;
  }
  return false;
 }

}
