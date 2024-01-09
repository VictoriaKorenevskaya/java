
import java.util.Scanner;
import java.util.Formatter;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
	double x;
	do{
		System.out.println("Enter x:");
		 x = scanner.nextDouble();	
	}while((x <= -1)||(x >= 1));
		
		System.out.println("Enter k:");
		int k = scanner.nextInt();
		
		double standartResult = Math.log(1 - x);
		System.out.println("ln(1-x) = " + standartResult);
		
		double epsilon = Math.pow(10, -k);
		
		double approxim = calculateTaylorSeries(x, epsilon);
		System.out.println("Taylor's row:  " + approxim );
		
		double difference = Math.abs( standartResult - approxim);
		System.out.println("The difference is: " + difference );
		
		
		
		Formatter formatter = new Formatter(System.out);
		
		System.out.println("Enter the Decimal Value:");
		int intValue = scanner.nextInt();
	    
	     formatter.format("Octal(8): %o%n", intValue);
	     formatter.format("Hexadecimal(16): %x%n", intValue);
	     
	        double number = 12.8;
	        int minWidth = 15; 
	        int precision = 2; 

	    System.out.printf("Число: %%" + minWidth + "." + (precision + 1) + "f%n", number);
	
	        
		double negativeValue = -123.4;
		double doubleValue = 4.3;
		System.out.println(doubleValue);
		formatter.format("Negative number with the flag '+' and precision: %+10.2f%n", negativeValue);
		formatter.format("Number with the flag  '0': %010.2f%n", doubleValue);
		formatter.format("Number with the flag  '#': %.4e%n", doubleValue);
	
	    formatter.close();
	    scanner.close();

	}
	
	public static double calculateTaylorSeries(double x, double epsilon) {
		
		double result = 0;
        double term = x;    
        
        for (int i = 1; Math.abs(term) >= epsilon; i++) {
        	 term = -Math.pow(x, i) / i;
            result += term;
        }
        return result;
    }	
	
}