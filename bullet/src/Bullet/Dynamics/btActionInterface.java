/*
Bullet Continuous Collision Detection and Physics Library
Copyright (c) 2003-2006 Erwin Coumans  http://continuousphysics.com/Bullet/

This software is provided 'as-is', without any express or implied warranty.
In no event will the authors be held liable for any damages arising from the use of this software.
Permission is granted to anyone to use this software for any purpose, 
including commercial applications, and to alter it and redistribute it freely, 
subject to the following restrictions:

1. The origin of this software must not be misrepresented; you must not claim that you wrote the original software. If you use this software in a product, an acknowledgment in the product documentation would be appreciated but is not required.
2. Altered source versions must be plainly marked as such, and must not be misrepresented as being the original software.
3. This notice may not be removed or altered from any source distribution.
*/
package Bullet.Dynamics;

import Bullet.Collision.btCollisionWorld;
import Bullet.Collision.btIDebugDraw;
import Bullet.LinearMath.btVector3;
import java.io.Serializable;

/**
 * Basic interface to allow actions such as vehicles and characters to be updated inside a
 * btDynamicsWorld
 *
 * @author Gregery Barton
 */
abstract public class btActionInterface  implements Serializable {

 static btRigidBody s_fixed = new btRigidBody(0, null, null);

 static btRigidBody getFixedBody() {
  s_fixed.setMassProps(0f, new btVector3());
  return s_fixed;
 }

 abstract void updateAction(btCollisionWorld collisionWorld, float deltaTimeStep);

 abstract void debugDraw(btIDebugDraw debugDrawer);
}
