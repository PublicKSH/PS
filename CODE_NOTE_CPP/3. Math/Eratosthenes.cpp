#include <bits/stdc++.h>

// �����佺�׳׽��� ü
#define SIZE 100
int arr[SIZE + 1];

void eratosthenes()
{
    FUP(i, 2, SIZE) arr[i] = i;
    FUP(i, 2, sqrt(SIZE))
    {
        // �̹� üũ�� ���� ������� �ռ������� �ڸ�
        if (arr[i] == 0) continue;
        // i�� ������ i�� ������� 0���� üũ
        for (int j = i + i;j <= SIZE;j += i) arr[j] = 0;
    }
}