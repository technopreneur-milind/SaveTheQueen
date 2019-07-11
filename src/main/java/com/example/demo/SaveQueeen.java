package com.example.demo;



import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

 class Result1 {

    /*
     * Complete the 'solve' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY a
     */

    public static void solve(int n, List<Integer> a) {
        Collections.sort(a);
        Collections.reverse(a);
        double sum = a.stream().mapToDouble(num -> Double.valueOf(num)).sum();
        double currentN = Double.valueOf(n);
        double currentSum = sum;
        for(Integer next : a)
        {
            double nextDouble = Double.valueOf(next);
            if(nextDouble<=currentSum/currentN)
            {
                break;
            }
            currentSum -= nextDouble;
            currentN--;
        }
        System.out.println(currentSum/currentN);


    }

}

public class SaveQueeen {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result1.solve(n, a);

        bufferedReader.close();
    }
}
