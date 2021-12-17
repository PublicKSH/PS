#include <bits/stdc++.h>
using namespace std;

long long result = 0;
long long n;
int main() {
    cin >> n;
    if (n ==1) {
        cout << 1;
        return 0;
    }
    //O(n)으로는 불가능
    //같은 횟수가 나오는 값들을 묶어서 계산해야한다.
    //루트n까진 일일히 더해준다
    //여기서 범위계산 잘못해서 계속틀림 (8트)
    for (int i=1; i*i<=n; i++) {
        result += 1 + (n-1)/i;
    }
    //그 이후부턴 같은 값이 나오는 부분들을 묶어서 계산한다.
    int i = sqrt(n);
    long long d = 1 + (n-1)/i;
    result += d*((n-1)/(d-1)-i);
    for (int j=d-1; j!=1; j--) {
        result += j*((n-1)/(j-1)-(n-1)/(j));
    }
    cout << result+1;
    return 0;
}