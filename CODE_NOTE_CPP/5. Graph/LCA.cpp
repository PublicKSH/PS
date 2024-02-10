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
#define MAX 50001
#define POW 16 //N의 최대 지수

int a, b, N, M, depth[MAX], par[MAX][POW + 1];
vector<int> edge[MAX];

void input()
{
	CIN(N);
	FUP(i, 1, N - 1)
	{
		CIN2(a, b);
		edge[a].push_back(b);
		edge[b].push_back(a);
	}
}

void DFS(int node, int before)
{
	par[node][0] = before;
	depth[node] = depth[before] + 1;
	for (int next : edge[node])
	{
		if (next == before) continue;
		DFS(next, node);
	}
}

void setPar()
{
	FUP(j, 1, POW)
	{
		FUP(i, 1, N)
		{
			par[i][j] = par[par[i][j - 1]][j - 1];
		}
	}
}

int LCA(int x, int y)
{
	if (depth[x] > depth[y]) swap(x, y);
	//x, y 깊이 맞추기
	FDOWN(i, POW, 0)
	{
		if (depth[y] - depth[x] >= (1 << i))
			y = par[y][i];
	}
	//일치할 경우 반환
	if (x == y) return x;
	//최소 공통 조상의 바로 아랫 노드로
	FDOWN(i, POW, 0)
	{
		if (par[x][i] != par[y][i])
		{
			x = par[x][i];
			y = par[y][i];
		}
	}
	//부모 반환
	return par[x][0];
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	input();
	depth[0] = 0;
	DFS(1, 0);
	setPar();

	CIN(M);
	while (M--)
	{
		CIN2(a, b);
		COUT(LCA(a, b));
		ENDL;
	}

	return 0;
}