package examples;
import java.util.Random;

import api.Generator;
import api.Position;
import api.Shape;

public class SampleGenerator implements Generator
{
  @Override
  public Shape getNext(int width)
  {
	int mid = width / 2;
	boolean isMagic = false;
	
	Random magic = new Random();
	int k = magic.nextInt();
	if(k == 1) {
		isMagic = true;
	}
	
	Random rand = new Random();
	int n = rand.nextInt(6)+1;
	if(n == 1) {
		return new SampleShape(new Position(-1, mid+1), isMagic);
	}
	else if(n == 2) {
		return new SampleShape(new Position(-1, mid), isMagic);
	}
	else if(n == 3) {
		return new SampleShape(new Position(-2, mid), isMagic);
	}
	else if(n == 4) {
		return new SampleShape(new Position(-1, mid), isMagic);
	}
	else if(n == 5) {
		return new SampleShape(new Position(0, mid), isMagic);
	}
	else {
		return new SampleShape(new Position(-1, mid), isMagic);
	}
    
  }
}
