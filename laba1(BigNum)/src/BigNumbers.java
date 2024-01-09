
import java.util.Formatter;
import java.util.Scanner;
import java.math.BigInteger;
import java.math.BigDecimal;

public class BigNumbers {
public static void main(String[] args) {
  
    try (Scanner scanner = new Scanner(System.in)) {
		double xx;
		  do{
		    System.out.println("Enter x:");
		    xx = scanner.nextDouble();
		  } while (Math.abs(xx)>= 1);
		  BigDecimal x = new BigDecimal(xx);
		  
		    System.out.println("Enter k:");
		    int k = scanner.nextInt();
		    
		    
		        System.out.println("ln(1-x) = " + Math.log(1 -xx));
		
		        BigDecimal epsilon = BigDecimal.ONE;
		        for(int i =1; i <=k; i++) {
		        	epsilon = epsilon.divide(BigDecimal.TEN);
		        }
		       
		       
		      BigDecimal result = x.negate();
		  	  BigDecimal i = new BigDecimal(2);
		  	  BigDecimal a = x;
		  	  BigDecimal res = x;
		  	  
		  
		  		 a = a.multiply(res);
		  		 a = a.divide(i);
		  		 a = a.negate();
		  		 result = result.add(a);
		  		 a = a.abs();
		  		 a = a.multiply(i);
		  		 i = i.add(BigDecimal.ONE);
		  		 
		  	  
		    System.out.println("Taylor's row:  " + result);
		
		    Formatter formatter = new Formatter(System.out);
		    
		    System.out.println("Enter the Decimal Value: ");
		    BigInteger intValue = scanner.nextBigInteger();
		      
		     
		    formatter.format("Octal(8): %o%n", intValue);
		    formatter.format("Hexadecimal(16): %x%n", intValue);
		       
		    
		    double number = 12.8;
		    int minWidth = 15; 
		    int precision = 2; 
		
		    System.out.printf("Число: %%" + minWidth + "." + (precision + 1) + "f%n", number);
		  
		
		    double negativeValue = -123.4;
		    double doubleValue = 4.3;
		    System.out.println(doubleValue);
		    formatter.format("Отрицательное число с флагом '+' и точностью: %+10.2f%n", negativeValue);
		    formatter.format("Число с флагом '0': %010.2f%n", doubleValue);
		    formatter.format("Число с флагом '#': %.4e%n", doubleValue);
		  
		    formatter.close();
	}

  }
  
}
