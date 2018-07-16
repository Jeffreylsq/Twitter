import java.util.Observable;
import java.util.Observer;

public class Nobserver implements Observer  {

	private String name;
	Nobserver(String n)
	{
		name = n;
	}
	
	
	

public void update(Observable o, Object arg) {
    Nob myObserable= (Nob)o;
 
  
    String xx = myObserable.getMoment();
 }
}