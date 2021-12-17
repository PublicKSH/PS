#include <bits/stdc++.h>
using namespace std;

int main() {
	int n;
	vector<int> arr;
	cin >> n;
	for (int i=0; i!=n; i++) {
		int num; cin >> num;
		arr.push_back(num);
	}
	sort(arr.begin(),arr.end());
	for (int i=0; i!=n; i++) {
		cout << arr[i] << "\n";
	}
	return 0;
}