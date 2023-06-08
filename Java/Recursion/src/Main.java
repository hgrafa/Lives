import java.util.ArrayList;
import java.util.List;

public class Main {
    private static boolean isMultipleOf(int number, int divisor) {
        return number % 3 == 0;
    }

    private static void log(List<Integer> s1, List<Integer> s2) {
        System.out.println("-------------------------");
        s1.forEach(e -> System.out.print(e + ", "));
        System.out.println();
        s2.forEach(e -> System.out.print(e + ", "));
        System.out.println();
        System.out.println("-------------------------");
    }

    private static List<Integer> getMultiplesOfByIndex(int pos, List<Integer> sequence) {
        // caso base
        if (sequence.size() == pos) {
            return new ArrayList<>();
        }

        List<Integer> multiples = new ArrayList<>();
        int currentValue = sequence.get(pos);

        // execute algo
        if(isMultipleOf(currentValue,3)) {
            multiples.add(currentValue);
        }

        // caso recursivo
        multiples.addAll( getMultiplesOfByIndex(pos + 1, sequence) );
        log(sequence, multiples);
        return multiples;
    }

    public static List<Integer> filterMultiplesOfThree(List<Integer> sequence) {
        List<Integer> multiples = new ArrayList<>();
        filterMultiplesOfThree(multiples, sequence);
        return multiples;
    }

    private static void filterMultiplesOfThree(List<Integer> multiples, List<Integer> sequence) {
        // caso base
        if(sequence.size() == 0)
            return;

        // execute algo
        int firstValue = sequence.get(0);

        if(isMultipleOf(firstValue,3)) {
            multiples.add(firstValue);
        }

        sequence.remove(0);

        // caso recursivo
        log(sequence, multiples);
        filterMultiplesOfThree(multiples, sequence);
    }

    public static int fib(int n){
        List<Integer> dp = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            dp.add(null);
        }

        return fib(dp, n);
    }

    private static int fib(List<Integer> dp, int n) {

        // caso dinamico
        if(dp.get(n) != null)
            return dp.get(n);

        // casos base
        if(n == 0) {
            dp.set(n, 0);
            return 0;
        }

        if(n == 1) {
            dp.set(n, 1);
            return 1;
        }

        // caso recursivo
        int result = fib(n-1) + fib(n-2);
        dp.set(n, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fib(14));
    }
}