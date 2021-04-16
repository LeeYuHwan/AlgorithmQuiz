#include <string>
#include <vector>
#include <stack>
using namespace std;

int solution(string s) {
    int size = s.length();
    int start = 0;

    int answer = 0;
    while (size--) {
        stack<char> stk;
        int idx = start;
        int count = 0;
        while (count < s.length()) {

            if (!stk.empty() && stk.top() == '[' && s[idx] == ']') {
                stk.pop();
            }
            else if (!stk.empty() && stk.top() == '(' && s[idx] == ')') {
                stk.pop();
            }
            else if (!stk.empty() && stk.top() == '{' && s[idx] == '}') {
                stk.pop();
            }
            else stk.push(s[idx]);

            idx = (idx + 1) % s.length();
            count++;
        }

        if (stk.empty()) answer++;
        start++;
    }
    return answer;
}