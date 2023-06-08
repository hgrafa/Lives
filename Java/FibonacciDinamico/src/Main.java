import java.util.List;

public class Main {
    public static void main(String[] args) {
        var item1 = new Item(3, 2);
        var item2 = new Item(1, 1);
        var item3 = new Item(10, 10);
        var item4 = new Item(1, 5);

        int capacidade = 12;
        List<Item> items = List.of(item1, item2, item3);
        long start = System.nanoTime();
        System.out.println(Knapsack.calculate(capacidade, items));
        long end = System.nanoTime();

        System.out.println("Time: " + (end - start) + "ns");
    }
}