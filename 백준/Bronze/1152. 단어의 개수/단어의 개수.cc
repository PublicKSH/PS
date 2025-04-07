#include <iostream>
#include <string>
using namespace std;

int main()
{
	string str;
	int len;
	int Bcount = 0; 
	getline(cin,str);
	len = str.length();
	//예외처리 2개
	if(str.length() == 0)
	{
		cout << 0;
		return 0;
	}
	if(str.length() ==1 && str[0] ==' ')
	{
		cout << 0;
		return 0;
	}
	//str[0], str[len] 의 경우 확인하지 않는다.
	for (int i=1; i<len-1; i++)
	{
		if(str[i] == ' ')
		{
			Bcount++;
		}
	}
	
	
	cout << Bcount+1;
	
	return 0;
}

