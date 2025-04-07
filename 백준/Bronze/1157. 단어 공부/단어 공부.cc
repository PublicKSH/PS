#include <iostream>
#include <cstring>
#include <string>
using namespace std;
#define MAX(a,b) (a>b) ? a : b 
//A = 65, a = 97
int Max(int a, int b)
{
	if( a > b) return a;
	else if( a < b) return b;
	else return -1;
}
int main()
{
	int arr[26] = {0,};
	int MAX = 0;
	int count = 0;
	char str[1000001];
	cin >> str;
	int len = strlen(str); 

	for (int i=0; i<len; i++) //for문 ()에 함수를 넣으면 시간이 길어진다.
	{
		if ((int)str[i] >= 97)
		{
			arr[(int)str[i]-97]++;
		}
		else
		{
			arr[(int)str[i]-65]++;
		}
	}
	for (int i=0; i<26; i++)
	{
		if(arr[i] > MAX) 
		{
			MAX = arr[i];
			count = i;
		}
		else if(arr[i] == MAX) count = -1;
	}
	if (count == -1) cout << "?";
	else
	{
		cout << (char)(count+65);
	}
	return 0;
}