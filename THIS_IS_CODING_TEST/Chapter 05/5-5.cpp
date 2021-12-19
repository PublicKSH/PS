#include <bits/stdc++.h>
using namespace std;
//반복적으로 구현한 n!
int factorial_iterative(int n) {
    int result = 1;

    for (int i=1; i<=n; i++) {
        result *= i;
    }
    return result;
}

//재귀적으로 구현한 n!
int factorial_recursize(int n) {
    if (n<=1)
        return 1;
    return n*factorial_recursize(n-1);
}

int main() {
    cout << "반복적으로 구현 " << factorial_iterative(5) << endl;
    cout << "재귀적으로 구현 " << factorial_recursize(5) << endl;
    
	return 0;
}

