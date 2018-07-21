package main.java.codility;

import java.util.Arrays;

import static main.java.utils.Utils.require;

public class Distinct {

    public static void main(String[] args) {

        require(3 == solve(new int[]{2, 1, 1, 2, 3, 1}));
    }

    private static int solve(int[] values) {
        if (values.length == 0) return 0;

        final int[] result = {1};
        Arrays.stream(values)
                .sorted()
                .reduce((left, right) -> {
                    if (left != right) result[0] = result[0] + 1;

                    return right;
                });

        return result[0];
    }
}
