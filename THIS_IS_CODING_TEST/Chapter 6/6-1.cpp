//선택 정렬
//시간 복잡도는 N^2
#include <bits/stdc++.h>
using namespace std;

#define max_len 10

int Array[] = {7,5,9,0,3,1,6,2,4,8};

int main() {
    for (int i=0; i!=max_len; i++) {
        int min_index = i; //가장 작은 원소의 인덱스
        for (int j=i+1; j!=max_len; j++) {
            if (Array[min_index] > Array[j]) min_index = j;
        }
        swap(Array[i], Array[min_index]);
    }

    for(int i=0; i!=max_len; i++) {
		cout << Array[i] << ' ';
	}
    return 0;
}
