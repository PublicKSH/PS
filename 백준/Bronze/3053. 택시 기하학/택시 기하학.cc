#include <iostream>
#include <ios>
#include <iomanip>
using std::cin;
using std::cout;
using std::endl;
using std::setprecision;
using std::fixed;
using std::streamsize;
const double pi = 3.1415926535897932;
int main() {
	double R;
	cin >> R;
	streamsize prec = cout.precision();
	cout << fixed <<setprecision(6)
		<< R*R*pi << "\n" << R*R*2 << setprecision(prec);
	return 0;
}