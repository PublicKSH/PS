#include <iostream> 
#include <string>
#include <vector>
#include <cctype>
using namespace std;
//숫자를 저장하고
//그냥 모든 +를 -로 바꾸면 되지 않겟는가?
//-가 한번도 나오지 않는 경우를 생각해야함
int main() {
	string Exp;
	vector<int> Exp_num;
	int count = 0, sum = 0;
	getline(cin,Exp);
	string::const_iterator it = Exp.begin();
	while (it != Exp.end()) {
		string number;
		while (it != Exp.end() && isdigit(*it)) {
			number.push_back(*it++);
		}
		if (count == 0) {
			Exp_num.push_back(stoi(number));
		}
		else {
			Exp_num.push_back(-stoi(number));
		}
		if(*it == '-') { //처음은 그냥 push_back해야한다.
			count++; //count를 bool로하는게 좋았을까..
		}
		if(it != Exp.end())
			it++;
		//-가 한번이라도 나오면 그이후에 모든 숫자에 -를 붙인다.	
	}
	
	for (int i=0; i != Exp_num.size(); i++)
		sum += Exp_num[i];
	
	cout << sum;
	
	return 0;
}