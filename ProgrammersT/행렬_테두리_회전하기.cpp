#include <string>
#include <vector>

using namespace std;

vector<int> solution(int rows, int columns, vector<vector<int>> queries) {
    int value = 1;
    vector<vector<int>> arr(rows + 1, vector<int>(columns + 1, 0));
    for (int i = 1; i <= rows; i++) {
        for (int j = 1; j <= columns; j++) {
            arr[i][j] = value++;
        }
    }

    vector<int> answer;
    for (int i = 0; i < queries.size(); i++) {
        int h1 = queries[i][0], w1 = queries[i][1];
        int h2 = queries[i][0], w2 = queries[i][3];
        int h3 = queries[i][2], w3 = queries[i][3];
        int h4 = queries[i][2], w4 = queries[i][1];

        int min = rows * columns + 1;

        int last1 = arr[h2][w2];
        int old = arr[h1][w1];
        int old_tmp = 0;
        for (int j = w1; j < w2; j++) {
            if (min > old) min = old;
            old_tmp = arr[h1][j + 1];
            arr[h1][j + 1] = old;
            old = old_tmp;
        }
        for (int j = h2; j < h3; j++) {
            if (min > old) min = old;
            old_tmp = arr[j + 1][w2];
            arr[j + 1][w2] = old;
            old = old_tmp;
        }
        for (int j = w3; j > w4; j--) {
            if (min > old) min = old;
            old_tmp = arr[h4][j - 1];
            arr[h4][j - 1] = old;
            old = old_tmp;
        }
        for (int j = h4; j > h1; j--) {
            if (min > old) min = old;
            old_tmp = arr[j - 1][w4];
            arr[j - 1][w4] = old;
            old = old_tmp;
        }

        answer.push_back(min);
    }
    return answer;
}