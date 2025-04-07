#include <iostream>
#include <vector>
#include <string>
#include <math.h>

using namespace std;

vector<string> base = {"***","* *","***"};
//NXN만큼의 공백이 있는 문자그림을 출력
vector<string> spaces(int n) {
	//n을 3의 n승으로 바꿔야한다.
	vector<string> space;
	const string String_spaces(pow(3,n),' ');
	for (int i=0; i!=pow(3,n); i++) {
		space.push_back(String_spaces);
	}
	return space;
}
//왼쪽과 오른쪽 문자그림을 합친다.
vector<string> vcat(const vector<string>& l, const vector<string>& r) {
	vector<string> temp;
	
	vector<string>::size_type vc_sz = l.size();
	
	for (vector<string>::size_type i=0; i!=vc_sz; i++) {
		string tempString = l[i];
		tempString += r[i];
		temp.push_back(tempString);
	}
	
	return temp;
}
//위와 아래 문자그림을 합친다.
vector<string> hcat(const vector<string>& u, const vector<string>& b) {
	vector<string> temp = u;
	
	vector<string>::size_type vc_sz = b.size();
	for (vector<string>::size_type i=0; i!=vc_sz; i++) {
		temp.push_back(b[i]);
	}
	
	return temp;
} 

vector<string> stars(int n) {
	if(n == 1)
		return ::base;
	vector<string> up = vcat(vcat(stars(n-1), stars(n-1)),stars(n-1));
	vector<string> mid = vcat(vcat(stars(n-1), spaces(n-1)),stars(n-1));
	
	return hcat(hcat(up,mid),up);
}

int main() {
	int N, log3=0;
	cin >> N;
	while (N != 1) {
		N = N/3;
		log3++;
	}
	vector<string> v = stars(log3);
	
	for (vector<string>::size_type i=0; i != v.size(); i++) {
		cout << v[i] << "\n";
	}
}