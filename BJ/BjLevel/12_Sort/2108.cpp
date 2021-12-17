#include <bits/stdc++.h>
using namespace std;

int main() {
	int N;
	vector<int> arr;
	cin >> N;
	for (int i=0; i!=N; i++) {
		int num; cin >> num;
		arr.push_back(num);
	}
	sort(arr.begin(), arr.end());
	//산술평균 출력
	//cout << "산술평균\n";
	int sum = accumulate(arr.begin(),arr.end(),0);
	cout << round((double)sum/(double)N) << endl;
	//중앙값 출력
	//cout << "중앙값\n";
	typedef vector<int>::size_type vec_sz;
	vec_sz size = arr.size();
	vec_sz mid = size/2;
	if (size%2 == 0)
		cout << (arr[mid]+arr[mid-1])/2 << endl;
	else 
		cout <<arr[mid] << endl;
	//최빈값(Mode) 출력
	//cout << "최빈값\n";
	vector<int> cnt(8001);
	for (int i=0; i!=N; i++) {
		cnt[arr[i]+4000]++;
	}
	int max_count = 0;
	for (int i=0; i!=8001; i++) {
		max_count = max(max_count,cnt[i]);
	}
	vector<int> mode;
	for (int i=0; i!=8001; i++) {
		if(cnt[i] == max_count)
			mode.push_back(i-4000);
	}
	sort(mode.begin(),mode.end());
	if (mode.size() == 1)
		cout << mode[0] <<endl;
	else
		cout << mode[1] <<endl;
	//범위출력
	//cout << "범위\n";
	if (N == 1)
		cout << 0 << endl;
	else
		cout << arr[N-1]-arr[0] <<endl;
	return 0;
}