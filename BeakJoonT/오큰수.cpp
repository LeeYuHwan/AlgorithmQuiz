#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);

	int n = 0;
	cin >> n;
	
	stack<pair<int, int>> stk;
	vector<int> answer(1000001);

	int value = 0;
	cin >> value;

	stk.push(make_pair(value, 0));

	for (int i = 1; i < n; i++) {		
		cin >> value;

		if (!stk.empty()) {
			if (value > stk.top().first) {

				while (!stk.empty()) {
					if (value > stk.top().first) {
						answer[stk.top().second] = value;
						stk.pop();
					}
					else break;
				}

				stk.push(make_pair(value, i));
			}
			else {
				stk.push(make_pair(value, i));
			}
		}

	}

	while (!stk.empty()) {
		answer[stk.top().second] = -1;
		stk.pop();
	}

	for (int i = 0; i < n; i++) {
		cout << answer[i] << ' ';
	}
}