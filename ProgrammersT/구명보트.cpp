#include <string>
#include <vector>
#include<algorithm>
using namespace std;

int solution(vector<int> people, int limit) {

    sort(people.begin(), people.end());
    int answer = 0;
    int count = 0;
    int firstIdx = 0;
    int lastIdx = people.size() - 1;
    while (count < people.size()) {
        if (count < people.size() - 1) {
            if (people[firstIdx] + people[lastIdx] <= limit) {              
                firstIdx++;
                lastIdx--;
                answer++;
                count += 2;
            }
            else {
                lastIdx--;
                answer++;
                count++;
            }
        }
        else {
            answer++;
            count++;
        }
    }

    return answer;
}