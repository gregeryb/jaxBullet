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
package Bullet.Dynamics.Constraint;

import java.io.Serializable;

/**
 *
 * @author Gregery Barton
 */
public class btConstraintSetting implements Serializable {

 btConstraintSetting() {
  m_tau = 0.3f;
  m_damping = 1.f;
  m_impulseClamp = 0f;
 }

 public float m_tau;
 public float m_damping;
 public float m_impulseClamp;
}
