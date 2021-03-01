#include <string>
#include <vector>

using namespace std;

vector<int> answer(2);
vector<vector<int>> arrT;

void dfs(int h, int w, int size) {

    bool sw0 = true, sw1 = true;
    for (int i = h; i < h + size; i++) {
        for (int j = w; j < w + size; j++) {
            if (arrT[i][j] == 0) sw1 = false;
            else if (arrT[i][j] == 1) sw0 = false;
        }
    }

    if (sw0) {
        answer[0]++;
        return;
    }
    if (sw1) {
        answer[1]++;
        return;
    }

    size /= 2;
    dfs(h, w, size);
    dfs(h, w + size, size);
    dfs(h + size, w, size);
    dfs(h + size, w + size, size);
}

vector<int> solution(vector<vector<int>> arr) {

    arrT = arr;
    dfs(0, 0, arr.size());

    return answer;
}