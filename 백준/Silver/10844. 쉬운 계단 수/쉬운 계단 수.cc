// 22.02.24 
// 23:04 시작 쉬었다가 25일 이어서 풀었다
// D.P
// 10844
#include <bits/stdc++.h>
using namespace std;


int N;
long long DP[101][10]; //[자릿수][끝나는 숫자]
long long SUM = 0;


int main() {
    cin >> N;
    for (int i=0; i!=9; i++) {
        DP[0][i] = 1;
    }

    for (int i=1; i!=N; i++) {
        // (0,9)이 인접하는 경우는 따로 분류를 해준다
        for (int j=0; j!=10; j++) {
            if (j == 0) {
                DP[i][j] = DP[i-1][j+1];
            }
            else if (j == 9) {
                DP[i][j] = DP[i-1][j-1];
            }
            else
                DP[i][j] = DP[i-1][j+1] + DP[i-1][j-1];

            DP[i][j] %= 1000000000;
        }
        
    }

    for (int i=0; i!=10; i++) {
        SUM = (SUM + DP[N-1][i]) % 1000000000;
    }
    cout << SUM << endl;
    return 0;
}
