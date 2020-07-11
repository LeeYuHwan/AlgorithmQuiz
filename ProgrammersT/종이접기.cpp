#include <string>
#include <vector>
#include <cmath>
using namespace std;

vector<int> solution(int n) {
    vector<int> answer(pow(2, n) - 1);

    int start = 0;
    int tmp = 1;
    int add = 2;
    int value = 0;
    int size = (pow(2, n) - 1) / 2 + 1;
    int count = 0;

    if (n > 1) {
        for (int i = 0; i < n; i++) {
            for (int j = start; count < size; j += add) {
                answer[j] = value;
                value++;
                value %= 2;
                count++;
            }
            if (i == 0) start = 1;
            else {
                tmp *= 2;
                start += tmp;
            }
            add *= 2;
            size /= 2;
            count = 0;
        }
    }
    return answer;
}