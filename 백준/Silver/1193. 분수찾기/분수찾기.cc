#include <iostream>
using namespace std;

int main() {
	long long int N, n=1, up=1;
	cin >> N;
	if (N == 1) {
		cout << 1 << "/" << 1;
		return 0;
	}
	while ( (n*(n+1))/2 < N ) {
		up = (n+1)*(n+2)/2 - N;
		n++;
	}
	up++;
	//n이 홀 수 일때
	if (n%2 != 0) {
		cout << up << "/" << (n+1)-up; 
	}
	else{
		cout << (n+1)-up << "/" << up; 
	}
	return 0;
}
