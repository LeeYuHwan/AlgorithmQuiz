#include<iostream>
#include <string>
#include<vector>
#include<queue>
#include<functional>
using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;
    int tmp = 0;

    priority_queue< long, vector<long>, greater<long> > pq;

    for (int i = 0; i < scoville.size(); i++) {
        pq.push(scoville[i]);
    }

    bool sw = false;
    while (!pq.empty()) {
        if (pq.top() < K) {
            tmp += pq.top();
            pq.pop();
            if (pq.empty()) {
                if (tmp >= K) sw = true;
                break;
            }

            tmp += pq.top() * 2;
            pq.pop();
            answer++;
            if (pq.empty()) {
                if (tmp >= K) sw = true;
                break;
            }

            pq.push(tmp);
        }
        else {
            sw = true;
            break;
        }

        tmp = 0;
    }
    if (sw == false) answer = -1;
    return answer;
}