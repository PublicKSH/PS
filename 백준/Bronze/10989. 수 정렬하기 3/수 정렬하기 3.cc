//계수 정렬을 사용한다.
#include <bits/stdc++.h>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

	int n;
	int num;
	vector<int> cnt(10001);
	cin >> n;
	for (int i=0; i!=n; i++) {
		cin >> num;
		cnt[num]++;
	}
	for (int i=1; i!=10001; i++) {
		for (int j=0; j!=cnt[i]; j++) {
			cout << i << "\n";
		}
	}
	return 0;
}
