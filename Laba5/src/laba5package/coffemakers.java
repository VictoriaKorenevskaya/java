package laba5package;
import java.util.Comparator;

public class coffemakers {
	private final int cost;
    private final int volume;
	private final String name;
	private final String color;
	 
public static class Builder
	 {
		 private final String name;
		 private final int volume;
		 private final int cost;
		 
		 private String color = " ";		 
  public Builder(String name, int volume, int cost){
			 this.name = name;
			 this.volume = volume;
			 this.cost = cost;
		 }
		 
 public Builder Color(String str){
			 color = str;
			 return this;
		 }
		 
 public coffemakers build(){ 
	         return new coffemakers(this);
	     }
}
	 
	 public coffemakers(Builder builder)
	 {
		 cost = builder.cost;
		 volume = builder.volume;
		 name = builder.name;
		 color = builder.color;
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
	 
	 
	 public static final Comparator<coffemakers> COMPARE_BY_COST = new Comparator<coffemakers>() {
	     @Override
	     public int compare(coffemakers lhs, coffemakers rhs) {
	         return lhs.GetCost() - rhs.GetCost();
	     }
	 };
	 public static final Comparator<coffemakers> COMPARE_BY_VOLUME = new Comparator<coffemakers>() {
	     @Override
	     public int compare(coffemakers lhs, coffemakers rhs) {
	         return lhs.GetVolume() - rhs.GetVolume();
	     }
	 };
			@Override
		public String toString() {
	     return "cost - "+this.cost+"  volume - "+this.volume+"  name - "+this.name+"  color - "+this.color;
	 }
}
