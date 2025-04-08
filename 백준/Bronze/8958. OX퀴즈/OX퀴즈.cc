#include <iostream>
using namespace std;
 // std:fill() 함수의 사용법  std:fill(a,b) a배열의 내용이 모두 b로 변한다 (2차원 복수차원에서도 사용가능)
int main() 
{
	int N,sum=0,count=0,len=80;
	char arr[80];
	cin >> N;
	for (int i=0; i<N; i++)
	{
		cin >> arr; //OX를 입력받음

		for (int i=0; i<80; i++)
		{
			if(arr[i] == 'O') count++,sum = sum+count;
			else
				count =0;
		}
		for (int i=0; i<80; i++)
		{
			arr[i] = 0;
		}
		cout << sum <<endl;
		sum =0;
	}
	return 0;
}