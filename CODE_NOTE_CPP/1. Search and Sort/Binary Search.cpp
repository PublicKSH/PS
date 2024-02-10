#include <bits/stdc++.h>
using namespace std;

vector<int> arr;

int binary_search(int num)
{
	int left = 0;
	int right = arr.size() - 1;
	while (left <= right)
	{
		int mid = (left + right) / 2;
		if (arr[mid] > num)
			right = mid - 1;
		else if (arr[mid] < num)
			left = mid + 1;
		else
			return mid;
	}
	return -1;
}

int main()
{

}