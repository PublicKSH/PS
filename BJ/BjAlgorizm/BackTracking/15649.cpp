// 22.03.01
// 
// 백트레킹 -> DFS활용 
// 15649
#include <bits/stdc++.h>
using namespace std;


int n, m;
int arr[9];
bool visited[9];

void dfs(int k) {
    if (k==m) {
        for (int i=0; i!=m; i++) {
            cout << arr[i] << " ";
        }
        cout << "\n";
    }
    else {
        for (int i=1; i<=n; i++) {
            if (!visited[i]) { //방문을 하지 않았다면
                visited[i] = true;
                arr[k] = i;
                dfs(k+1);
                visited[i] = false; // 백트래킹 설정
            }
        }
    }
}

int main() {
    cin >> n >> m;
    dfs(0);

}
