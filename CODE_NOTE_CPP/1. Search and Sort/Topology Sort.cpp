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
int inDegree[MAX]; // 진입 차수 의미
vector<int> v[MAX]; // 각 정점에 연결되어 있는 모든 노드 정보

void topology_sort()
{
    int result[MAX]; // 위상정렬을 수행한 결과값 담는 배열
    queue<int> q;
    // 진입 차수가 0인 node 큐에 삽입
    FUP(i, 1, N)
    {
        if (inDegree[i] == 0)
        {
            q.push(i);
        }
    }
    // 위상 정렬이 완전히 수행되려면 정확히 N개의 노드 방문해야함 
    FUP(i, 1, N)
    {
        // n개의 노드를 방문하기 전에 큐가 비면 사이클 발생 
        if (q.empty())
        {
            COUT(-1);
            ENDL;
            return;
        }
        // 큐의 가장 앞의 원소를 빼서 result 배열에 넣어줌 
        int x = q.front();
        q.pop();
        result[i] = x;
        // 꺼낸 원소에 연결이 되어있는 모든 정점들을 확인하면서 간선제거 
        for(int i : v[x])
        {
            // 진입차수가 0인 노드 큐에 삽입
            if (--inDegree[i] == 0)
            {
                q.push(i);
            }
        }
    }
    // 결과 출력
    FUP(i, 1, N)
    {
        COUT2(result[i], "");
    }
    ENDL;
}