//답 확인
//n=5일때 경우의 수를 잘못구해서 피보나치수열임을 인지하지 못하였다.
#include <bits/stdc++.h>

using namespace std;

long long d[101] = {0,1,1,1,2,2,3,4,5,7,9};

int t;
int main() {
	cin >> t;
	for (int i=11; i!=101; i++) {
		d[i] = d[i-1] + d[i-5];
	}
	while (t != 0) {
		int num;
		cin >> num;
		cout << d[num] << endl;
		t--;
	}
	return 0;
}