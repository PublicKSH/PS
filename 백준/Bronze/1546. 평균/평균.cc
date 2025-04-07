#include <iostream>
using namespace std;
 
int main() 
{
	int N, NUM, MAX;
	double arr[1000],sum=0;
	
	cin >> N;
	for (int i=0; i<N; i++)
	{
		cin >> arr[i];
	}
	MAX = arr[0];
	for (int i=0; i<N; i++)
	{
		if (MAX < arr[i]) MAX = arr[i];
	}
	//자기점수중에 최댓값 = MAX 
	for (int i=0; i<N; i++)
	{
		arr[i] = arr[i]/MAX*100;
	}
	//모든 점수를 점수/M*100으로 고졋다
	//바뀐점수의 총합을 구한다.
	for (int i=0; i<N; i++)
	{
		sum += arr[i];
	}
	cout << sum/N;
	return 0;
}