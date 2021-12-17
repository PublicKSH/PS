#include <bits/stdc++.h>
using namespace std;
#define ll long long

ll gcd(ll x, ll y)
{
	if (x < y) swap(x, y);
	ll rest;
	while (y)
	{
		rest = x % y;
		x = y;
		y = rest;
	}
	return x;
}

int gcd(int x, int y)
{
	if (!y) return x;
	else return gcd(y, x % y);
}

ll exEuclid(ll a, ll b, ll& x, ll& y)
{ 
	if (b == 0)
	{ 
		x = 1;
		y = 0;
		return a;
	} 
	ll gcd = exEuclid(b, a % b, x, y);
	ll temp = y;
	y = x - (a / b) * y;
	x = temp;
	if (x <= 0)
	{
		x += b;
		y -= a;
	}
	return gcd;
}
