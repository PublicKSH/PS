#include <bits/stdc++.h>

using namespace std;

long long d[41];
long long zero[41];
long long one[41];
int x;
//d[x]에 0과 1이 사용된 횟수를  저장한다.

void fibo(int x) {
	zero[0] = 1;
	zero[1] = 0;
	one[0] = 0;
	one[1] = 1;
	
	for (int i=2; i!=x; i++) {
		one[i] = one[i-1] + one[i-2];
		zero[i] = zero[i-1] + zero[i-2];
	}

}

int main() {
	int T;
	cin >> T;
	fibo(41);
	while (T != 0) {
		int num;
		cin >> num;
		cout << zero[num] << " " << one[num] << endl;
		T--;
	}
	return 0;
}