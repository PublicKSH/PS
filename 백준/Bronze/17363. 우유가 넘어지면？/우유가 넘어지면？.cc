#include <bits/stdc++.h>
using namespace std;

char arr[101][101];
char input[10] = { '.', 'O', '|', '-', '/', '\\', '^', '<', 'v', '>' };
char output[10] = { '.', 'O', '-', '|', '\\', '/', '<', 'v', '>', '^' };


int n,m;

int main() {
    cin >> n >> m;
    for (int i=0; i!=n; i++) {
        for (int j=0; j!=m; j++) {
            char x;
            cin >> x;
            for (int k=0; k!=10; k++) {
                if (x == input[k]) {
                    x = output[k];
                    break;
                }
            }
            arr[i][j] = x;
        }
    }


    for (int i=m-1; i>=0; i--) {
        for (int j=0; j!=n; j++) {
            cout << arr[j][i];
        }
        cout << endl;
    }
    return 0;
}