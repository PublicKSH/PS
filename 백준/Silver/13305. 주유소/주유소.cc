#include <iostream> 
#include <vector>
#include <algorithm> //max

using namespace std;

int main() {
	long N; //도시의 개수
	vector<long> length; //도로의 길이
	vector<long> oilPrices; //리터당 가격
	long sum = 0; //총 가격
	cin >> N; //도시 개수 입력
	for (int i=0; i!= N-1; i++) { //도로의 길이를 입력
		int Len;
		cin >> Len;
		length.push_back(Len);
	}
	for (int i=0; i!= N; i++) { //도시당 기름가격을 입력
		int oilPrice;
		cin >> oilPrice;
		oilPrices.push_back(oilPrice);
	}
	int nowPrice = oilPrices[0]; //현재 오일의 가격
	for (int i=0; i!= N-1; i++) { //도시당 기름가격을 입력(마지막도시의 가격은 확인할 필요X)
		if (nowPrice > oilPrices[i])
			nowPrice = oilPrices[i];
		sum += nowPrice*length[i];
	}
	
	cout << sum;
	
	return 0;
}