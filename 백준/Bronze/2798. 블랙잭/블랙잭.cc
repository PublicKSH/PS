//블랙잭
#include <iostream>
#include <algorithm> //max()
using namespace std;

int cards[100];

int main() {
	int N, M;
	cin >> N >> M;
	//카드값의 입력
	for(int i=0; i!=N; i++) {
		int card; cin >> card; 
		cards[i] = card;
	}
	//nC3만큼 모든 값을 다 구해서 M과의 차이가 가장 적은 숫자를 출력
	int almost_M = 0; //M과 가장 가까운 숫자
	for(int i=0; i!=N; i++) {
		for (int j=i+1; j!=N; j++) {
			for (int k=j+1; k!=N; k++) {
				if(cards[i]+cards[j]+cards[k] <= M)
					almost_M = max(cards[i]+cards[j]+cards[k],almost_M);
			}
		}
	}
	cout << almost_M;
	return 0;
}