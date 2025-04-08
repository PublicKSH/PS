#include <iostream>
#include <cstring>
using namespace std;

// a = 97(아스키코드)
int main()
{
	int arr[26];
	std::fill_n(arr, 26, -1);
	char s[101];
	cin >> s;
	for(int i=0; i<strlen(s); i++)
	{
		if(arr[(s[i]-97)] == -1)
			arr[(s[i]-97)]=i;
	}
	
	for(int i=0; i<26; i++)
	{
		cout << arr[i] << " ";
	}
	return 0;
}