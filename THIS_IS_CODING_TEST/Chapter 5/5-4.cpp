#include <bits/stdc++.h>
using namespace std;

void recursize_function(int i) {
    if (i == 100)
        return;
    cout << i << "번째 함수에서" << i+1 << "번째 함수 호출.\n";
    recursize_function(i+1);
    cout << i << "번째 함수 종료.\n";
}

int main() {
    recursize_function(1);
	return 0;
}
