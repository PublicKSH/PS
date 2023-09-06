#include <bits/stdc++.h>

using namespace std;

int n, m;
vector<int> arr;

int main() {
	cin >> n >> m;
	for(int i=0; i!=n; i++) {
		int length;
		cin >> length;
		arr.push_back(length);
	}
	
	int result = 0;
	int start = 0;
	int end = 1e9;
	while (start <= end) {
		long long int total = 0; //자른 떡의 길이
		int mid = (start + end)/2;
		for (int i=0; i!=n; i++) {
			if (arr[i] > mid) total += arr[i]-mid;
		}
		if (total < m) {
			end = mid -1;
		}
		else {
			result = mid;
			start = mid + 1;
		}
	}
	cout << result;
	return 0;
}