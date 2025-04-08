#include <iostream>
using namespace std;

void hanoitower(int num, int start, int bypass, int end) {
	if(num == 0)
		return;
	hanoitower(num-1,start,end,bypass);
	printf("%d %d\n", start, end);
	hanoitower(num-1,bypass,start,end);
}

int main() {
	int N;
	cin >> N;
	cout << (1<<N)-1 << endl; //(1<<N) 은 2^N과 같은 의미
	hanoitower(N,1,2,3);
	return 0;
}