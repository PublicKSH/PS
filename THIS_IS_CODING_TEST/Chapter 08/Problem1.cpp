#include <bits/stdc++.h>

using namespace std;

//Ai = min(Ai-1, Ai/2, Ai/3, Ai/5) + 1
long long d[30001];
int x;

int main() {
	cin >> x;
	//보텀업 진행
	for (int i=2; i<=x; i++) {
		d[i] = d[i-1]+1;
		if (d[i]%2 == 0)
			d[i] = min(d[i],d[i/2]+1);
		else if (d[i]%3 == 0)
			d[i] = min(d[i],d[i/3]+1);
		else if (d[i]%5 == 0)
			d[i] = min(d[i],d[i/5]+1);
	}
	cout << d[x] << endl;
	return 0;
}