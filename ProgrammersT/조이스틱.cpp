#include <string>
#include <vector>

using namespace std;

int solution(string name) {
    int answer = 0;
    string joy = "";

    for (int i = 0; i < name.length(); i++) {
        joy += 'A';
    }

    int idx = 0;
    while (1) {
        if (joy.compare(name) == 0) break;

        if (name[idx] <= 'M') {
            answer += abs('A' - name[idx]);
            joy[idx] = name[idx];
        }
        else {
            answer += ('Z' - name[idx] + 1);
            joy[idx] = name[idx];
        }

        for (int i = 1; i < name.length(); i++) {
            if (name[(idx + i) % name.length()] != joy[(idx + i) % name.length()]) {
                idx = (idx + i) % name.length();
                answer += i;
                break;
            }
            else if (name[(idx + name.length() - i) % name.length()] != joy[(idx + name.length() - i) % name.length()]) {
                idx = (idx + name.length() - i) % name.length();
                answer += i;
                break;
            }
        }
    }
    return answer;
}