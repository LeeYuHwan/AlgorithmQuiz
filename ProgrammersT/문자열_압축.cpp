#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    int answer = s.size();

    for (int i = 1; i <= s.size() / 2; i++) {
        int cnt = 1;
        string sum = "", tmp = s.substr(0, i);

        for (int j = i; j <= s.size(); j += i) {
            if (tmp == s.substr(j, i)) cnt++;
            else {
                if (cnt == 1) sum += tmp;
                else {
                    sum += to_string(cnt) + tmp;
                }

                tmp = s.substr(j, i);
                cnt = 1;
            }
        }

        if ((s.size() % i) != 0) sum += s.substr((s.size() / i) * i);
        if (answer > sum.size()) answer = sum.size();
    }

    return answer;
}