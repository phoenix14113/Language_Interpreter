package edu.wallawalla.cs.cptr354.shape;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ShapeTests {

  @Test
  public void testRectangle() throws Exception {
    Rectangle r = new Rectangle(3, 5);
    assertEquals(15f, r.area(), 0f);
    assertEquals(16f, r.perimeter(), 0f);
  }

  @Test
  public void testCircle() throws Exception {
    Circle c = new Circle(5);
    assertEquals(25f * Math.PI, c.area(), 0f);
    assertEquals(10f * Math.PI, c.perimeter(), 0f);
  }

}