#include <iostream>
#include <vector>
#include <stack>
using namespace std;

int main()
{	
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);	
	int N = 0, K = 0;
	cin >> N >> K;

	string num = "";
	cin >> num;

	stack<char> stk;
	stk.push(num[0]);

	int cnt = 0;
	for (int i = 1; i < N; i++) {
		if (!stk.empty() && cnt < K && stk.top() < num[i]) {
			while (cnt < K) {
				if (stk.empty() || stk.top() >= num[i]) break;
				stk.pop();
				cnt++;
			}
			stk.push(num[i]);
		}
		else stk.push(num[i]);
	}
	
	string answer = "";
	while (!stk.empty()) {
		if (cnt < K) {
			stk.pop();
			cnt++;
		}
		else {
			answer += stk.top();
			stk.pop();
		}	
	}
	
	for (int i = answer.length() - 1; i >= 0; i--) {
		cout << answer[i];
	}
}