// 22.02.24
// D.P
// 1463
#include <bits/stdc++.h>
using namespace std;

int N;
int DP[1000001];


int main() {
    cin >> N;
    for (int i=2; i<=N; i++) {
        DP[i] = DP[i-1] + 1; 
        if (i % 3 == 0) {
            DP[i] = min(DP[i], DP[i/3]+1);
        }
        if (i % 2 == 0) {
            DP[i] = min(DP[i], DP[i/2]+1);
        }
    }

    cout << DP[N];
    return 0;
}