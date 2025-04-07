#include <bits/stdc++.h>
using namespace std;

int main() {
	string num;
	cin >> num;
	vector<int> arr;
	for (string::size_type i=0; i!=num.size(); i++) {
		arr.push_back(num[i]-'0');
	}
	sort(arr.begin(),arr.end());
	for (string::size_type i=num.size()-1; i!=-1; i--) {
		cout << arr[i];
	}
	return 0;
}