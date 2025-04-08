#include <iostream>
using std::cin;
using std::cout;
using std::endl;

int main() {
	int N, K=2; //K로 나눈다.
	cin >> N;
	while (N != 1) {
		if (N%K == 0) {
			N = N/K;
			cout << K << endl;
		}
		else if (N%K != 0)
			K++;
	}
	return 0;
}
