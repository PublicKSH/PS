//위에서 아래로
#include <bits/stdc++.h>
using namespace std;

bool compare(int a, int b) {
	return a > b;
}

int main(void) {
    int N;
	cin >> N;
	vector<int> arr;
	for (int i=0; i!=N; i++) {
		int num; cin >> num;
		arr.push_back(num);
	}
	sort(arr.begin(),arr.end(),compare);
    for (int i = 0; i < N; i++) { // 배열에 기록된 정렬 정보 확인
        cout << arr[i] << ' ';
    }
	return 0;
}