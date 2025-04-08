#include <bits/stdc++.h>
using namespace std;

struct Member {
	int number;
	string name;
	Member(int _number, string _name) : number(_number), name(_name) {}
};

bool compare(const Member& m1, const Member& m2) {
	return m1.number < m2.number;
}

int main() {
	vector<Member> arr;
	int N;
	cin >> N;
	for (int i=0; i!=N; i++) {
		int number; string name;
		cin >> number >> name;
		arr.push_back(Member(number,name));
	}
	stable_sort(arr.begin(),arr.end(),compare);
	for (int i=0; i!=N; i++) {
		cout << arr[i].number << " " << arr[i].name << "\n";
	}
	return 0;
}