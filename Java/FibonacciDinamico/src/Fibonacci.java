import java.util.Arrays;

public class Fibonacci {
    public static int fib(int n) {
        Integer[] dp = new Integer[n+1];
        Arrays.fill(dp, null);
        dp[0] = 0;
        dp[1] = 1;
        return fib(dp, n);
    }

    private static int fib(Integer[] dp, int n) {
        // caso dinamico
        if(dp[n] != null)
            return dp[n];

        // caso base
        if(n == 0) return 0;
        if(n == 1) return 1;

        // caso recursivo
        return dp[n] = fib(dp, n - 1) + fib(dp, n - 2);
    }
}
