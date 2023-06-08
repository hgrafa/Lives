# Recursoes

- Call Stack (Ultima chamada, primeira execucao)
- Divisao e Conquista

É uma função que faz parte da solução de um problema maior criado pela própria função.

objetivo: calcular a soma de (1 -> 100)

> Bottom up é tipo ir da base pra solução e top down é tipo ir da solução pro caso base

> ~ Noob, Gabi

## Elementos essenciais

- caso base
- caso recursivo

## Bottom up

```java
int soma = 0;

for(int i = 1; i <= 100; i++) {
  soma += i
}
```

- `(1 -> 100) = 100 + (1 -> 99)`

## Top down

```java
double soma(int inicio, int fim) {
  // caso base
  if (inicio == fim)
    return fim;

  // caso recursivo
  return fim + soma(inicio, fim - 1);
}
```

```
(1->3) = // inicio
3 + (1 -> 2)
3 + 2 + (1 -> 1)
3 + 2 + 1 = 6
```

## Exemplos

### exemplo1

Dada uma sequencia extraia recursivamente todos os multiplos de 3.

```
[3 4 5 7 8 9 10]
[ 3 ] + [4 5 7 8 9 10 ]
[ 3 ] + 4  + [ 5 7 8 9 10 ]
[ 3 ] + [ 5 7 8 9 10 ]
```

- m(0 -> 10) = decidir(0) + m(1 -> 10)
- m(0 -> 10) = decidir(0) + decidir(1) + m(2 -> 10)

```java
boolean isMultipleOf(int number, int divisor) {
  return numer % 3 == 0;
}

List<Integer> getMultiplesOfByIndex(int pos, List<Integer> sequence) {
  List<Integer> multiples = new ArrayList<>();
  int currentValue = sequence.get(pos);

  if(isMultipleOf(currentValue,3)) {
    multiples.add(currentValue);
  }

  return mutiples.addAll( getMultiplesOf(pos + 1, sequence) );
}

List<Integer> getMultiplesOf(List<Integer> sequence) {
  List<Integer> multiples = new ArrayList<>();
  int currentValue = sequence.get(0);

  if(isMultipleOf(currentValue,3)) {
    multiples.add(currentValue);
  }

  sequence.remove(0);
  return mutiples.addAll( getMultiplesOf(pos + 1, sequence) );
}
```

## Recursão em fibonacci (Top down)

quantCoelhos(n) = quantCoelhos(n-1) + quantCoelhos(n-2)

```java
int fib(int n) {
  if(n == 0) return 0;
  if(n == 1) return 1;

  return fib(n-1) + fib(n-2);
}
```

quantidade de operacoes `2^(n+1) - 1`
complexidade: O(`2^n`)

fib(2) = 1
fib(3) = 2

## Fibonacci com Programacao Dinamica

### Elementos essenciais

- caso dinamico
- caso base
- caso recursivo

[null, null, null, null, null, null]

```java
public int fib(n){
  List<Integers> dp = new ArrayList<>();
  for (int i = 0; i <= n; i++) {
    dp.add(null);
  }

  fib(dp, int n);
}

private int fib(List<Integers> dp, int n) {

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
    result = 1;
  }

  // caso recursivo
  result = fib(n-1) + fib(n-2);
  dp.set(n, result);
  return result;
}
```

## Problema da mochila

solucao inicial: conjunto partes

conjunto das partes: todos os conjuntos que consigo formar combinando um conjunto original

{1, 2, 3, 4}
2 _ 2 _ 2 \* 2 = 2^4 = 16
