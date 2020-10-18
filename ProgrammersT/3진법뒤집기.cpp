#include <string>
#include <cmath>
using namespace std;

int solution(int n) {
    int answer = 0;
    string tmp = "";
    int num = 0;

    while (n >= 3) {
        num = n % 3;
        n /= 3;

        tmp = to_string(num) + tmp;
    }

    tmp = to_string(n) + tmp;

    for (int i = 0; i < tmp.length(); i++) {
        answer += (tmp[i] - '0') * pow(3, i);
    }
    return answer;
}