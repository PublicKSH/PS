//22.02.12
//Greedy
// 백준 1439
// 주어진 문자열의 0 과 1 의 파트를 나눠서 더 적은쪽을 출력
#include <bits/stdc++.h>
using namespace std;

// 일일히 새는 방식 vs 알고리즘 라이브러리로 짜르면서 ...

string s;
// 0 과 1 의 파트의 갯수
int zeroPart = 0;
int onePart = 0;

int main(void) {
    cin >> s;
    if (s[0] == '1') {
        onePart += 1;
    }
    else {
        zeroPart += 1;
    }

    for (int i=0; i!=(s.length()-1); i++) {
        if (s[i] != s[i + 1]) {
            if (s[i + 1] == '1') {
                onePart += 1;
            }
            else {
                zeroPart += 1;
            }
            
        }
    }

    cout << min(onePart, zeroPart);
    return 0;
}