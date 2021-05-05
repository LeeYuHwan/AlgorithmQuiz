#include <iostream>
#include <vector>
#include <queue>
using namespace std;
int move_w[4] = { 0, 0, -1, 1 };
int move_h[4] = { -1, 1, 0, 0 };
int answer = 0;

void bfs(int h, int w, vector<vector<int>> board) {
    int cost[26][26] = { 0 };
    queue<pair<pair<int, int>, pair<int, int>>> q;
    q.push(make_pair(make_pair(h, w), make_pair(-1,0)));

    while (!q.empty()) {
        int h = q.front().first.first;
        int w = q.front().first.second;
        int loc = q.front().second.first;
        int oldCost = q.front().second.second;
        q.pop();

        for (int i = 0; i < 4; i++) {
            int tmp_w = w + move_w[i];
            int tmp_h = h + move_h[i];
            int nextCost = oldCost;
            if (tmp_w >= 0 && tmp_h >= 0 && tmp_w < board[0].size() && tmp_h < board.size() && board[tmp_h][tmp_w] == 0) {
                if (loc == i || (h == 0 && w == 0)) nextCost += 100;
                else nextCost += 600;

                if (cost[tmp_h][tmp_w] == 0 || cost[tmp_h][tmp_w] >= nextCost) {
                    //cout << "sda" << endl;
                    q.push(make_pair(make_pair(tmp_h, tmp_w), make_pair(i, nextCost)));
                    cost[tmp_h][tmp_w] = nextCost;
                }

            }
        }
    }

    answer = cost[board.size() - 1][board[0].size() - 1];
}

int solution(vector<vector<int>> board) {
    bfs(0, 0, board);
    return answer;
}