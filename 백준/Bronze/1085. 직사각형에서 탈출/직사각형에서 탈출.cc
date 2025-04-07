#include <iostream>
#include <algorithm>
using std::min;
using std::cin;
using std::cout;
using std::endl;

int main() {
	int x,y,w,h;
	int minNum = 1000;
	cin >> x >> y >> w >> h;
	// 나오는 숫자 4개 위로(w-x) 아래로(x) 왼쪽(y) 오른쪽(h-y)
	minNum = min(min(w-x,x),min(y,h-y));
	cout << minNum;
	return 0;
}
