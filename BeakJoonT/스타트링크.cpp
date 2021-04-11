#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
	
	int F = 0, S = 0, G = 0, U = 0, D = 0;

	cin >> F >> S >> G >> U >> D;
	vector<bool> check(F + 1);
	check[S] = true;
	queue<pair<int, int>> q;
	q.push(make_pair(S, 0));

	int answer = 0;
	int sw = false;
	while (!q.empty()) {
		int loc = q.front().first;
		int count = q.front().second;
		q.pop();
		
		if (loc == G) {
			answer = count;
			sw = true;
			break;
		}
		if (loc + U <= F && !check[loc + U]) {
			q.push(make_pair(loc + U, count + 1));
			check[loc + U] = true;
		}
		if (loc - D > 0 && !check[loc - D]) {
			q.push(make_pair(loc - D, count + 1));
			check[loc - D] = true;
		}
	}

	if (!sw) cout << "use the stairs";
	else cout << answer;
}