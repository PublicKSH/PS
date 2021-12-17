//성적이 낮은 순서로 학생 출력하기
#include <bits/stdc++.h>
using namespace std;

class Student {
public:
	string name;
	int score;
	Student(string n, int s) : name(n), score(s) {}
	
	// 정렬 기준은 점수가 낮은 순서
	bool operator<(Student& other) {
		return this->score < other.score;
	}
};

int main() {
	int N;
	vector<Student> arr;
	cin >> N;
	for (int i=0; i!=N; i++) {
		string name; int score;
		cin >> name >> score;
		arr.push_back(Student(name,score));
	}
	//정렬 라이브러리를 이용한 정렬
	sort(arr.begin(),arr.end());
	for(int i=0; i!=N; i++) {
		cout << arr[i].name << ' ';
	}
	return 0;
}