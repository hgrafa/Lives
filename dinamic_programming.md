#

## Programação Dinâmica

**Problema motivador**: Geralmente em problemas recursivos eu produzo uma grande quantidade de casos repetidos.

ex.: Fibonacci

- a sequencia começa com {0, 1}
- os outros elementos sao calculados a partir da soma de dois elementos anteriores.

sequencia: `0, 1, 1, 2, 3, 5, 8, 13, 21`

- `fib[i] = fib[i-1] + fib[i-2]`

sol. iterativa:

```java
public int fib(n) {
  int[] fib = new int[n + 1];
  fib[0] = 0;
  fib[1] = 1;

  for(int i = 2; i <= n; i++) {
    fib[i] = fib[i-1] + fib[i-2];
  }

  return fib[n];
}
```

## ideia recursiva

```java
public <T> T ler_algo() {
  T leitura;

  try {
    leitura = ler();
  } catch (LeituraIncorretaException e) {
    leitura = ler_algo();
  }

  return leitura;
}
```

sol. recursiva:

lavar(10) = 1 + lavar(9)

- expressao recursiva
- caso base

```java
public int fib(int n) {
  // caso base
  if(n == 0) return 0;
  if(n == 1) return 1;

  // caso recursivo
  return fib(n - 1) + fib(n - 2);
}
```

Tabela que decorei

| valor | fib |
| :---: | :-: |
|   0   |  0  |
|   1   |  1  |
|   2   |  1  |
|   3   |  2  |

```
fib(6) = fib(5) +
fib(5) = fib(4) +
fib(4) = fib(3) + fib(2) = 2
fib(3) = fib(2) + fib(1) = 1 + 1 = 2
fib(2) = fib(1) + fib(0) = 1
fib(1) = 1
fib(0) = 0
```

## aplicando prog. dinamica

```java
import java.util.Arrays;

public int fib(int n) {
  Integer[] dp = new Integer[n+1];
  Arrays.fill(dp, null);
  dp[0] = 0;
  dp[1] = 1;
  return fib(dp, n);
}

private int fib(Integer[] dp, int n) {
  // caso dinamico
  if(dp[n] != null)
    return dp[n];

  // caso base
  if(n == 0) return 0;
  if(n == 1) return 1;

  // caso recursivo
  return dp[n] = fib(n - 1) + fib(n - 2);
}
```

## 🎒 Problema da mochila fracionaria

Eu tenho objetos que podem ser fracionados, com valor e peso associados, e tenho uma mochila com uma capacidade fixa.

**Objetivo:** Como levar o maior valor valor possivel na mochila, sem exceder a sua capacidade?

- Custo-beneficio = valor / peso

- Calculo o custo-beneficio dos objetos
- Ordeno decrescente pelo custo-beneficio
- Pego a maior quantidade possivel do objeto sem estourar a mochila

## 🎒 Problema da mochila 0/1

> Imagine que tenho objetos (indivisiveis) com valor e peso para levar a praia, e nao quero exceder a minha capacidade de carga, sendo assim como escolho a melhor objetos possivel.

### ❌ caso1: ordenando pelo valor

```
capacidade: 12
✅carro: peso 10, valor 15
❌ safira: peso 6, valor 9
❌oculos: peso 5, valor 8
```

eu escolheria apenas o carro.

Esta solucao tem como resposta o resultado 15 valor carregado, porem se eu carregasse o oculos e a safira eu levaria 17 de valor.

**NAO PODEMOS ORDENAR PELO VALOR**

### ❌ caso2: ordenando pelo peso

```
capacidade: 12
✅ Pedra: peso 5, valor 1
✅ safira: peso 6, valor 9
❌ carro: peso 10, valor 15
```

Esta solucao tem como resposta o resultado 10 valor carregado, porem o melhor caso seria 15.

**NAO PODEMOS ORDENAR PELO VALOR**

### ❌ caso3: ordenando pelo custo beneficio

```
capacidade: 12
✅ mesa: peso 2, valor 3 : 1.5
✅ lapis: peso 1, valor 1 : 1
❌ carro: peso 10, valor 10 : 1
✅ Pedra: peso 5, valor 1 : 0.2
```

Esta solucao tem como resposta o resultado 5 valor carregado, porem o melhor caso seria 13.

**NAO PODEMOS ORDENAR PELO CUSTO-BENEFICIO**

## Solução final

```java
public class Item {
  private int valor;
  private int peso;
  //  getters and setters omitidos por brevidade
}

public int knapsack(int aguenta, List<Item> items, int id) {
  // casos base
  if(aguenta == 0)
    return 0;

  if(items.size() == id)
    return 0;

  // caso recursivo
  int casoItemNaoEscolhido = knapsack(aguenta, items, id + 1);
  Item item = items.get(id);

  if(aguenta < item.peso) {
    return caso1;
  }

  int casoItemEscolhido = item.valor + knapsack(aguenta - item.peso, items, id + 1);

  return max(casoItemNaoEscolhido, casoItemEscolhido);
}
```
