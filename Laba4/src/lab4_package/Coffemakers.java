package lab4_package;

import java.util.Comparator;

public class Coffemakers extends abstractCoffe {
	
	public Coffemakers(String name, int volume, String color, int cost)
	{
		this.name = name;
		this.volume = volume;
		this.color = color;
		this.cost = cost;
	}
	
	public Coffemakers()
	{
		this.name = null;
		this.volume = 0;
		this.color = null;
		this.cost = 0;
	}
	public void SetCost( int cost)
	{
		 this.cost = cost;
	}
	public void SetVolume( int volume)
	{
		 this.volume = volume;
	}
	public void SetColor(String color)
	{
		this.color = color;
	}
	public void SetName(String name)
	{
		this.name = name;
	}
	public int GetCost()
	{
		return this.cost;
	}
	public int GetVolume()
	{
		return this.volume;
	}
	public String GetName()
	{
		return this.name;
	}
	public String GetColor()
	{
		return this.color;
	}
	
	public static final Comparator<Coffemakers> COMPARE_BY_COST = new Comparator<Coffemakers>() {
        @Override
        public int compare(Coffemakers lhs, Coffemakers rhs) {
            return lhs.GetCost() - rhs.GetCost();
        }
    };
    
    public static final Comparator<Coffemakers> COMPARE_BY_VOLUME = new Comparator<Coffemakers>() {
        @Override
        public int compare(Coffemakers lhs, Coffemakers rhs) {
            return lhs.GetVolume() - rhs.GetVolume();
        }
    };
	
	@Override
	public String toString() {
        return "cost - "+this.cost+"  volume - "+this.volume+"  name - "+this.name+"  color - "+this.color;
    }
}
