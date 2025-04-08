#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef pair<ll, ll> P;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	int n; cin >> n;
	ll ans = n;
	int mx = 0;
	for (int i = 1; i * i <= n; i++) {
		ans += (n - 1) / i;
		mx = (n - 1) / i;
	}
	for (int i = mx; i >= 1; i--) {
		ans += (ll)i * ((n - 1) / i - (n - 1) / (i + 1));
		if (i == mx) ans -= i;
	}
	cout << ans << '\n';
	return 0;
}