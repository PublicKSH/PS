//22.02.12
//Greedy

#include <bits/stdc++.h>
using namespace std;

string s;
int result = 0;

int main(void) {
    cin >> s;
    // 0이면 뒤의숫자랑 더하고 아니면 곱하기
    for (int i=0; i!=s.length(); i++) {
        if (s[i] == '0') {
             // 그냥 패스 (결과 값에 0을 더해도 의미가 없다)
            continue;
        }
        if (result == 0 && s[i] != 0 ) {
            // result가 0 이면 아무리 곱해도 0 이 나온다
            result = int(s[i]-'0');
        }
        else {
            result *= int(s[i]-'0');
        }
    }


    cout << result;

    return 0;
}