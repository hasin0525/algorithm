import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static String nextPermutation(char[] arr) {
        int i = arr.length - 1;
        while (i > 0 && arr[i-1] >= arr[i]) {
            i--;
        }

        if( i <= 0 ) {
            return "no answer";
        }

        int j = arr.length - 1;
        while(arr[j] <= arr[i-1]) {
            j--;
        }

        char temp = arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = temp;

        j = arr.length - 1;
        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

        return String.valueOf(arr);
    }

    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
        return nextPermutation(w.toCharArray());
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
