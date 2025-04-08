#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

int main() {
	string s;
	int idx = 0;
	cin >> s;
	vector<string> croati{"c=","c-","dz=","d-","lj","nj","s=","z="};
	for (vector<string>::size_type i = 0; i != croati.size(); i++ ) {
		idx = s.find(croati[i]);
		for (; idx != string::npos; idx = s.find(croati[i])) {
			s.replace(idx,croati[i].size(),"#");
		}
	}
	cout << s.size();
	
	return 0;
}