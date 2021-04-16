#include <string>
#include <vector>

using namespace std;

int solution(vector<int> absolutes, vector<bool> signs) {
    int answer = 0;
    for (int i = 0; i < absolutes.size(); i++) {
        int tmp = 0;
        if (!signs[i]) tmp = absolutes[i] * -1;
        else tmp = absolutes[i];
        answer += tmp;
    }
    return answer;
}