//재귀을 통한 이분 탐색
#include <bits/stdc++.h>
using namespace std;

int binarySearch(vector<int>& arr, int target, int start, int end) {
	if (start > end) return -1;
    int mid = (start + end)/2;
    if (arr[mid] == target) return mid;
    else if (arr[mid] > target) {
        return binarySearch(arr,target,start,mid-1);
    }
    else{
        return binarySearch(arr,target,mid+1,end);  
    } 
}

int n;
int target;
vector<int> arr;

int main(void) {
    // n(원소의 개수)와 target(찾고자 하는 값)을 입력 받기 
    cin >> n >> target;
    // 전체 원소 입력 받기 
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        arr.push_back(x);
    }
    // 이진 탐색 수행 결과 출력 
    int result = binarySearch(arr, target, 0, n - 1);
    if (result == -1) {
        cout << "원소가 존재하지 않습니다." << '\n';
    }
    else {
        cout << result + 1 << '\n';
    }
}