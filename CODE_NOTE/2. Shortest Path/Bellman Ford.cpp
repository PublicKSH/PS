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
#define SIZE 1001
#define INF 987654321
int dy[4] = { -1, 1, 0, 0 };
int dx[4] = { 0, 0, 1, -1 };

int V, E, S;	//V : Node의 수, E : Edge의 수, S : 시작점
int u, v, w;	//u -> v의 가중치 w
vector<pair<int, ll>> arr[SIZE];	//	arr[i] = first까지 second의 가중치
ll d[SIZE]; //시작점에서의 각 idx node 까지의 거리. 처음에 INF값으로 초기화 필요

bool bellman_ford()
{
	fill(d, d + V + 1, INF);
	d[S] = 0;
	FUP(repeat, 1, V)
	{
		FUP(i, 1, V)
		{
			if (d[i] == INF) continue;
			for (auto p : arr[i])
			{
				int next = p.first;
				ll dist = p.second;
				if (d[next] > d[i] + dist)
				{
					d[next] = d[i] + dist;
					if (repeat == V) return false;
				}
			}
		}
	}
	return true;
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	return 0;
}