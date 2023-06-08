# Complexidade

Basicamente, é a função que rege a forma com que nosso código varia em quantidade de operações.

- quantida de operacoes: 2n
- complexidade: O(n) - linear

| quantida de op | entrada |
| :------------: | :-----: |
|       20       |   10    |
|       40       |   20    |
|    1000000     | 1000000 |

# Divisão e conquista

## Algoritmo Guloso (Greedy)

Algoritmo guloso pode ser usado quando a melhor solução é equivalente a soma das melhores soluções parciais.

## Problema da mochila Fracionario

dado um conjunto de objetos fracionaveis com valor e peso associados, como posso colocar estes objetos na minha mochila sem estourar a capacidade maxima dela

solucao:

custo_benefico = valor / peso

- montar um vetor ordenado pela propriedade custo-beneficio
- escolher o maximo de cada objeto respeitando sua quantidade

## Pseudocodigo

```
fazendoAlgo()

loop i : 1 -> n
  fazendoAlgo()

loop i : 1 -> n
  fazendoAlgo()

loop i : 1 -> n
  fazendoAlgo()
```

- Total de operacoes = `3n + 1`
- complexidade: O(n) - linear

## Problema da mochila

dado um conjunto de objetos com valor e peso associados, como posso colocar estes objetos na minha mochila sem estourar a capacidade maxima dela
