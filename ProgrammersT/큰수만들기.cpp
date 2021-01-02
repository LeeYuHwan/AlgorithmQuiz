#include <string>
#include <vector>

using namespace std;

string solution(string number, int k) {
    string oldNumber = number;
    string answer = "";

    int i = 0;
    bool sw = 0;
    while (i < number.length()) {
        int max = number[i] - 48;
        sw = 0;

        for (int j = 0; j <= k; j++) {
            //cout << "no" << max << endl;
            if (j < number.length()) {
                if (max < number[j] - 48) {
                    sw = 1;
                    number.erase(0, 1);
                    k--;
                    break;
                }
            }       
        }
        i++;

        if (sw == 1) i = 0;
        else {
            i--;
            answer += number[i];
            number.erase(0, 1);
            i = 0;
        }
    }

    if (answer == oldNumber) {
        answer = oldNumber.substr(k - 1, oldNumber.length() - k);
    }

    return answer;
}