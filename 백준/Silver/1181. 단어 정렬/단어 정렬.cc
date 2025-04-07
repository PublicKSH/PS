#include <bits/stdc++.h>
using namespace std;

bool compare(const string& s1, const string& s2) {
	if (s1.size() == s2.size())
		return s1 < s2;
	return s1.size() < s2.size();
}

int main() {
	vector<string> arr;
	int N;
	cin >> N;
	for (int i=0; i!=N; i++) {
		string str;
		cin >> str;
		if (find(arr.begin(),arr.end(),str) == arr.end())
			arr.push_back(str);
	}
	sort(arr.begin(),arr.end(),compare);
	for (vector<string>::const_iterator it = arr.begin(); it != arr.end(); it++) {
		cout << *it << "\n";
	}
	return 0;
}