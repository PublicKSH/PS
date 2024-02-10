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
using namespace std;
#define MAX 10

int N;
int inDegree[MAX]; // ���� ���� �ǹ�
vector<int> v[MAX]; // �� ������ ����Ǿ� �ִ� ��� ��� ����

void topology_sort()
{
    int result[MAX]; // ���������� ������ ����� ��� �迭
    queue<int> q;
    // ���� ������ 0�� node ť�� ����
    FUP(i, 1, N)
    {
        if (inDegree[i] == 0)
        {
            q.push(i);
        }
    }
    // ���� ������ ������ ����Ƿ��� ��Ȯ�� N���� ��� �湮�ؾ��� 
    FUP(i, 1, N)
    {
        // n���� ��带 �湮�ϱ� ���� ť�� ��� ����Ŭ �߻� 
        if (q.empty())
        {
            COUT(-1);
            ENDL;
            return;
        }
        // ť�� ���� ���� ���Ҹ� ���� result �迭�� �־��� 
        int x = q.front();
        q.pop();
        result[i] = x;
        // ���� ���ҿ� ������ �Ǿ��ִ� ��� �������� Ȯ���ϸ鼭 �������� 
        for(int i : v[x])
        {
            // ���������� 0�� ��� ť�� ����
            if (--inDegree[i] == 0)
            {
                q.push(i);
            }
        }
    }
    // ��� ���
    FUP(i, 1, N)
    {
        COUT2(result[i], "");
    }
    ENDL;
}