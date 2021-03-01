#include <string>
#include <vector>

using namespace std;

string toBinary(int num){
    string reStr = "";
    int num2, b, mok, nmg, i;
    vector<int> a;

    num2 = num;
    b = -1;

    do {
        b++;
        mok = num / 2;
        nmg = num - mok * 2;
        a.push_back(nmg);
        num = mok;
    } while (mok != 0);
    for (i = b; i >= 0; i--) {
        reStr += a[i] + 48;
     }

    return reStr;
}

vector<int> solution(string s) {
    int zeroCount = 0;
    int count = 0;
    vector<int> answer;
    string tmpStr = "";

    while (tmpStr != "1") {
        tmpStr = "";
        for (int i = 0; i < s.length(); i++) {
            if (s[i] != '0') {
                tmpStr += s[i];
            }
            else zeroCount++;
        }

        s = toBinary(tmpStr.length());
        count++;
    }

    answer.push_back(count);
    answer.push_back(zeroCount);

    return answer;
}