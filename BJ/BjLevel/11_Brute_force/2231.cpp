#include <bits/stdc++.h>
using namespace std;

int Constructor(int n) {
	int C_Num = n;
	while (n != 0) {
		C_Num += n%10;
		n = n/10;
	}
	return C_Num;
}

int main() {
	int N;
	cin >> N;
	for (int i=0; i!=N; i++) {
		if (Constructor(i) == N) {
			cout << i << endl;
			return 0;
		}
	}
	cout << 0;
	return 0;
}