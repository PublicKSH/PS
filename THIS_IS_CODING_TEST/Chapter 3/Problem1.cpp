//큰수의 법칙
#include <bits/stdc++.h>
using namespace std;

int n,m,k;
vector<int> v;

int main() {
    cin >> n >> m >> k;
    for (int i=0; i<n; i++) {
        int num;
        cin >> num;
        v.push_back(num);
    }

    sort(v.begin(), v.end());
    int first = v[n-1]; //가장 큰 수
    int second = v[n-2]; //가장 작은 수
    int sum = 0;

    sum = first*(m-m/(k+1)) + second*(m/(k+1));

    cout << sum << '\n';
    return 0;
}
