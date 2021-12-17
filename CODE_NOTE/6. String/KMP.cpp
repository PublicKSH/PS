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

int N, M;
string s, p; // s안의 부분문자열 p를 찾기
vector<int> pi, ans;

void getPi()
{
	int j = 0;
	pi.resize(M, 0);
	FUP(i, 1, M - 1)
	{
		while (j > 0 && p[i] != p[j]) j = pi[j - 1];
		if (p[i] == p[j]) pi[i] = ++j;
	}
}

void KMP()
{
	int j = 0;
	FUP(i, 0, N - 1)
	{
		while (j > 0 && s[i] != p[j]) j = pi[j - 1];
		if (s[i] == p[j])
		{
			if (j == M - 1)
			{
				ans.push_back(i - M + 1);
				j = pi[j];
			}
			else j++;
		}
	}
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	getline(cin, s);
	N = s.length();
	getline(cin, p);
	M = p.length();
	getPi();
	KMP();

	return 0;
}