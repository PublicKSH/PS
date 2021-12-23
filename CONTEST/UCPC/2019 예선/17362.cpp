//수학은 체육과목 입니다.
#include <bits/stdc++.h> 
using namespace std;
int n;

int main() {
    cin >> n;
    if(n%8 >= 1 && n%8 <= 5){
		cout << n%8;
	} else if(n%8 == 6){
		cout << "4\n";
	} else if(n%8 == 7){
		cout << "3\n";
	} else if(n%8 == 0){
		cout << "2\n";
	} 
		
	return 0;
}