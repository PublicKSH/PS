// 22.02.25
// 10시 시작 11시 마무리 (중간에 편의점 + 유튜브)
// D.P
// 2156
// 틀렷다 점화식에서 DP[i-1]만 있는 경우를 생각하지 못했다
// 자꾸 틀리게 나온다 -> 원인 DP[2]의 초기화에도 DP[2]를 안먹는 경우를 생각했어야했다
#include <bits/stdc++.h>
using namespace std;


int N;
int arr[10001];
int DP[10001];
int main() {
    cin >> N;
    for (int i=0; i!=N; i++) {
        cin >> arr[i];
    }
    DP[0] = arr[0];
    DP[1] = arr[0]+arr[1];
    for (int i=2; i<=N; i++) { // 왜 i!=N 이 아니라 i<= N일까
        DP[i] = max(DP[i-1] ,max((DP[i-2]  + arr[i]), (DP[i-3]+ arr[i-1] + arr[i])));
    }


    cout << DP[N-1] << endl;
}
