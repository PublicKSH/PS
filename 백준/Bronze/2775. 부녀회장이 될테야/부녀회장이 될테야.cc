#include <iostream>
using namespace std;
//2775번
int f(int k,int n) {
	if (n==1) return 1;
	else if (k==0) return n;
	return f(k-1,n) + f(k,n-1);
}

int main() {
	int T;
	int k,n;
	cin >> T;
	while (T != 0) {
		cin >> k >> n;
		cout << f(k,n) <<endl;
		T--;
	}
}

