#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;

    vector<int> rect(n + 1);

    rect[1] = 1;
    rect[2] = 2;

    for (int i = 3; i <= n; i++) {
        rect[i] = (rect[i - 1] + rect[i - 2]) % 1000000007;
    }

    answer = rect[n] % 1000000007;
    return answer;
}