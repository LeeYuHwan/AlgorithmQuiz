#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int main()
{
	queue<pair<int, int>> q;

	int n = 0;
	cin >> n;

	for (int i = 0; i < n; i++) {
		int p = 0;
		cin >> p;

		q.push(make_pair(p, i));
	}

	int time = 0;
	vector<int> answer(n);
	while (!q.empty()) {
		time++;
		int p = q.front().first;
		int idx = q.front().second;
		q.pop();
		p--;

		if (p == 0) answer[idx] = time;
		else {
			q.push(make_pair(p, idx));
		}		
	}

	for (int i = 0; i < answer.size(); i++) {
		cout << answer[i] << " ";
	}
}