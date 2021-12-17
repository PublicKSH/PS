#include <bits/stdc++.h>

using namespace std;

int n, m;
vector<int> arr;

int main() {
	cin >> n >> m;
	for (int i=0; i!=n; i++) {
		int tree_length;
		cin >> tree_length;
		arr.push_back(tree_length);
	}
	sort(arr.begin(), arr.end());
	long long int result = 0;
	long long int start = 0;
	long long int end = arr[n-1];
	
	while(start <= end) {
		int mid = (start + end)/2;
		long long int  total = 0; //가져갈 나무의 길이
		for (int i=0; i!=n; i++) {
			total += arr[i]-mid;
		}

		if (total > m) {
			result = mid;
			start = mid + 1;
		}
		else {
			end = mid - 1;
		}
	}
	cout << result;
	return 0;
}