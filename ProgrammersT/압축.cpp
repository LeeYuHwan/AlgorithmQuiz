#include <vector>
#include <map>
#include <string>

using namespace std;

vector<int> solution(string msg) {
    map<string, int> m;
    int cnt = 1;
    for (int i = 65; i <= 90; i++) {
        string tmp = "";
        tmp += i;
        m[tmp] = cnt++;
    }   

    vector<int> answer;
    int idx = 0;
    while (idx < msg.length()) {
        for (int i = msg.length() - idx; i >= 0; i--) {
            string sub = msg.substr(idx, i);
            if (m[sub] > 0) {
                answer.push_back(m[sub]);
                if (idx < msg.length() - 1 && m[msg.substr(idx, i + 1)] == 0) {
                    m[msg.substr(idx, i + 1)] = cnt++;
                }
                idx += sub.length();
                break;
            }
        }
    }
    return answer;
}