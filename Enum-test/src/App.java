import models.enums.Month;

import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int idMes = input.nextInt();
        var month = Month.get(idMes);
        System.out.println("month requested: " + month.getName());
        System.out.printf("spent money: $%.2f", month.getSpentMoney());
    }
}
