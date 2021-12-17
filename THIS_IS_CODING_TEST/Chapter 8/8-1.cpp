#include <bits/stdc++.h>

using namespace std;

int fibo(int x) {
	if (x == 1 || x == 2) return 1;
	return fibo(x - 1) + fibo(x - 2);
}

int main() {
	cout << fibo(4);
	return 0;
}