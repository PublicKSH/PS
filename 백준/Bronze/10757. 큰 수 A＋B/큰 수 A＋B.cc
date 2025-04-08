#include <iostream>
#include <string>
#include <algorithm> //max, reverse
using std::cin;
using std::cout;
using std::max;
using std::string;
using std::reverse;
using std::endl;
using std::to_string;
using std::atoi;
//2775번

int main() {
	string N1,N2;
	string Sum = ""; //빈 문자열
	int one1, one2; // 일의자리 두게
	int sum = 0;
	int carry = 0; //올림수
	cin >> N1>> N2;
	//낮은 자리수부터 계산을 하기 위해 문자열을 reverse한다.
	reverse(N1.begin(),N1.end());
	reverse(N2.begin(),N2.end());
	
	while (N1.size() < N2.size()) {
		N1 += '0';
	}
	while (N1.size() > N2.size()) {
		N2 += '0';
	}
	//일의 자리씩 차근차근 계산해서 Sum에 push_back()한다
	//근대 만약 두 숫자의 자리가 다른 프로그램이면 어떻게 할까 ->일단은 자리가 같다는 가정하게 프로그래밍 작성 -> 이후 자리가 다르면 자리가 낮은 문자열에 '0'을 집어넣는다. 
	string::size_type maxlen = max(N1.size(),N2.size());
	for (string::size_type i = 0; i != maxlen; i++) {
		sum =  N1[i]-48 + N2[i]-48 + carry;
		if (sum >= 10) {
			carry = sum/10;
			sum = sum%10;
			Sum += to_string(sum);
		}
		else{
			carry = 0;
			Sum += to_string(sum);
		}
	}
	if (carry > 0)
		Sum += to_string(carry);
	reverse(Sum.begin(),Sum.end());
	cout << Sum <<endl;
	return 0;
}