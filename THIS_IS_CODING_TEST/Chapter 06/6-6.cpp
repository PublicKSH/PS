//계수 정렬
//가장 큰 데이터와 가장 작은 데이터의 차이가 1,000,000을 넘기지 않을때 효과적으로 사용
#include <bits/stdc++.h>
using namespace std;

#define MAX_VALUE 9
#define max_len 15

int arr[max_len] = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};
int cnt[MAX_VALUE + 1];

int main(void) {
    for (int i = 0; i < max_len; i++) {
        cnt[arr[i]] += 1; // 각 데이터에 해당하는 인덱스의 값 증가
    }
    for (int i = 0; i <= MAX_VALUE; i++) { // 배열에 기록된 정렬 정보 확인
        for (int j = 0; j < cnt[i]; j++) {
            cout << i << ' '; // 띄어쓰기를 기준으로 등장한 횟수만큼 인덱스 출력
        }
    }
	return 0;
}