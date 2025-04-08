#include <iostream>
using namespace std;

int main()
{
	int C;
	int N;
	int arr[1000];
	double sum=0;
	double ave;
	int aveup=0; //평균이상
	cin >> C;
	for (int i=0; i<C; i++)
	{
		cin >> N;
		for(int j=0; j<N; j++) // 평균구하기
		{
			cin >> arr[j];
			sum += arr[j];
		}
		ave = sum/N;
		for(int j=0; j<N; j++)
		{
			if(arr[j] > ave) aveup++;
		}
		cout.precision(5); //소숫점 3째 자리까지 출력
		cout << (aveup/(double)N)*100 << "%" << endl;
		sum =0; aveup=0;
	}
	
	return 0;
}