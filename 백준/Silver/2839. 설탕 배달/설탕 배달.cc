#include <iostream>
using namespace std;

int main()
{
	int suger, box = -1; //box는 봉지개수
	cin >> suger;
	int Maxfive = suger/5+1, Maxthree = suger/3+1; //최대 5kg봉지 3kg봉지
	for (int i =Maxfive; i >=0; i--)
	{
		for (int j = 0; j < Maxthree; j++)
		{
			if ((5 * i + 3 * j) == suger)
			{
				box = i + j;
				break;
			}
		}
		if (box != -1)
			break;
	}
	cout << box;
	return 0;
}