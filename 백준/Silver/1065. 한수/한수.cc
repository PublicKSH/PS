#include <iostream>
using namespace std;

bool hansu(int n)
{
	int o,t,h;
	if(n>=1 && n<=99)
		return true;
	else if(999>=n && n>= 100)
	{	
		o = n%10;
		n = n/10;
		t = n%10;
		n = n/10;
		h = n%10;
		if((t-o) == (h-t)) return true;
	}
	return false;
	
}

int main()
{

	int N;
	int count=0;
	cin >> N;
	for(int i=1; i<N+1; i++)
	{
		if(hansu(i)) count++;
	}
	cout << count;
	return 0;
}