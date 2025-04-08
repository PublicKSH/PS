// 22.02.27
// 19시 시작
// D.P
// 11054
#include <bits/stdc++.h>
using namespace std;


int N;
int result = 0;
int arr[1001];
int DP[1001];
int RDP[1001];
int main() {
    cin >> N;
    for (int i=0; i!=N; i++) {
        cin >> arr[i];
        
    }
    
    fill(DP, DP+1000, 1);
    fill(RDP, RDP+1000, 1);
    for (int i=0; i!=N; i++) {
        // 걔속해서  for 문을 돌린다.
        for (int j=0; j!=i; j++) {
            if (arr[j] < arr[i]) {
                DP[i] = max(DP[i], DP[j]+1);
            }
        }
    }

    for (int i=N-1; i>=0; i--) {
        // 걔속해서  for 문을 돌린다.
        for (int j=N-1; j>=i; j--) {
            if (arr[i] > arr[j]) {
                RDP[i] = max(RDP[i], RDP[j]+1);
            }
        }
    }

    for (int i=0; i!=N; i++) {
        result = max(result, DP[i] + RDP[i]-1);
    }

    cout << result << endl;
}
