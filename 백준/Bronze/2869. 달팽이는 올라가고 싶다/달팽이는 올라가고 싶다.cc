#include <iostream>
#include <cmath>
using namespace std;

int main() {
	double A, B, V;
	cin >> A >> B >> V;
    //ceil을 쓰기위해 double로 변수를 만들었지만 큰값에서 지수표현식을 쓰는바람에 int로 출력했다.
	int n = ceil((V-A)/(A-B)) +1;
	cout << n;
	return 0;
}
