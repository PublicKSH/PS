//답 확인
//n=5일때 경우의 수를 잘못구해서 피보나치수열임을 인지하지 못하였다.
#include <bits/stdc++.h>

using namespace std;

long long d[1000001];

int main() {
	int n;
	cin >> n;
	d[0] = 0;
	d[1] = 1;
	d[2] = 2;
	for (int i=3; i<=n; i++) {
		d[i] = (d[i-1] + d[i-2])%15746;
	}
	
	cout << d[n];
	return 0;
}