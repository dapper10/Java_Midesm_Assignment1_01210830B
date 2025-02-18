/*
APPIAH GIDEON
01210830B
JAVA ASSIGNMENT
*/


public class SumOf2DArray {
    public static void main(String[] args) {
        // Example 2D array
        int[][] array = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Calculate the sum of all elements
        int sum = calculateSum(array);

        // Display the result
        System.out.println("The sum of all elements in the 2D array is: " + sum);
    }

    // Method to calculate the sum of all elements in a 2D array
    public static int calculateSum(int[][] array) {
        int sum = 0;

        // Iterate through each row
        for (int i = 0; i < array.length; i++) {
            // Iterate through each column in the current row
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
            }
        }

        return sum;
    }
}
