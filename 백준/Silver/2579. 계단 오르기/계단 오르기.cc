// 22.02.24
// D.P
// 2579
#include <bits/stdc++.h>
using namespace std;

#define MAX(a,b) (((a) > (b) ? (a) : (b)))

int N;
int ARR[301];
int DP[301];


int main() {
    cin >> N;
    for (int i=0; i!=N; i++) {
        cin >> ARR[i];
    }

    DP[0] = ARR[0];
    DP[1] = ARR[0] + ARR[1];
    DP[2] = max((ARR[0] + ARR[2]), (ARR[1] + ARR[2]));
    
    for (int i=3; i<N; i++) {
        DP[i] = max((DP[i-2] + ARR[i]), (DP[i-3]+ARR[i-1] + ARR[i]));
    }

    cout << DP[N-1] << endl;
    return 0;
}
