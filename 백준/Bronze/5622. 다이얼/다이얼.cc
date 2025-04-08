#include <iostream>
#include <string>
using namespace std;

int main() {
	string Pword; int TotalTime=0;
	//알파벳 사용 체크 배열
	int alpa[26] = {0,};
	cin >> Pword;
	// 나누기 3을 이용한다. 
	for (char c: Pword)
	{
		alpa[c- 'A']++;
	}
	//ABC(0) DEF(1) GHI(2) JKL(3) MNO(4) PQR(5) (S TU)(6) (V WX)(7) YZ(8)
	//S는 5 V는6 YZ는 7이 나와야한다
	for(int i=0; i<26; i++)
	{
		if(i=='S'-'A' || i == 'V'-'A' || i=='Y'-'A' || i == 'Z'-'A' )
		{
			TotalTime += (i/3 +2)*alpa[i];
		}
		else
		{
			TotalTime += (i/3 +3)*alpa[i];
		}
	}
	
	cout << TotalTime;
	
	
	return 0;
}