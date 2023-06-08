#include <iostream>

using namespace std;

int main()
{

  int vetor[] = {0, 1, 2, 3, 4, 5, 6, 7};

  // cout << vetor << endl;
  cout << vetor[2] << endl;
  cout << *(vetor + 2) << endl;
  cout << *(2 + vetor) << endl;
  cout << 2 [vetor] << endl;
}