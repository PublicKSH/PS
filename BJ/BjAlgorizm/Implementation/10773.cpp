//실버4 제로
//문제를 보자마자 스텍을 사용해야 겟다고 생각
#include <bits/stdc++.h>
using namespace std;

int k;
int sum = 0;
stack<int> numbers;
int main() {
    cin >> k;
    for (int i=0; i<k; i++) {
        int x;
        cin >> x;
        if (x == 0)
            numbers.pop();
        else
            numbers.push(x);
    }
    //배운점: 스택의 총합을 확인할땐 while문을 쓰자
    while(!numbers.empty()) {
        sum += numbers.top();
        numbers.pop();
    }
    cout << sum;
}