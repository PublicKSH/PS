#include <bits/stdc++.h>

using namespace std;

int n, m;
vector<int> arr;

int main() {
	cin >> n >> m;
	for (int i=0; i!=n; i++) {
		long long int num;
		scanf("%d", &num);
		arr.push_back(num);
	}
	sort(arr.begin(), arr.end());
	
	long long int result = 0;
	long long int start = 1;
	long long int end = arr[n-1];
	while (start <= end) {
		long long int total = 0;
		long long int mid = (start + end)/2;
		for (int i=0; i!=n; i++) {
			total += arr[i]/mid;
		}
		if (total < m) { //만든 랜선의 개수가 필요한거 보다 많으면 자르는 길이를 줄인다.
			end = mid -1;
		}
		else { //만든 랜선의 개수가 필요한거보다 작거나 같으면 자르는 길이를 늘린다.]
			if(result < mid) result = mid;
			start = mid + 1;
		}
	}
	cout << result;
	return 0;
}