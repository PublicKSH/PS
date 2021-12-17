#include <bits/stdc++.h>
using namespace std;

long long d[100];

long long fibo(int x) {
	printf("fibo(%d) ", &x);
	if (x == 1 || x == 2) return 1;
	
	if (d[x] != 0) return d[x];
	
	d[x] = fibo(x - 1) + fibo(x - 2);
	return d[x];
}

int main() {
	cout << fibo(6) << endl;
	return 0;
}