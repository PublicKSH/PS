#include <bits/stdc++.h>

using namespace std;

void binarysearch(vector<int>& arr, int target, int start, int end) {
	while (start <= end) {
		int mid = (start+end)/2;
		if (arr[mid] == target) {
			printf("1\n");
			return;
		}
		else if (arr[mid] < target) start = mid + 1;
		else end = mid - 1;
	}
	printf("0\n");
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
		binarysearch(arr,find_num,0,n);
	}
	return 0;
}