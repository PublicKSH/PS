#include <iostream> 
using namespace std;

int Fibo(int n) {
	if (n == 0)
		return 0;
	else if(n == 1)
		return 1;
	return Fibo(n-1)+Fibo(n-2);
}

int main() {
	int N;
	cin >> N;
	cout << Fibo(N);
}