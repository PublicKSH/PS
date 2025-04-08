#include <bits/stdc++.h>

using namespace std;

int lower_binary(vector<int>& arr, int target, int start,int end) {
	while (end > start) {
		int mid = (start + end)/2;
		if (arr[mid] >= target)
			end = mid;
		else start = mid + 1;
	}
	return end;
}

int upper_binary(vector<int>& arr, int target, int start,int end) {
	while (end > start) {
		int mid = (start + end)/2;
		if (arr[mid] > target)
			end = mid;
		else start = mid + 1;
	}
	return end;
}

int n, m;
vector<int> arr;

int main() {
	cin >> n;
	for (int i=0; i!=n; i++) {
		int num;
		scanf("%d", &num);
		arr.push_back(num);
	}
	sort(arr.begin(), arr.end());
	cin >> m;
	for (int i=0; i!=m; i++) {
		int find_num;
		scanf("%d", &find_num);
		int result = upper_binary(arr,find_num,0,n) - lower_binary(arr,find_num,0,n);
		printf("%d ",result);
	}
	return 0;
}