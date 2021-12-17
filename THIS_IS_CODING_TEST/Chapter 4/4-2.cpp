#include <bits/stdc++.h>
using namespace std;

//3이있는지 확인
bool Check3(int i, int j, int k) {
    if (i % 10 == 3 || j / 10 == 3 || j % 10 == 3 || k / 10 == 3 || k % 10 == 3)
        return true;
    return false;
}

int n;
int cnt = 0;
int main() {
    cin >> n;

    for (int i=0; i<=n; i++) {
        for(int j=0; j<=59; j++) {
            for (int k=0; k<=59; k++) {
                if (Check3(i,j,k))
                    cnt++;
            }
        }
    }
    
    cout << cnt << ' ';
	return 0;
}