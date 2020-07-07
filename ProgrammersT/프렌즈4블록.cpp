#include <string>
#include <vector>

using namespace std;

int solution(int m, int n, vector<string> board) {
    int tmp = 0;
    int answer = 0;
    int f_count = 0;
    int t_count = 0;
    while (1) {
        f_count = 0;
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {           
                if (x < n - 1 && y < m - 1) {
                    if (board[y][x] == board[y][x + 1] && board[y][x] == board[y + 1][x]
                        && board[y][x] == board[y + 1][x + 1]) {
                        if (board[y][x] >= 65) {
                            answer += 4;
                            board[y][x] -= '0';
                            board[y][x + 1] -= '0';
                            board[y + 1][x] -= '0';
                            board[y + 1][x + 1] -= '0';
                            f_count++;
                        }
                    }
                    else if (board[y][x] + '0' == board[y][x + 1] && board[y][x] + '0' == board[y + 1][x]
                        && board[y][x] + '0' == board[y + 1][x + 1]) {
                        answer += 3;
                        board[y][x + 1] -= '0';
                        board[y + 1][x] -= '0';
                        board[y + 1][x + 1] -= '0';
                        f_count++;
                    }
                    else if (board[y][x] + '0' == board[y][x + 1] && board[y][x] == board[y + 1][x]
                        && board[y][x] + '0' == board[y + 1][x + 1]) {
                        answer += 2;
                        board[y][x + 1] -= '0';
                        board[y + 1][x + 1] -= '0';
                        f_count++;
                    }
                    else if (board[y][x] == board[y][x + 1] && board[y][x] + '0' == board[y + 1][x]
                        && board[y][x] + '0' == board[y + 1][x + 1]) {
                        answer += 2;
                        board[y + 1][x] -= '0';
                        board[y + 1][x + 1] -= '0';
                        f_count++;
                    }
                    else if (board[y][x] + '0' == board[y][x + 1] && board[y][x] + '0' == board[y + 1][x]
                        && board[y][x] == board[y + 1][x + 1]) {
                        answer += 2;
                        board[y][x + 1] -= '0';
                        board[y + 1][x] -= '0';
                        f_count++;
                    }

                }
            }
        }

        while (1) {
            t_count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i < m - 1) {
                        if (board[i][j] >= 65) {
                            if (board[i + 1][j] < 65) {
                                board[i + 1][j] = board[i][j];
                                board[i][j] = 1;
                                t_count++;
                            }
                        }
                    }

                }
            }

            if (t_count == 0) break;
        }
        if (f_count == 0) break;

    }
    return answer;
}