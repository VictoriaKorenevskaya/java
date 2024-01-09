package lab4_package;
import java.io.BufferedReader;
import java.io.PrintStream;

public abstract class readWrite {
	
	
	public abstract String Read(BufferedReader reader, String name_of_file);
	public abstract void Write(PrintStream fileOut,  Items mult, String name_of_file);
	public abstract int Check();
}
