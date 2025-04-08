#include <iostream>
using namespace std;

int main()
{
	int num;
	cin >> num;
	if (90 <= num)
		cout << "A";
	else if (80 <= num && num<= 89)
		cout << "B";
	else if (70 <= num && num<= 79)
		cout << "C";
	else if (60 <= num && num<= 69)
		cout << "D";
	else
		cout << "F";
	return 0;
}
