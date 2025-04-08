#include <bits/stdc++.h>
using namespace std;

struct Student {
	int weight;
	int height;
	int num; //덩치 등수
	Student(int w, int h) : weight(w), height(h), num(1) {}
};

int compare(const Student& s1, const Student& s2) {
	//s1이 s2보다 크다
	if (s1.weight > s2.weight && s1.height > s2.height)
		return 1;
	//s1이 s2보다 작다
	else if (s1.weight < s2.weight && s1.height < s2.height)
		return -1;
	//s1과 s2의 덩치가 같다.
	else
		return 0;
}
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