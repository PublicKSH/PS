#include <bits/stdc++.h>
using namespace std;

vector<string> start_black = 
{
"BWBWBWBW",
"WBWBWBWB",
"BWBWBWBW",
"WBWBWBWB",
"BWBWBWBW",
"WBWBWBWB",
"BWBWBWBW",
"WBWBWBWB",
};

vector<string> start_white = 
{
"WBWBWBWB",
"BWBWBWBW",
"WBWBWBWB",
"BWBWBWBW",
"WBWBWBWB",
"BWBWBWBW",
"WBWBWBWB",
"BWBWBWBW"
};
int main() {
	int N, M;
	int MIN = 99999;
	vector<string> chess;
	cin >> N >> M;
	for (int i=0; i!=N; i++) {
		string line; 
		cin >> line;
		chess.push_back(line);
	}
	//체스판에서 8*8로 짜를수 있는 부분을 전부짤라 start_white와 start_black과 비교해서 더 작은 쪽을 반환한다.
	//a,b는 체스판에서 8*8로 짜를 수 있는 부분을 전부 짜른다.
	for (int a=0; a<=N-8; a++) {
		for (int b=0; b<=M-8; b++) {
			int count1 = 0; 
			int count2 = 0;
			// i,j는 짜른 부분을 white, black을 비교한다.
			for (int i=0; i!=8; i++) {
				for (int j=0; j!=8; j++) {
					if (chess[a+i][b+j] != start_white[i][j])
						count1++;
					if (chess[a+i][b+j] != start_black[i][j])
						count2++;
				}
			}
			MIN = min(MIN,min(count1,count2));
		}
	}
	
	cout << MIN;
	return 0;
}