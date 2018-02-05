import java.util.Scanner;
public class HW1 {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
	    
		//Question 1
		System.out.println("***Question 1***");
		System.out.print("Enter a base number: ");
		double base = reader.nextDouble();
		System.out.print("Enter an exponent: ");
		int exponent = reader.nextInt();
		double result = raiseToPower(base, exponent);
		System.out.println(base + " raised to the power of " + exponent + " = " + result);
		
		//Question 2
	    System.out.println("***Question 2***");
	    System.out.print("Enter a number: ");
	    int input = reader.nextInt();
	    
	    while (input > 1) {
	    	input = hailstorm(input);
	    }
	    
	    reader.close();
	}

	public static int hailstorm(int num) {
	    if (num % 2 == 0) {//if even
	        System.out.println(num + " is even, so I take half: " + num / 2);
	        return num / 2;
	    }
	    else { //must be odd if not even
	        System.out.println(num + " is odd, so I make 3n + 1: " + (num * 3 + 1));
	        return num * 3 + 1;
	    }
	}
	
	private static double raiseToPower(double base, int exponent) {
	    // Set variable to be returned
	    // initialized to 1.0 since if exponent == 0, it will simply ignore
	    // the for loop and return as 1.0
	    double result = 1.0;
	    
	    if (exponent < 0) {
	        // reverses traditional for loop since exponent will be negative
	        for (int i = 0; i > exponent; i--) {
	            // for negative exponents, result is multiplied by inverse of the base
	            result *= (1.0 / base);
	        }
	    }
	    else {
	        for (int i = 0; i < exponent; i++) {
	            // adjusts for each power in the exponent
	            result *= base;
	        }
	    }
	    // no code for exponent == 0, since it will route to else loop and skip the
	    // loop, since i [= 0] is not less than exponent [= 0]
	    // therefore, result remains at initialized value of 1.0, which is correct for any base^0
	    return result;
	}
}
