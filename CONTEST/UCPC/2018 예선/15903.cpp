//ll을 쓰는 습관 들이기
#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

int m, n;
ll result = 0;
priority_queue<ll,vector<ll>,greater<ll> > pq;
 
int main() {
    cin >> n >> m;
    for (int i=0; i!=n; i++) {
        int x;
        cin >> x;
        pq.push(x);
    }

    for (int i=0; i!=m; i++) {
        ll x = pq.top();
        pq.pop();
        ll y = pq.top();
        pq.pop();
        pq.push(x+y);
        pq.push(x+y);
    }

    while(!pq.empty()) {
        result += pq.top();
        pq.pop();
    }
    cout << result;
    return 0;
}