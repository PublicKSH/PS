#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <iterator>
using namespace std;

//aabbcc 를 abc로 만든다 이후 나온 문자의 개수와 abc의 길이가 같은지 확인한다.
//aabbccaa의 경우 나온 문자의 개수는 3이고 줄인 문자는 abca이므로 이는 그룹단어가 아니다.

bool GroupWord(const string&);
	
int main() {
	int N; string s;
	int count = 0;
	cin >> N;
	for (int i=0; i != N; i++) {
		cin >> s;
		if(GroupWord(s))
			count++;
	}
	cout << count;
	return 0;
}

bool GroupWord(const string& s) {
	vector<int> alpa(26);
	string::const_iterator i = s.begin();
	while(i < s.end()) {
		if (alpa[*i-'a']++ == 0) {
			char c = *i;
			while (*i == c && i != s.end()) i++;
		}
		else if (alpa[*i-'a'] != 0) {
			return false;
		}
		else
			i++;
	}
	
	return true;
}