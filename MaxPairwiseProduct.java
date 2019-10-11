// import java.util.*;
// import java.io.*;

public class MaxPairwiseProduct {
    static int getMaxPairwiseProduct(int[] numbers) {
        int product = 0;
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                product = Math.max(product, numbers[i] * numbers[j]);
            }
        }
        return product;
    }

}