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
int dy[4] = { -1, 1, 0, 0 };
int dx[4] = { 0, 0, 1, -1 };

int V, E, S;	//V : Node�� ��, E : Edge�� ��, S : ������
int u, v, w;	//u -> v�� ����ġ w
vector<pair<int, int>> arr[SIZE];	//	arr[i] = first���� second�� ����ġ
int d[SIZE]; //������������ �� idx node ������ �Ÿ�. ó���� INF������ �ʱ�ȭ �ʿ�

void dijkstra()
{
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	pq.push({ 0, S });	// S���� ����
	while (!pq.empty())
	{
		int distance = pq.top().first;
		int node = pq.top().second;
		pq.pop();
		if (distance > d[node]) continue;
		d[node] = distance;
		for (auto iter : arr[node])
		{
			if (d[iter.first] > d[node] + iter.second)
			{
				d[iter.first] = d[node] + iter.second;
				pq.push({ d[iter.first], iter.first });
			}
		}
	} // ������ d[i]�� INF�̸� ������ �� ����.
}