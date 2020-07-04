#include <string>
using namespace std;

int solution(string dirs) {
    int box[21][21] = { {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0}, 
                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
    int answer = 0;
    int count = 0;
    int x = 10, y = 10;

    for (int i = 0; i < dirs.size(); i++) {
        if (dirs[i] == 'U') {
            for (int i = 0; i < 2; i++) {
                if (x > 0) {
                    x--;
                    if (box[x][y] == 0) {
                        box[x][y] = 1;
                        count++;
                    }
                }
            }
            if (count >= 1) answer++;
        }
        else if (dirs[i] == 'D') {
            for (int i = 0; i < 2; i++) {
                if (x < 20) {
                    x++;
                    if (box[x][y] == 0) {
                        box[x][y] = 1;
                        count++;
                    }
                }
            }
            if (count >= 1) answer++;
        }
        else if (dirs[i] == 'R') {
            for (int i = 0; i < 2; i++) {
                if (y < 20) {
                    y++;
                    if (box[x][y] == 0) {
                        box[x][y] = 1;
                        count++;
                    }
                }
            }
            if (count >= 1) answer++;
        }
        else if (dirs[i] == 'L') {
            for (int i = 0; i < 2; i++) {
                if (y > 0) {
                    y--;
                    if (box[x][y] == 0) {
                        box[x][y] = 1;
                        count++;
                    }
                }
            }
            if (count >= 1) answer++;       
        }
        count = 0;
    }
    return answer;
}