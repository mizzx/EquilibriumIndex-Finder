/* The purpose of this program is to find equilibrium indices in an array 
 * elements entered by the user
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class indexSimpler {

    //Method to find equilibrium indices in an array
    public static List<Integer> findEquilibriumIndices(int[] arr) {
        List<Integer> indices = new ArrayList<>();
        int n = arr.length;
        int totalSum = 0;

        // Calculate sum of all elements in the array
        for (int num : arr) {
            totalSum += num;
        }

        int leftSum = 0;
        // Iterate through each element in the array
        for (int i = 0; i < n; i++) {
            totalSum -= arr[i]; // Calculate sum of right elements
            if (leftSum == totalSum) {
                indices.add(i); // Add the equilibrium index
            }
            leftSum += arr[i]; // Update sum of left elements
        }

        return indices;
    }

    //Main method to run the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the elements in integer separated by spaces:");
        String input = scanner.nextLine();
        String[] inputs = input.split(" ");
        int n = inputs.length;
        int[] arr = new int[n];
        
        try {
            // Convert array of strings entered by user into an array of integers
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputs[i]); 
            }
        } catch (Exception e) {
            // Display error message if non-integer in entered
            System.out.println("INVALID INPUT!");
            return;
            // System.out.println("Enter the elements in integer separated by spaces:");
            // input = scanner.nextLine();
            // inputs = input.split(" ");
            // n = inputs.length;
            // arr = new int[n];
        }
        scanner.close();
        // int[] arr = { -1, 3, -4, 5, 1, -6, 2, 1, -3, 2, -1, 4, -5, 6, 7, -8, 9, -10, 11, -12 };
        
        //Find equilibrium indices in the input array
        List<Integer> equilibriumIndices = findEquilibriumIndices(arr);
        if (equilibriumIndices.size() > 0) {
            System.out.println("Equilibrium indices found at indexes: " + equilibriumIndices);
        } else {
            System.out.println("No equilibrium index found");
        }
    }
}
