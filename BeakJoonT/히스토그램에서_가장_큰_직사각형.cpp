#include <iostream>
#include <vector>
#include <stack>
#include <algorithm>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
	
	int n;
	vector<long> h(100001);
	while (1) {
		cin >> n;

		if (n == 0) break;

		for (int i = 0; i < n; i++) {
			cin >> h[i];
		}

		h[n] = -1;

		stack<int> stk;
		long answer = 0;

		for (int i = 0; i <= n; i++) {
			while (!stk.empty() && h[stk.top()] > h[i]) {
				int tmp = stk.top();
				stk.pop();

				int width = 0;  (stk.empty() ? i : i - stk.top() - 1);

				if (stk.empty()) width = i;
				else {
					width = i - stk.top() - 1;
				}
				
				
				answer = max(answer, h[tmp] * width);
			}

			stk.push(i);
		}

		cout << answer << '\n';
	}
}