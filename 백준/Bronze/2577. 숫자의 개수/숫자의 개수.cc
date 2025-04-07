#include <iostream>
using namespace std;
 
int main() 
{
	int a,b,c,mult,num;
	int arr[10] = {0,}; //0~9까지
	cin >> a >> b >> c;
	mult = a*b*c;
	while (mult !=0)
	{
		num = mult%10;
		for (int i=0; i<10; i++)
		{
			if(num == i) arr[i]++;
		}
		
		mult = mult/10;
	}
	
	for (int i=0; i<10; i++) {
		cout << arr[i] <<endl;
	}
	return 0;
}