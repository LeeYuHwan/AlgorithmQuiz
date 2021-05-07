#include <string>
#include <vector>
#include <map>

using namespace std;

vector<int> solution(vector<string> gems) {
    map<string, int> m;

    for (int i = 0; i < gems.size(); i++) {
        m[gems[i]] = 1;
    }

    int sum = m.size();
    m.clear();
    vector<int> answer = {1, (int)gems.size()};
    int start = 0, end = 0;
    int dist = gems.size() - 1;

    while (true) {
        if (m.size() == sum) {
            if (end - start < dist) {
                dist = end - start;
                answer[0] = start + 1;
                answer[1] = end;
            }
            if (m[gems[start]] == 1) {
                m.erase(gems[start]);
                start++;
            }
            else {
                m[gems[start]]--;
                start++;
            }
        }
        else if (end == gems.size()) break;         
        else {      
            m[gems[end]]++;
            end++;
        }
    }
    return answer;
}