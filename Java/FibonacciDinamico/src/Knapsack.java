import java.util.List;

import static java.lang.Math.max;

public class Knapsack {

    public static int calculate(int aguenta, List<Item> items) {
        int MAX_AGUENTA = 10000, MAX_OBJETOS = 100000;
        Integer[][] dp = new Integer[MAX_AGUENTA][MAX_OBJETOS];
        return calculate(aguenta, dp, items, 0);
    }

    private static int calculate(int aguenta, Integer[][] dp, List<Item> items, int id) {
        if(dp[aguenta][id] != null) {
            return dp[aguenta][id];
        }

        // casos base
        if(aguenta == 0)
            return dp[aguenta][id] = 0;

        if(items.size() == id)
            return dp[aguenta][id] = 0;

        // caso recursivo
        int casoItemNaoEscolhido = calculate(aguenta, dp, items, id + 1);
        Item item = items.get(id);

        if(aguenta < item.peso) {
            return casoItemNaoEscolhido;
        }

        int casoItemEscolhido = item.valor + calculate(aguenta - item.peso, dp, items, id + 1);

        return dp[aguenta][id] = max(casoItemNaoEscolhido, casoItemEscolhido);
    }


}
