//삽입 정렬
//데이터가 거의 정렬되어 있을때 효율적
//시간 복잡도는 N~N^2
#include <bits/stdc++.h>
using namespace std;

#define max_len 10

int Array[] = {7,5,9,0,3,1,6,2,4,8};

int main() {
    cout << "삽입정렬" << endl;
    for (int i=1; i!=max_len; i++) {
        for (int j=i; j!=0; j--) {
            if (Array[j] < Array[j-1]) 
                swap(Array[j], Array[j-1]);
            else
                break;
        }
    }

    for(int i=0; i!=max_len; i++) {
		cout << Array[i] << ' ';
	}
    return 0;
}
