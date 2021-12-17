//재귀을 통한 이분 탐색
#include <bits/stdc++.h>
using namespace std;

int binarySearch(vector<int>& arr, int target, int start, int end) {
	while (start <= end) {
        int mid = (start + end)/2;
        if (arr[mid] == target) return mid;
        else if (arr[mid] > target) end = mid-1;
        else
            start = mid+1;
    }
    return -1;
}

int n, m;
vector<int> arr1,arr2; //1은 가게, 2는 손님

int main(void) {
    cin >> n;
    for (int i=0; i!=n; i++) {
        int x;
        cin >> x;
        arr1.push_back(x);
    }
    // 이진탐색을 위해 정렬미리해놓기
    sort(arr1.begin(),arr1.end());

    cin >> m;
    for (int i=0; i!=m; i++) {
        int x;
        cin >> x;
        arr2.push_back(x);
    }

    for (int i=0; i!=m; i++) {
        if (binarySearch(arr1,arr2[i],0,n-1) == -1)
            cout << "No ";
        else
            cout << "yes ";
    }
    return 0;
} 