#include <iostream>
#include <cstring>
#include <string>
using namespace std;

int main()
{
	int T,R;
	char s[21];
	cin >> T;
	for (int i=0; i<T; i++)
	{
		cin >> R >> s;
		for(int j=0; j<strlen(s); j++)
		{
			for(int z=0; z<R; z++)
			{
				cout << s[j];
			}
		}
		cout << endl;
	}
	
	return 0;
}