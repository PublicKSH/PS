#include <iostream>

#define MAXLEN 10000
using std::cin;
using std::cout;
using std::endl;
int decimal[MAXLEN];
//num을 입력받으면 해당 숫자까지 decimal배열을 초기화 한다.
void decimal_init(int num) {
	//입력받은 수 만큼 배열의 요소를초기화
	for (int i = 2; i <= num; i++) {
		decimal[i] = i;
	}

	// 소수를 확인할때 모든 수를 나눌 필요는 없이 루트 n까지만 나누어서 떨어지면 소수가 아니다.
	for (int i = 2; i*i <= num; i++) {
		if (decimal[i] == 0)
			continue;
		for (int j = i+i; j <= num; j += i)
			decimal[j] = 0;
	}
	
}

int main() {
	int T, N;
	int count = 0;
	decimal_init(1000);
	cin >> T;
	while(T != 0) {
		cin >> N;
		if (decimal[N] != 0)
			count++; 
		T--;
	}
	cout << count;
	return 0;
}
