#include "bits/stdc++.h"
using namespace std;

int main()
{
	int N = 0;
	int d[100][100];
	FUP(k, 0, N - 1)
	{
		FUP(j, 0, N - 1)
		{
			FUP(i, 0, N - 1)
			{
				if (d[i][j] > d[i][k] + d[k][j])
				{
					d[i][j] = d[i][k] + d[k][j];
				}
			}
		}
	}
}