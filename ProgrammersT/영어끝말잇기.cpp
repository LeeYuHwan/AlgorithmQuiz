#include <string>
#include <vector>
#include <iostream>
using namespace std;

vector<int> solution(int n, vector<string> words) {
    vector<int> answer;
    int check_p = 0;
    int check_num = 0;
    bool sw = 0;
    char tmp = words[0][words[0].size() - 1];

    for (int i = 1; i < words.size(); i++) {
            if (tmp == words[i][0]) {
                for (int j = 0; j < i; j++) {
                    if (j != i) {
                        if (words[i] == words[j]) {
                            check_p = (i % n) + 1;
                            check_num = (i / n) + 1;
                            sw = 1;
                            break;
                        }
                    }
                }
            }
            else {
                check_p = (i % n) + 1;
                check_num = (i / n) + 1;
                sw = 1;
            }
            if (sw == 1) break;
            tmp = words[i][words[i].size() - 1];
        }

    if (sw == 1) {
        answer.push_back(check_p);
        answer.push_back(check_num);
    }
    else {
        answer.push_back(0);
        answer.push_back(0);
    }

    return answer;
}