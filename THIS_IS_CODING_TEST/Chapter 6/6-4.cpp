//퀵 정렬
//거의 모든 라이브러리의 근간, 가장 빠르다 할 수 있다.
//재귀함수로 구현하면 편하다.
//시간 복잡도는 NLogN
#include <bits/stdc++.h>
using namespace std;

#define max_len 10

int arr[max_len] = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};


void quickSort(int* arr, int start, int end) {
	//원소가 1개면 종료
    if (start >= end) return;
    //피벗은 첫번째 원소
    int pivot = start;
    int left = start+1;
    int right = end;
    while (left <= right) {
        //왼쪽부터 피벗보다 큰 원소 찾음
        while(left <= end && arr[left] <= arr[pivot]) left++;
        //오른쪽부터 피벗보다 작은 원소 찾음
        while(right > start && arr[right] >= arr[pivot]) right--;
        //엇갈리면 작은 데이터와 피벗을 교체
		if (left > right) swap(arr[pivot],arr[right]);
		//엇갈리지 않았다면 작은 데이터와 큰 데이터를 교체
		else swap(arr[left],arr[right]);
    }
    //이후 파티션을 나눠서 진행
    quickSort(arr, start, right-1);
	quickSort(arr, right+1, end);
}


int main() {
    cout << "퀵 정렬" << endl;
    quickSort(arr,0,max_len-1);
	for(int i=0; i!=max_len; i++) {
		cout << arr[i] << ' ';
	}
	return 0;
}
