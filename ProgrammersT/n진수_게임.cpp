#include <vector>
#include <string>
using namespace std;

string convertion(int num, int notation) {
    string res = "";
    int mok = num;
    int nmg = 0;

    while (mok >= notation) {
        nmg = mok % notation;
        mok /= notation;

        // 10진법보다 크고 나머지가 10 이상인 경우
        if (notation > 10 && nmg >= 10) {
            res = (char)(nmg + 55) + res;
        }
        else {
            res = to_string(nmg) + res;
        }
    }

    if (notation > 10 && mok >= 10) {
        res = (char)(mok + 55) + res;
    }
    else {
        res = to_string(mok) + res;
    }

    return res;
}

string solution(int n, int t, int m, int p) {
    string num = "";
    for (int i = 0; i <= (t * m); i++) {
        num += convertion(i, n);
    }

    string answer = "";
    for (int i = 0; i <= num.length(); i++) {
        if ((i % m) == (p - 1)) answer += num[i];
        if (answer.length() == t) break;
    }

    return answer;
}