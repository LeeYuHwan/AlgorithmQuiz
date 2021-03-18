#include <iostream>
#include <vector>
using namespace std;
vector<pair<int, int>> house;
int answer = 51 * 51;

void Combination(vector<pair<int, int>> arr, vector<pair<int, int>> comb, int r, int index, int depth)
{
	if (r == 0)
	{
		int sum = 0;
		for (int i = 0; i < house.size(); i++) {
			int hH = house[i].first;
			int wH = house[i].second;

			int min = 51 * 51;
			for (int j = 0; j < comb.size(); j++) {
				//cout << "(" << comb[j].first << " " << comb[j].second << ") ";

				if (abs(house[i].first - comb[j].first) + abs(house[i].second - comb[j].second) < min) {
					min = abs(house[i].first - comb[j].first) + abs(house[i].second - comb[j].second);
				}				
			}

			//cout << min << " ";
			sum += min;
		}
		
		if (answer > sum) answer = sum;

		//cout << answer;
		//cout << endl;
	}
	else if (depth == arr.size())  // depth == n
	{
		return;
	}
	else
	{
		comb[index] = arr[depth];
		Combination(arr, comb, r - 1, index + 1, depth + 1);

		Combination(arr, comb, r, index, depth + 1);
	}
}


int main()
{
	int N = 0, M = 0;
	cin >> N >> M;

	int map[51][51];
	vector<pair<int, int>> chicken;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			cin >> map[i][j];

			if (map[i][j] == 1) house.push_back(make_pair(i, j));
			if (map[i][j] == 2) chicken.push_back(make_pair(i, j));
		}
	}

	vector<pair<int, int>> tmp(M);
	Combination(chicken, tmp, M, 0, 0);

	cout << answer;
}