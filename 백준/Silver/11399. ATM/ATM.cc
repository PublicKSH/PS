#include <iostream>
#include <algorithm> //sort
using namespace std;

#define MAXLEN 1000
int Parr[MAXLEN];

int main() {
	int N;
	int sum = 0;
	cin >> N;
	for(int i=0; i != N; i++) {
		int time; cin >> time;
		Parr[i] = time;
	}
	
	sort(Parr,Parr+N);
	for(int i=0; i != N; i++) {
		sum += Parr[i]*(N-i);
	}
	cout << sum;
	return 0;
}