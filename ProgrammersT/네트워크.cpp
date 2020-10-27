#include <string>
#include <vector>
using namespace std;
vector<bool> check;

void dfs(int idx,vector<vector<int>> computers) {
    check[idx] = true;

    for (int i = 0; i < computers.size(); i++) {
        if (idx != i && check[i] == false && computers[idx][i] == 1) {
            dfs(i, computers);
        }
    }
}

int solution(int n, vector<vector<int>> computers) {
    for (int i = 0; i < n; i++) {
        check.push_back(false);
    }
    int answer = 0;

    for (int i = 0; i < n; i++) {
        if (check[i] == false) {
            dfs(i ,computers);
            answer++;
        }
    }
    return answer;
}