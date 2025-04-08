// 22.02.25
// 13:30 시작 
// D.P
// 
#include <bits/stdc++.h>
using namespace std;


int n;
int result = 0;
int arr[1001];
int dp[1001];

int main() {
    cin >> n;
    for (int i=0; i!=n; i++) {
        cin >> arr[i];
    }
    
    fill(dp, dp+1000, 1);

    for (int i=0; i!=n; i++) {
        // 걔속해서  for 문을 돌린다.
        for (int j=0; j!=i; j++) {
            if (arr[j] < arr[i]) {
                dp[i] = max(dp[i], dp[j]+1);
            }
        }
        result = max(result, dp[i]);
    }


    cout << result;
    return 0;
}
