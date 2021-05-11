#include <iostream>
#include <vector>
#include <stack>
using namespace std;

int main()
{	
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
	
	string calc;
	cin >> calc;

	stack<char> stk;
	string answer = "";

	for (int i = 0; i < calc.length(); i++) {
		if (calc[i] >= 65 && calc[i] <= 90) {
			answer += calc[i];
		}
		else {
			if (calc[i] == '(') stk.push(calc[i]);
			if (calc[i] == '*' || calc[i] == '/') {
				while (!stk.empty() && (stk.top() == '*' || stk.top() == '/')) {
					answer += stk.top();
					stk.pop();
				}
				stk.push(calc[i]);
			}
			if (calc[i] == '+' || calc[i] == '-') {
				while (!stk.empty() && stk.top() != '(') {
					answer += stk.top();
					stk.pop();
				}
				stk.push(calc[i]);
			}
			if (calc[i] == ')') {
				while (!stk.empty() && stk.top() != '(') {
					answer += stk.top();
					stk.pop();
				}
				stk.pop();
			}
		}
	}
	while (!stk.empty()) {
		answer += stk.top();
		stk.pop();
	}
	cout << answer << endl;
	
}