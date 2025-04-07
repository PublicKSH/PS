#include <iostream>
using namespace std;
 
int main() 
{
	int First_num,ten,one,N;
	int C =0;
	cin >> First_num;
	// ten과 one을 처음부터 바뀐수로 적용
	ten = First_num%10;
	one = (First_num%10+First_num/10)%10;
	C++;
	while(1)
	{
		N = ten*10+one;
		if(N==First_num) break;
		
		ten = N%10;
		one = (N%10+N/10)%10;
		C++;
	}
	cout << C;
	return 0;
}