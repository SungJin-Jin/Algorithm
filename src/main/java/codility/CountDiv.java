package main.java.codility;

public class CountDiv {

    public static void main(String[] args) {

        require(3 == solve(6, 11, 2));
        require(2 == solve(5, 10, 5));
    }

    private static int solve(int start, int end, int divisor) {
        int interval = end - start + 1;
        return interval % divisor != 0 ? interval / divisor + 1 : interval / divisor;
    }

    private static void require(boolean isValid) {
        if (!isValid) throw new IllegalArgumentException("Failed requirement");
    }
}
