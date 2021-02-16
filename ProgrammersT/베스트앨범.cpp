#include <string>
#include <vector>
#include <map>
#include <vector>
#include <queue>

using namespace std;

struct cmp {
    //연산자 오버로딩
    bool operator()(pair<int, int>& a, pair<int, int>& b) {
        if (a.first == b.first) {
            return a.second > b.second;
        }
        else {
            return a.first < b.first;
        }
    }
};

vector<int> solution(vector<string> genres, vector<int> plays) {
    vector<int> answer;
    map< string, int > m;
    map<string, priority_queue<pair<int, int>, vector<pair<int, int>>, cmp>> pqm;
    priority_queue<pair <int, string>> pq;
    for (int i = 0; i < genres.size(); i++) {
        m[genres[i]] += plays[i];
        pqm[genres[i]].push(make_pair(plays[i], i));
    }

    for (auto it = m.begin(); it != m.end(); it++) {
        pq.push(make_pair(it->second, it->first));
    }

    while (!pq.empty()) {
        int count = 0;
        while(!pqm[pq.top().second].empty() && count < 2) {
            answer.push_back(pqm[pq.top().second].top().second);
            pqm[pq.top().second].pop();
            count++;
        }
        pq.pop();
    }

    return answer;
}