#include <iostream>
#include <string>
#include <vector>
#include<algorithm>
using namespace std;

int solution(string s)
{
    int answer = 1;
    int tmpSize = s.size();
    while (tmpSize >= 2) {
        for (int i = 0; i <= s.size() - tmpSize; i++) {

            int firstIdx = i;
            int lastIdx = tmpSize + i - 1;
            bool sw = true;

            while (firstIdx <= lastIdx) {
                if (s[firstIdx] != s[lastIdx]) {
                    sw = false;
                    break;
                }
                firstIdx++;
                lastIdx--;
            }

            if (sw) return tmpSize;
        }
        tmpSize--;
    }
    return answer;
}