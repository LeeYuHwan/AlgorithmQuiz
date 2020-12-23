#include <iostream>
#include <string>
#include <vector>
#include <queue>

using namespace std;
vector<vector<int>> g;
vector<int> check;
queue <int> q;

void bfs() {    
    while (!q.empty()) {
        int node = q.front();
        q.pop();

        for (int i = 0; i < g.size(); i++) {
            if (g[node][i] == 1 && check[i] == -1) {
                q.push(i);
                check[i] = check[node] + 1;
            }
        }
    }
}

int solution(int n, vector<vector<int>> edge) {
    for (int i = 0; i < n; i++) {
        vector<int> tmp(n);
        g.push_back(tmp);
        check.push_back(-1);
    }

    for (int i = 0; i < edge.size(); i++) {
        g[edge[i][0] - 1][edge[i][1] - 1] = 1;
        g[edge[i][1] - 1][edge[i][0] - 1] = 1;
    }

    q.push(0);
    check[0] = 0;
    bfs();

    int answer = 0;
    int max = -1;
    for (int i = 0; i < check.size(); i++) {
        if (max < check[i]) {
            max = check[i];
            answer = 1;
        }
        else if (max == check[i]) answer++;
    }

    return answer;
}