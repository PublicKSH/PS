#include <bits/stdc++.h>

using namespace std;

long long d[1001];
int n;
//d[x]에 0과 1이 사용된 횟수를  저장한다.

int main() {
	cin >> n;
	
	d[1] = 1;
	d[2] = 3;
	for (int i=3; i<=n; i++) {
		d[i] = d[i-1] + d[i-2]*2;
	}
	
	cout << d[n];
	return 0;
}