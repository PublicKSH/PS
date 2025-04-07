#include <iostream>
using std::cin;
using std::cout;
using std::endl;
//1011번
//거리가 주어지면 최소한 공간이동장치 작동횟수를 반환
int f(int N) {
	int count = 0, k = 1; //각각 이동횟수랑 거리
	while(N >= 0) {
		N = N-k; count++;
		if (N == 0) return count;
		else if (N <= k) {
			return ++count;
		}
		N = N-k; count++;
		if (N == 0) return count;
		else if (N <= k) {
			return ++count;
		}
		k++;
	}
	
	return count;
}

int main() {
	int T,A,B,N;
	cin >> T;
	while(T != 0) {
		cin >> A >>B;
		N = B-A;
		cout << f(N) <<endl;
		T--;
	}
	return 0;
}
