//답 확인
//start, end를 배열의 요소로 지정했더니 아닌 값이 나왔다.
//이후 길이로 다시 지정했더니 맞는 값이 나왔다.
#include <bits/stdc++.h>

using namespace std;

int n, m;
vector<int> arr;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> n >> m;
	for (int i=0; i!=n; i++) {
		int pos;
		cin >> pos;
		arr.push_back(pos);
	}
	sort(arr.begin(), arr.end());
	
	int result = -1;
	int start = 1;
	int end = arr.back()-arr.front();
	
	while (start <= end) {
		int mid = (start + end)/2;
		int before_index = 0;
		int set_num = 1; //시작지점에 기본적으로 하나 설치
		for (int i=1; i!=n; i++) {
			if (arr[i] - arr[before_index] >= mid) {
				before_index = i;
				set_num++;
			}
		}
		
		if (set_num >= m) { //설치한 공유기가 가지고있는 공유기 보다 많으면  mid를 늘려 설치할 공유기 수를 줄인다.
			start = mid + 1;
		}
		else { //설치한 공유기가 가지고있는 공유기 보다 적으면 mid를 줄여 설치할 공유기 수를 늘린다.
			end = mid - 1;
		}
		
		if (result < mid && set_num >= m)
			result = mid;
	}
	cout << result;
	
	return 0;
}