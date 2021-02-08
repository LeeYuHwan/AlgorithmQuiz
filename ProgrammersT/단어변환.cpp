#include <string>
#include <vector>
using namespace std;
string targetT = "";
int answer = 0;

void dfs(int idx, vector<string> words, vector<bool> check, int cnt) {
    if (check[idx] == false) {
        check[idx] = true;
        cnt++;

        if (words[idx].compare(targetT) == 0) {
            answer = cnt;
            return;
        }

        for (int i = 0; i < words.size(); i++) {
            int count = 0;
            for (int j = 0; j < words[i].length(); j++) {
                if (words[idx][j] == words[i][j]) count++;
            }

            if (count == words[i].length() - 1) {
                dfs(i, words, check, cnt);
            }
        }
    }   
}

int solution(string begin, string target, vector<string> words) {
    vector<bool> check(words.size(), false);
    targetT = target;
    int startIdx = 0;
    for (int i = 0; i < words.size(); i++) {
        int count = 0;
        for (int j = 0; j < words[i].length(); j++) {
            if (begin[j] == words[i][j]) count++;
        }

        if (count == words[i].length() - 1) {
            startIdx = i;           
            break;
        }
    }

    dfs(startIdx, words, check, 0);
    return answer;
}