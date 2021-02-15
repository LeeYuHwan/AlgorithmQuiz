#include <vector>
#include <queue>
using namespace std;

vector<vector<int>> pictureT;
int number_of_area = 0;
int max_size_of_one_area = 0;
int move_w[4] = { 0, 0, -1, 1 };
int move_h[4] = { -1, 1, 0, 0 };

void bfs(int m, int n, int h, int w, int value) {
    queue<pair<int, int>> q;
    q.push(make_pair(h, w));
    int maxTmp = 0;

    while (!q.empty()) {
        int h = q.front().first;
        int w = q.front().second;
        q.pop();
        for (int i = 0; i < 4; i++) {
            int tmp_w = w + move_w[i];
            int tmp_h = h + move_h[i];
            if (tmp_w >= 0 && tmp_h >= 0 && tmp_w < n && tmp_h < m) {
                if (pictureT[tmp_h][tmp_w] == value) {
                    maxTmp++;
                    pictureT[tmp_h][tmp_w] = 0;
                    q.push(make_pair(tmp_h, tmp_w));
                }
            }
        }


    }

    if (max_size_of_one_area < maxTmp) max_size_of_one_area = maxTmp;
}

// 전역 변수를 정의할 경우 함수 내에 초기화 코드를 꼭 작성해주세요.
vector<int> solution(int m, int n, vector<vector<int>> picture) {
    max_size_of_one_area = 0;
    number_of_area = 0;
    pictureT = picture;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (pictureT[i][j] != 0) {
                bfs(m, n, i, j, pictureT[i][j]);
                number_of_area++;
            }
        }
    }

    vector<int> answer(2);
    answer[0] = number_of_area;
    answer[1] = max_size_of_one_area;
    return answer;
}