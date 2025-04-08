#include <iostream>
using namespace std;

int d(int n)
{
	int num=n;
	int sum=0;
	while(num > 0)
	{
		sum += num%10;
		num = num/10;
	}
	return sum+n;
}

int main()
{

	int arr[10000];
	for (int i=0; i<10000; i++)
	{
		if(d(i+1)<=10000)
			arr[d(i+1)] = -1;
	}
	
	for (int i=1; i<10000; i++)
	{
		if(arr[i] != -1) cout << i << endl;
	}

	return 0;
}