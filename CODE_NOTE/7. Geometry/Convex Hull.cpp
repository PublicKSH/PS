#include <bits/stdc++.h>
using namespace std;
#define ll long long int
#define FUP(i, a, b) for(int i = a; i <= b; i++)
#define FDOWN(i, a, b) for(int i = a; i >= b; i--)
#define MS(a, b) memset(a, b, sizeof(a))
#define ALL(v) v.begin(), v.end()
#define CIN(a) cin >> a;
#define CIN2(a, b) cin >> a >> b
#define CIN3(a, b, c) cin >> a >> b >> c
#define COUT(a) cout << a
#define COUT2(a, b) cout << a << ' ' << b
#define COUT3(a, b, c) cout << a << ' ' << b << ' ' << c
#define ENDL cout << '\n'
int dy[4] = { -1, 1, 0, 0 };
int dx[4] = { 0, 0, 1, -1 };
#define MAX 100001


struct Point 
{
    int x, y, p, q;
    Point(int _x = 0, int _y = 0) : x(_x), y(_y), p(1), q(0) {}
};

bool comp(const Point& A, const Point& B)
{
    if (1LL * A.q * B.p != 1LL * A.p * B.q)
        return 1LL * A.q * B.p < 1LL * A.p * B.q;

    if (A.y != B.y)
        return A.y < B.y;

    return A.x < B.x;
}

ll ccw(const Point& A, const Point& B, const Point& C)
{
    return 1LL * (A.x * B.y + B.x * C.y + C.x * A.y - B.x * A.y - C.x * B.y - A.x * C.y);
}

int N, x, y;
Point arr[MAX];
stack<int> S;

void input()
{
    CIN(N);
    FUP(i, 0, N - 1)
    {
        CIN2(x, y);
        arr[i] = Point(x, y);
    }
}

void convex_hull()
{
    sort(arr, arr + N, comp); // y좌표, x좌표가 작은 순으로 정렬

    FUP(i, 1, N - 1) // 기준점으로부터 상대 위치 계산
    {
        arr[i].p = arr[i].x - arr[0].x;
        arr[i].q = arr[i].y - arr[0].y;
    }

    sort(arr + 1, arr + N, comp); // 반시계 방향으로 다시 정렬

    S.push(0);
    S.push(1);
    int next = 2;
    while (next < N)
    {
        while (S.size() >= 2)
        {
            int first, second;
            second = S.top();
            S.pop();
            first = S.top();

            // first, second, next가 좌회전 ( > 0 )이라면 second push
            // 우회전( < 0 )이라면 위의 while문 계속 반복
            if (ccw(arr[first], arr[second], arr[next]) > 0) 
            {
                S.push(second);
                break;
            }
        }
        // next push
        S.push(next++);
    }
}


int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

    input();
    convex_hull();

	return 0;
}