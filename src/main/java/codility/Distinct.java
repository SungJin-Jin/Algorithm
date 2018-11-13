package codility;

import java.util.HashSet;

import static utils.Utils.require;

public class Distinct {

    public static void main(String[] args) {

        require(3 == solve(new int[]{2, 1, 1, 2, 3, 1}));
    }

    private static int solve(int[] values) {
        HashSet<Integer> set = new HashSet<>();

        for (int value : values) set.add(value);

        return set.size();
    }
}
