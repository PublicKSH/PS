//15904번
#include <bits/stdc++.h>
using namespace std;

string fLine;
char UCPC[4] = {'U','C','P','C'};
int UCPC_index = 0;
int main() {
    getline(cin,fLine);
    
    for(string::size_type i=0; i!=fLine.size(); i++) {
        if (fLine[i] == UCPC[UCPC_index]) {
            UCPC_index++;
        }
    }
    
    if (UCPC_index == 4) {
        cout << "I love UCPC";
    }
    else {
        cout << "I hate UCPC";
    }
    return 0;
}