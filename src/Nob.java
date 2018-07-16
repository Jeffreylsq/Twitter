import java.util.ArrayList;
import java.util.Observable;

public class Nob extends Observable {

	private String name;
	private String moment;
	
       
	public void setName(String n)
	{
		name = n;
	}


	public void setMoment(String n)
	{
		moment =n;
		setChanged();
		notifyObservers();
	}
	
	



	public String getMoment() {
		
		return moment;
	}
	public String getName() {
		
		return name;
	}

	
}