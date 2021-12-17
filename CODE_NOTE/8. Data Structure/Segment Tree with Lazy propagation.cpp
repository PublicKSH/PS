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
#define SIZE 10000

int N;
ll arr[SIZE], tree[SIZE * 4], lazy[SIZE * 4];

ll init(int idx, int s, int e)
{
	int mid = (s + e) / 2;
	lazy[idx] = 0;
	if (s == e) return tree[idx] = arr[s];
	else return tree[idx] = init(idx * 2, s, mid) + init(idx * 2 + 1, mid + 1, e);
}


//sum(1, 1, N, ����, ������);
ll sum(int idx, int s, int e, int l, int r)
{
	//lazy�� ���� ���� ��
	if (lazy[idx])
	{
		tree[idx] += ((e - s + 1) * lazy[idx]);
		//���� ��忡 ����
		if (s != e)
		{
			lazy[idx * 2] += lazy[idx];
			lazy[idx * 2 + 1] += lazy[idx];
		}
		lazy[idx] = 0;
	}
	//[left, right] ������ [start, end]�� ���� ��ġ�� �ʴ� ���
	if (s > r || e < l) return 0;
	//[start, end] ������ [left, right]�� ������ ���� �ִ� ���
	else if (s >= l && e <= r) return tree[idx];
	ll mid = (s + e) / 2;
	return sum(2 * idx, s, mid, l, r) + sum(2 * idx + 1, mid + 1, e, l, r);
}

//update_range(1, 1, N, �ٲ� [left, right], ���� ��) -> [left,right] ��忡 diff�� ����;
void update_range(int idx, int s, int e, int l, int r, ll diff)
{
	//lazy�� ���� ���� ��
	if (lazy[idx])
	{
		tree[idx] += ((e - s + 1) * lazy[idx]);
		//���� ��忡 ����
		if (s != e)
		{
			lazy[idx * 2] += lazy[idx];
			lazy[idx * 2 + 1] += lazy[idx];
		}
		lazy[idx] = 0;
	}
	if (r < s || l > e) return;
	//��ǥ����
	if (l <= s && e <= r)
	{
		tree[idx] += ((e - s + 1) * diff);
		if (s != e)
		{
			lazy[idx * 2] += diff;
			lazy[idx * 2 + 1] += diff;
		}
		return;
	}
	int mid = (s + e) / 2;
	update_range(idx * 2, s, mid, l, r, diff);
	update_range(idx * 2 + 1, mid + 1, e, l, r, diff);
	tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
}


int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	CIN(N);
	FUP(i, 1, N) CIN(arr[i]);
	init(1, 1, N);


	return 0;
}