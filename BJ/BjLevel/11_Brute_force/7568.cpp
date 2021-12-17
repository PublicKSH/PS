#include <bits/stdc++.h>
using namespace std;

int main() {
	int N;
	vector<Student> arr;
	cin >> N;
	for (int i=0; i!=N; i++) {
		int w,h;
		cin >> w >> h;
		arr.push_back(Student(w,h));
		for (int j=0; j!=i; j++) {
			if (compare(arr[i],arr[j]) == 1) {
				arr[j].num += 1;
			}
			else if(compare(arr[i],arr[j]) == -1) {
				arr[i].num += 1;
			}
			else {
				//아무것도 하지 않는다.
			}
		}
	}
	
	for (int i=0; i!=N; i++) {
		cout << arr[i].num << " ";
	}
	
	return 0;
}