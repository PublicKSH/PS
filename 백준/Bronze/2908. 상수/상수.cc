#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int main() {
	string a;
	string b;
	int num1, num2;
	cin >> a;
	cin >> b;
	
	reverse(a.begin(), a.end());
	reverse(b.begin(), b.end());

	
	num1 = stoi(a);
	num2 = stoi(b);
	
	if( num1 > num2) cout<< num1;
	else cout<< num2;
	

	
	
	return 0;
}