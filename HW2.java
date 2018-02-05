import java.util.Scanner;
public class HW2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        
        System.out.println("Bear game!");
        System.out.print("Enter the number of bears: ");
        int b = reader.nextInt();
        boolean bearResult = bears(b);
        
        if (bearResult)
            System.out.println("Congratulations! You got to 42 bears!");
        else
            System.out.println("Shucks! You couldn't get 42 bears out of " + b + "...");
        
        System.out.println("Triangle game!");
        System.out.print("Enter a number: ");
        int m = reader.nextInt();
        System.out.print("Enter a larger number: ");
        int n = reader.nextInt();
        while (m > n) {
            System.out.print("You need to enter a larger number: ");
            n = reader.nextInt();
        }
        
        triangle(m, n);
        
        reader.close();
    }
    
    public static boolean bears(int n) {
        //base case
        if (n == 42)
            return true;
        else if (n < 42)
            return false;
        
        //recursive case
        else {
            if (n % 5 == 0)
                return bears(n - 42);
            else if ((n % 3 == 0 || n % 4 == 0) && n%10>0 && n%100/10>0)
                return bears(n - ((n%10) * (n%100/10)));
            else if (n % 2 == 0)
                return bears(n / 2);
            else
            	return false;
        }
    }
    
    public static void triangle(int m, int n) {
    	String stars = "";
    	for (int i = 0; i < m; i++) {
    		stars += "*";
    	}
    	//base case
        if (m == n) {
        	System.out.println(stars);
        	System.out.println(stars);
        }

        //recursive case
        else {
            System.out.println(stars);
            triangle(m + 1, n);
            System.out.println(stars);
        }
    }
}