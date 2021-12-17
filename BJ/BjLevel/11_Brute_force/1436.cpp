#include <bits/stdc++.h>
using namespace std;

/*
666
1666
2666
3666
4666
5666
6660 ~ 6669;
와 같이 어느순간 규칙이 일정하지 않게 된다.
따라서 정수 666부터 N번째 숫자를 찾을 때까지 전부 돌린다.
*/
//해당 숫자가 6이 3개 연속해서 나오면 ture 아니면 false
bool Devil_num(int n) {
	string numStr = to_string(n);
	if (numStr.find("666") != string::npos)
		return true;
	else
		return false;
}

int main() {
	int N;
	cin >> N;
	int count = 0;
	int i = 666;
	while(true) {
		if (Devil_num(i))
			count++;
		if (count == N) {
			cout << i;
			break;
		}
		i++;
	}
}