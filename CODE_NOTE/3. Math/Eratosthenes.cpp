#include <bits/stdc++.h>

// 에라토스테네스의 체
#define SIZE 100
int arr[SIZE + 1];

void eratosthenes()
{
    FUP(i, 2, SIZE) arr[i] = i;
    FUP(i, 2, sqrt(SIZE))
    {
        // 이미 체크된 수의 배수들은 합성수임이 자명
        if (arr[i] == 0) continue;
        // i를 제외한 i의 배수들을 0으로 체크
        for (int j = i + i;j <= SIZE;j += i) arr[j] = 0;
    }
}