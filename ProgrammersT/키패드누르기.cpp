#include <string>
#include <vector>

using namespace std;

string solution(vector<int> numbers, string hand) {
    string answer = "";
    int left = 4, right = 4;
    bool left_check = 1, right_check = 1;
    vector<int> check = { 2, 5, 8, 0 }; 
    for (int i = 0; i < numbers.size(); i++) {
        if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
            answer += "L";
            left_check = 1;
            if (numbers[i] == 1) {
                left = 1;
            }
            else if (numbers[i] == 4) {
                left = 2;
            }
            else if (numbers[i] == 7) {
                left = 3;
            }
        }
        else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
            answer += "R";
            right_check = 1;
            if (numbers[i] == 3) {
                right = 1;
            }
            else if (numbers[i] == 6) {
                right = 2;
            }
            else if (numbers[i] == 9) {
                right = 3;
            }
        }
        else if (numbers[i] == 2 || numbers[i] == 5 || numbers[i] == 8 || numbers[i] == 0) {
                int l_c = 0, l_s = 0, l_tmp = 0;
            int r_c = 0, r_s = 0, r_tmp = 0;
            for (int j = left - 1; j < check.size(); j++) {
                l_c++;
                if (check[j] == numbers[i]) {
                    l_s = 1;
                    l_tmp = j + 1;
                    break;
                }
            }
            if (l_s != 1) {
                l_c = 0;
                for (int j = left - 1; j >= 0; j--) {
                    l_c++;
                    if (check[j] == numbers[i]) {
                        l_tmp = j + 1;
                        break;
                    }
                }
            }
            if (left_check == 1) l_c++;
            for (int j = right - 1; j < check.size(); j++) {
                r_c++;
                if (check[j] == numbers[i]) {
                    r_s = 1;
                    r_tmp = j + 1;
                    break;
                }
            }
            if (r_s != 1) {
                r_c = 0;
                for (int j = right - 1; j >= 0; j--) {
                    r_c++;
                    if (check[j] == numbers[i]) {
                        r_tmp = j + 1;
                        break;
                    }
                }
            }
            if (right_check == 1) r_c++;
            if (r_c < l_c) {
                answer += "R";
                right_check = 0;
                right = r_tmp;
            }
            else if (r_c > l_c) {
                answer += "L";
                left_check = 0;
                left = l_tmp;
            }
            else {
                if (hand.compare("right") == 0) {
                    answer += "R";
                    right_check = 0;
                    right = r_tmp;
                }
                else {
                    answer += "L";
                    left_check = 0;
                    left = l_tmp;
                }
            }

        }       
    }
    return answer;
}