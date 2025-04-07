#include <bits/stdc++.h>
using namespace std;

const int MAX = 100000;

int t,n;
pair<int,int> arr[MAX];

int main() {
    cin >> t;
    while (t !=0) {
        cin >> n;
        
        for (int i=0; i<n; i++) {
            cin >> arr[i].first >> arr[i].second;
        }
        sort(arr, arr+n);
        int result = 1; // 서류 1등 통과
        int interview = arr[0].second; // 1등의 인터뷰 점수
        // 1등의 인터뷰 점수보다 낮은 인터뷰점수를 가진 지원자들 전부 탈락
        // 이후 남은 지원자들을 인터뷰 점수로 정렬해서 낮은 서류점수 탈락
        for (int i=1; i<n; i++) {
            if (arr[i].second < interview) {
                result++;
                interview = arr[i].second;
            }
        }
        cout << result << '\n';
        t--;
    }

    return 0;
}