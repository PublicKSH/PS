#include <bits/stdc++.h>
using namespace std;

int n,k;

int main() {
    cin >> n >> k;
    
    int Cnt = n%k; //1을 뺀 횟수
    n -= Cnt;

    while(true) {
        n /= k;
        Cnt++;
        if (n < k) break;
    }

    cout << Cnt;
    return 0;
}
//고칠 부분 -> while문을 돌리기 보단 나오는 계산식을 사용