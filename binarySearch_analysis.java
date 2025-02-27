import java.util.Random;
import java.util.ArrayList;

public class BinarySearchAnalysis {

    // Global variable to count the number of steps
    static int stepCount = 0;

    // Recursive binary search function
    static int recursiveBinarySearch(ArrayList<Integer> arr, int left, int right, int target) {
        stepCount++;
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) == target) {
                return mid;
            } else if (arr.get(mid) > target) {
                return recursiveBinarySearch(arr, left, mid - 1, target);
            } else {
                return recursiveBinarySearch(arr, mid + 1, right, target);
            }
        }
        return -1;
    }

    // Function to analyze the binary search
    static void analyzeBinarySearchRecursive() {
        ArrayList<Integer> inputSizes = new ArrayList<>();
        inputSizes.add(10);
        inputSizes.add(20);
        inputSizes.add(30);
        inputSizes.add(40);
        inputSizes.add(50);
        inputSizes.add(100);

        for (int size : inputSizes) {
            ArrayList<Integer> arr = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                arr.add(i + 1);
            }

            // Best case: target is the middle element
            int bestCase = arr.get((size - 1) / 2);
            // Worst case: target is the last element
            int worstCase = arr.get(size - 1);
            // Random case: target is a random element
            Random rand = new Random();
            int randomIndex = rand.nextInt(size);
            int randomCase = arr.get(randomIndex);

            System.out.println("=================== Input Size: " + size + " ===================");
            
            // Reset stepCount and perform best case search
            stepCount = 0;
            recursiveBinarySearch(arr, 0, size - 1, bestCase);
            System.out.println("Best Case = " + stepCount + " steps");

            // Reset stepCount and perform average case search
            stepCount = 0;
            recursiveBinarySearch(arr, 0, size - 1, randomCase);
            System.out.println("Average Case = " + stepCount + " steps");

            // Reset stepCount and perform worst case search
            stepCount = 0;
            recursiveBinarySearch(arr, 0, size - 1, worstCase);
            System.out.println("Worst Case = " + stepCount + " steps");

            System.out.println("===================================================================");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        analyzeBinarySearchRecursive();
    }
}
