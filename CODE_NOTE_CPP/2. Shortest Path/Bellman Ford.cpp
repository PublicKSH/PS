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

int V, E, S;	//V : Node�� ��, E : Edge�� ��, S : ������
int u, v, w;	//u -> v�� ����ġ w
vector<pair<int, ll>> arr[SIZE];	//	arr[i] = first���� second�� ����ġ
ll d[SIZE]; //������������ �� idx node ������ �Ÿ�. ó���� INF������ �ʱ�ȭ �ʿ�

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