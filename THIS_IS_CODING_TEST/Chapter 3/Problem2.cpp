//숫자 카드 게임
#include <bits/stdc++.h>
using namespace std;

int n, m; //행, 렬
int Min = 0;
int main() {
    cin >> n >> m;
    for (int i=0; i<n; i++) {
        int lineMin = 10001; //행에서 가장 작은 숫자
        for (int j=0; j<m; j++) {
            int num;
            cin >> num;
            if (lineMin > num)
                lineMin = num;
            }
        if (Min < lineMin)
            Min = lineMin;
    }

    cout << Min << '\n';
    return 0;
}\