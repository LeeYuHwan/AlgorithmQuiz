#include <iostream>
#include <vector>
#include <stack>
#include <algorithm>
using namespace std;
string input = "";
vector<string> answer;
int check[201];

void dfs(int idx, vector<int> v) {
	if (idx == input.length()) {
		string answerT = "";
		for (int i = 0; i < input.size(); i++) {
			if (input[i] == '(' || input[i] == ')') {
				if (v[i] == 1) answerT += input[i];
			}
			else answerT += input[i];
		}

		if (input != answerT) answer.push_back(answerT);

		return;
	}
	if (input[idx] == '(') {
		dfs(idx + 1, v);
		v[idx] = 1;
		v[check[idx]] = 1;
		dfs(idx + 1, v);
	}
	else dfs(idx + 1, v);
}

int main()
{	
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);	
	cin >> input;

	stack<int> stk;
	for (int i = 0; i < input.length(); i++) {
		if (input[i] == '(') {
			stk.push(i);
		}
		else if (input[i] == ')') {
			check[i] = stk.top();
			check[stk.top()] = i;
			stk.pop();
		}
	}

	vector<int> v(input.size());
	dfs(0, v);

	sort(answer.begin(), answer.end());
	answer.erase(unique(answer.begin(), answer.end()), answer.end());

	for (int i = 0; i < answer.size(); i++) {
		cout << answer[i] << '\n';
	}

}