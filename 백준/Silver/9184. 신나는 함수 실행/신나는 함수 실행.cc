#include <bits/stdc++.h>

using namespace std;

long long d[51][51][51];

int w(int a, int b, int c) {
	if (a <= 0 || b <= 0 || c <= 0)
		return 1;
	if (d[a][b][c] != 0) {
		return d[a][b][c];
	}
	if (a > 20 || b > 20 || c > 20) {
		return w(20, 20, 20);
	}
	if (a < b && b < c) {
		d[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1 , c);
		return d[a][b][c];
	}
	else {
		d[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
		return d[a][b][c];
	}
}
int main() {
	int a,b,c;
	while(1) {
		cin >> a >> b >> c;
		//탈출 조건
		if (a == -1 && b == -1 && c == -1) break;
		printf("w(%d, %d, %d) = %d\n",a,b,c,w(a,b,c));
	}
	
	return 0;
}