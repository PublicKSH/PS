#include <iostream> 
using namespace std;

int Fectorial(int n) {
	if (n == 1 || n == 0)
		return 1;
	return n*Fectorial(n-1);
}

int main() {
	int N;
	cin >> N;
	cout << Fectorial(N);
}