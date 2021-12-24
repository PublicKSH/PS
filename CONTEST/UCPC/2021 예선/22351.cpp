#include <bits/stdc++.h>
using namespace std;



int main()
{
    int min, max;
    string number;

    cin >> number;

    for (int i=1; i!=1000; i++) {
        string answer = "";
        min = i;
        max = 0;

        for (int j=i; j!=1000; j++) {
            answer += to_string(j);
            
            if (answer == number) {
                max = j;
                cout << min << " " << max;
                return 0;
            }
        }

    }

    return 0;
}


