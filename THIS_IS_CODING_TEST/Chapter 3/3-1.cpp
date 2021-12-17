#include <bits/stdc++.h>
using namespace std;

int n = 1260;
int cnt = 0;
int coinType[4] = {500, 100, 50, 10};

int main() {
    for (int i=0; i<4; i++) {
        cnt += n/coinType[i];
        n %= coinType[i];
    }

    cout << cnt;
    return 0;
}