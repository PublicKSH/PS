#include <bits/stdc++.h>
using namespace std;

class Point {
public:
	int xpos;
	int ypos;
	Point(int x, int y) : xpos(x), ypos(y) {}
};

bool compare(const Point& p1, const Point& p2) {
	if (p1.xpos == p2.xpos) {
		return p1.ypos < p2.ypos;
	}
	else
		return p1.xpos < p2.xpos;
}

int main() {

	vector<Point> arr;
	int N;
	cin >> N;
	for (int i=0; i!=N; i++) {
		int x,y; 
		scanf("%d %d",&x,&y);
		arr.push_back(Point(x,y));
	}
	sort(arr.begin(),arr.end(),compare);
	for (int i=0; i!=N; i++) {
		printf("%d %d\n",arr[i].xpos,arr[i].ypos);
	}
	return 0;
}