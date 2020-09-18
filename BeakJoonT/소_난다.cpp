#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int n = 0, m = 0;
vector<int> answer;
vector<int> h;

void check(bool* h_check)
{
	int tmp = 0;
	int count = 0;
	for (int i = 0; i < n; i++)
	{
		if (h_check[i] == true)
		{
			tmp += h[i];
		}
	}
	if (tmp % 2 != 0) {
		for (int j = 2; j < (tmp / 2); j++) {
			if ((tmp % j) == 0) count++;
		}
		if (count == 0) {
			answer.push_back(tmp);
		}
	}
	else if (tmp == 2) answer.push_back(tmp);
}

void DFS(int Idx, int Cnt, bool *h_check)
{
	if (Cnt == m)
	{
		check(h_check);
		return;
	}

	for (int i = Idx; i < n; i++)
	{
		if (h_check[i] == true) continue;
		h_check[i] = true;
		
		DFS(i, Cnt + 1, h_check);
		h_check[i] = false;
	}
}

int main(void)
{	
	cin >> n >> m;
	bool* h_check = new bool[n];

	for (int i = 0; i < n; i++) {
		int a = 0;
		cin >> a;
		h.push_back(a);
	}

	DFS(0, 0, h_check);

	if (answer.empty()) cout << -1;
	else {
		sort(answer.begin(), answer.end());
		answer.erase(unique(answer.begin(), answer.end()), answer.end());
		for (int i = 0; i < answer.size(); i++) {
			cout << answer[i] << " ";
		}
	}
	
	delete[] h_check;
}