#include <iostream>

using std::cin;
using std::cout;
using std::endl;

// se encontrar retorna a posicao
// senao retorna -1
// melhor caso - 1
// pior caso - n operacoes
int busca_sequencial(int n, int vetor[], int alvo)
{

  for (int i = 0; i < n; i++)
  {
    if (vetor[i] == alvo)
    {
      return i;
    }
  }

  return -1;
}

int busca_binaria(int tam, int vetor[], int alvo)
{
  // inicializacao, verificacao e atualizacao
  int inicio = 0;
  int fim = tam - 1;

  while (fim >= inicio)
  {
    int meio = (inicio + fim) / 2;

    if (vetor[meio] == alvo)
      return meio;
    else if (vetor[meio] > alvo)
      fim = meio - 1;
    else
      inicio = meio + 1;
  }

  return -1;
}

int main()
{

  auto n = 5;
  int vetor[] = {1, 44, 19, 12, 25};
  int alvo;

  cout << "Digite o numero que deseja buscar: ";
  cin >> alvo;

  cout << "Pos: " << busca_sequencial(n, vetor, alvo) << endl;
}

// 1 22 33 44 55 66 77 88 99 00