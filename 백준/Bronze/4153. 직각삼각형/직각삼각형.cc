#include <iostream>
#include <algorithm>
#include <vector>
using std::cin;
using std::cout;
using std::endl;
using std::vector;
using std::sort;
int main() {
	int a,b,c;
	int maxNum;
	while (cin >> a >> b >> c) {
		if (a ==0 && b ==0 && c==0)
			break;
		vector vc{a,b,c};
		sort(vc.begin(),vc.end());
		if (vc[0]*vc[0] + vc[1]*vc[1] == vc[2]*vc[2])
			cout << "right\n";
		else
			cout << "wrong\n";
	}
	return 0;
}