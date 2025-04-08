#include <iostream>
using namespace std;
 
int main() 
{
	int num,Remainder,count=0;
	int arr[42] = {0,}; //0~9까지
	for (int i=0; i<10; i++)
	{
		cin >> num;
		Remainder = num%42;
		arr[Remainder]++;
	}
	
	for (int i=0; i<42; i++)
	{
		if (arr[i] !=0) count++;
	}
	cout << count;
	return 0;
}