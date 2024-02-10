#include <bits/stdc++.h>
using namespace std;


ll CCW(ll x1, ll y1, ll x2, ll y2, ll x3, ll y3)
{
    ll temp = x1 * y2 + x2 * y3 + x3 * y1;
    temp = temp - y1 * x2 - y2 * x3 - y3 * x1;
    if (temp > 0) return 1;         //반시계반향
    else if (temp < 0) return -1;   //시계방향
    else return 0;                  //일직선
}