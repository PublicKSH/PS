#include <iostream>
using namespace std;

int main()
{
	int a,b,c,d,e,f;
	cin >> a >> b;
	c = a * (b%10);
	d = a * ((b%100-b%10)/10);
	e = a * (b/100);
	f = a*b;
	cout << c <<endl<< d <<endl<< e <<endl<<f<<endl;
	
}