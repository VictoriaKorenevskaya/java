package laba5package;

import java.util.ArrayList;
import java.util.Collections;

public class itemsSingletone
{
	private static ArrayList<coffemakers> makers;
	private static itemsSingletone makerscof;
	
	private itemsSingletone()
	{
		makers = new ArrayList<coffemakers>();
	}
	
	public static itemsSingletone GetInstance()
	{
		if(makerscof == null)
		{
			makerscof = new itemsSingletone();
		}
		
		return makerscof;
	}
	
	public ArrayList<coffemakers> GetList()
	{
		return this.makers;
	}
	
	public int Size()
	{
		return makers.size();
	}
	
	public coffemakers get(int i)
	{
		return makers.get(i);
	}
	
	public void insert(coffemakers cooker)
	{
		makers.add(cooker);
	}
	
	void costSort()
	{
		Collections.sort(makers, coffemakers.COMPARE_BY_COST);
	}
	
	void volumeSort()
	{
		Collections.sort(makers, coffemakers.COMPARE_BY_VOLUME);
	}
}
