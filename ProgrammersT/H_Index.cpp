#include <string>
#include <vector>

using namespace std;

int solution(vector<int> citations) {
    int answer = 0;
    int h_idx = 0;
    int tmp = 0;
    int max = 0;

    for (int i = 0; i < citations.size(); i++) {
        if (max < citations[i]) max = citations[i];
    }

    for (int i = 0; i < max; i++) {
        h_idx = i;
        for (int j = 0; j < citations.size(); j++) {
            if (citations[j] >= h_idx) tmp++;
        }
        if (tmp >= h_idx && h_idx > answer) answer = h_idx;

        tmp = 0;
    }
    return answer;
}