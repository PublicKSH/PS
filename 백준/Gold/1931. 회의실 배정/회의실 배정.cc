#include <iostream> 
#include <algorithm>  //sort()
using namespace std;

#define MAXLEN 100000

struct conference {
	int start;
	int end;
};

conference* con_arr[MAXLEN]; //conference* 배열 (new를 사용하기 위함)

bool end_sort(const conference* c1,const conference* c2) { //end기준 내림차순 정렬
	return c1->end < c2->end;
}
bool start_sort(const conference* c1, const conference* c2) {//start기준 내림차순 정렬
	return c1->start < c2->start;
}

int main() {
	int N; //회의의 수
	int S,E; //회의의 시작과 끝시간
	int count = 0, now_time = 0; //count는 여태까지 진행한 회의숫자, now_time은 시간저장을 위한 변수
	cin >> N;
	for (int i=0; i != N; i++) { //con_arr입력
		cin >> S >> E;
		con_arr[i] = new conference;
		con_arr[i]->start = S;
		con_arr[i]->end = E;
	}
	
	sort(con_arr, con_arr+N, end_sort); //end기준 오름차순 정렬
	
	for (int i=0; i < N; i++) {
		if (con_arr[i]->start >= now_time) { 
			int j = i+1;
			while ( j < N && con_arr[i]->end == con_arr[j]->end) //아.. 왼쪽부터 확인하므로 인덱스에들어가는 숫자가 있는 조건문을 먼저 넣는다.
				j++;
			sort(con_arr+i, con_arr+j, start_sort);
			
			now_time = con_arr[i]->end;
			count++;
		}
	}
	
	cout << count;
	return 0;
}

