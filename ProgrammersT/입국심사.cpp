#include <string>
#include <vector>

using namespace std;

long long solution(int n, vector<int> times) {
    long long answer = 0;
    long left = 0;
    long right = 0;
    long mid;

    for (int time : times) {
        if (time > right) {
            right = time;
        }
    }

    right *= n;
    answer = right + 1;

    while (left <= right) {
        long done = 0;
        mid = (left + right) / 2;

        for (int time : times) {
            done += mid / time;
        }

        if (done < n) {
            left = mid + 1;
        }       
        else {
            if (mid < answer) {
                answer = mid;
            }

            right = mid - 1;        
        }
    }
    return answer;
}