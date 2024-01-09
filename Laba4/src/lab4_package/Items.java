package lab4_package;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;

public class Items {
	
	private ArrayList<Coffemakers> cofmakers;
	
	
	public Items()
	{
		cofmakers = new ArrayList<Coffemakers>();
	}
	
	public int Size()
	{
		return cofmakers.size();
	}
	
	public Coffemakers get(int i)
	{
		return cofmakers.get(i);
	}
	
	public void insert_object(Coffemakers coffee)
	{
		cofmakers.add(coffee);
	}

	void sortByCost()
	{
		Collections.sort(cofmakers, Coffemakers.COMPARE_BY_COST);
	}
	
	void sortByVolume()
	{
		Collections.sort(cofmakers, Coffemakers.COMPARE_BY_VOLUME);
	}
	
	void Print(String OutputFileName, Txt file)
	{
		 try {
			 PrintStream fileOut = new PrintStream( OutputFileName);
	          
            file.Write(fileOut, this, OutputFileName);
		
           	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
        }
	
	
	void Print(String OutputFileName, XML file)
	{
		try {
			 PrintStream fileOut = new PrintStream( OutputFileName);
	          
           file.Write(fileOut, this,  OutputFileName);
		
          	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
        }
	
	
	
	}
    

