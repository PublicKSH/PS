#include <bits/stdc++.h>

using namespace std;

long long d[100];
int n;
int k[101];
//d[x]에 0과 1이 사용된 횟수를  저장한다.

int main() {
	cin >> n;
	for (int i=0; i!=n; i++) {
		int num;
		cin >> num; 
		k[i] = num;
	}
	
	d[0] = k[0];
	d[1] = max(k[0],k[1]);
	for (int i=2; i!=n; i++) {
		d[i] = max(d[i-1],d[i-2] + k[i]);
	}
	
	cout << d[n-1];
	return 0;
}