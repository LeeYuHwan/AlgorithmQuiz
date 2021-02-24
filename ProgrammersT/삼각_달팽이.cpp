#include <string>
#include <vector>

using namespace std;

vector<int> solution(int n) {
    vector<int> answer;
    vector<vector<int>> v;

    int size = 0;
    for (int i = 0; i < n; i++) {
        vector<int> tmp;
        for (int j = 0; j < i + 1; j++) {
            tmp.push_back(0);
            size++;
        }
        v.push_back(tmp);
    }

    int h = 0, w = 0, sw = 0, count = 1;
    for (int i = 0; i < n; i++) {
        if (sw == 0) {
            for (int j = i; j < n; j++) {
                v[h][w] = count;
                h++;
                count++;
            }
            h--;
            w++;
            sw = 1;
        }
        else if (sw == 1) {
            for (int j = i; j < n; j++) {
                v[h][w] = count;
                w++;
                count++;
            }
            h--;
            w -= 2;
            sw = 2;
        }
        else if (sw == 2) {
            for (int j = i; j < n; j++) {
                v[h][w] = count;
                h--;
                w--;
                count++;
            }
            h += 2;
            w++;
            sw = 0;
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < i + 1; j++) {
            answer.push_back(v[i][j]);
        }
    }

    return answer;
}