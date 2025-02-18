/*
APPIAH GIDEON
01210830B
JAVA ASSIGNMENT
*/


public class LargestElement {
    public static void main(String[] args) {
        // Example array
        int[] numbers = {5, 3, 8, 1, 2, 7};
        
      
        int max = numbers[0];
        
       
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        
     
        System.out.println("The largest element in the array is: " + max);
    }
}
