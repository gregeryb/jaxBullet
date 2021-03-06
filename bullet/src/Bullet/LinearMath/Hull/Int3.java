/*
 * Stan Melax Convex Hull Computation
 * Copyright (c) 2008 Stan Melax http://www.melax.com/
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
package Bullet.LinearMath.Hull;

import java.io.Serializable;
import javax.vecmath.IntSmartPointer;
import javax.vecmath.Tuple3i;

/**
 *
 * @author Gregery Barton
 */
public class Int3 extends Tuple3i<Int3> implements Serializable {

 public Int3(int x, int y, int z) {
  super(x, y, z);
 }

 public Int3(Tuple3i t1) {
  super(t1);
 }

 public Int3() {
 }

 public static class Pointer extends IntSmartPointer<Int3> {

  private final int element;

  public Pointer(Int3 object, int element) {
   super(object);
   this.element = element;
  }

  @Override
  public int get() {
   return object().getElement(element);
  }

  @Override
  public void set(int value) {
   object().setElement(element, value);
  }

 }
}
