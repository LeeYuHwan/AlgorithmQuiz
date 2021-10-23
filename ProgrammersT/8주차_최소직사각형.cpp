#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> sizes) {
    int answer = 0;

    int w = 0, h = 0;
    for (int i = 0; i < sizes.size(); i++) {
        int max = 0, min = 0;
        if (sizes[i][0] > sizes[i][1]) {
            max = sizes[i][0];
            min = sizes[i][1];
        }
        else {
            max = sizes[i][1];
            min = sizes[i][0];
        }

        if (max > w) w = max;
        if (min > h) h = min;
    }

    return w * h;
}