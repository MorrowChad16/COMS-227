package lab5;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import balloon4.Balloon;

public class BalloonTests {
    
    @Test
    public void testInitial()
    {
      Balloon b = new Balloon(10);
      assertEquals(false, b.isPopped());
    }

    @Test
    public void testblow()
    {
      Balloon b = new Balloon(10);
      b.blow(5);
      assertEquals(5, b.getRadius());
    }

    @Test
    public void testgetRadius()
    {
      Balloon b = new Balloon(10);
      b.blow(5);
      assertEquals(5, b.getRadius());
    }

    @Test
    public void testDeflate()
    {
      Balloon b = new Balloon(10);
      b.blow(5);
      assertEquals(5, b.getRadius());
      b.deflate();
      assertEquals(0, b.getRadius());
    }
    
    @Test
    public void testDeflatePopped()
    {
      Balloon b = new Balloon(10);
      b.blow(5);
      assertEquals(5, b.getRadius());
      b.deflate();
      assertEquals(0, b.getRadius());
      assertEquals(false, b.isPopped());
    }
    
    @Test
    public void testIsPopped()
    {
      Balloon b = new Balloon(10);
      b.blow(11);
      assertEquals(true, b.isPopped());
    }
    
    @Test
    public void testPop()
    {
      Balloon b = new Balloon(10);
      b.blow(5);
      b.pop();
      assertEquals(true, b.isPopped());
    }
}
