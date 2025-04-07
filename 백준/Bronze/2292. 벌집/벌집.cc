#include <iostream>
using namespace std;

int main() {
	long long int N, n=1;
	cin >> N;
	while ( (3*n*(n-1)+1) < N ) {
		n++;
	}
	cout << n;
	return 0;
}


