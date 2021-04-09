#include <string>
#include <vector>
#include <queue>

using namespace std;

long long solution(int n, vector<int> works) {
    long long answer = 0;
    priority_queue<int> pq;
    int check = 0;

    for (int i = 0; i < works.size(); i++) {
        pq.push(works[i]);
        check += works[i];
    }

    if (check <= n) answer = 0;
    else {
        while (n > 0) {
            int tmp = pq.top() - 1;
            pq.pop();
            pq.push(tmp);
            n--;
        }
        while (!pq.empty()) {
            answer += pq.top() * pq.top();
            pq.pop();
        }
    }

    return answer;
}