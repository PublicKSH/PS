#include <iostream>
using std::cin;
using std::cout;
using std::endl;

//3개의 좌표를 입력받고 각각 x,y좌표에서 2번 안나온 숫자가 있다 그 숫자가 x
int main() {
	int x,y;
	int arrx[3],arry[3];
	for (int i=0; i!=3; i++) {
		cin >> x >> y;
		arrx[i] = x;
		arry[i] = y;
	}
	if (arrx[0] == arrx[1])
		cout << arrx[2];
	else if(arrx[0] == arrx[2])
		cout << arrx[1];
	else
		cout << arrx[0];
	cout << " ";
	if (arry[0] == arry[1])
		cout << arry[2];
	else if(arry[0] == arry[2])
		cout << arry[1];
	else
		cout << arry[0];
	return 0;
	
}