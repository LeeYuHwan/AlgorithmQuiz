#include <vector>
#include <string>
#include <map>
#include <algorithm>
using namespace std;

bool cmp(const pair<int, int>& a, const pair<int, int>& b) {
    if (a.second == b.second) return a.first < b.first;
    return a.second < b.second;
}

vector<int> solution(string s) {
    vector<int> answer;
    vector<vector<int>> num(501);
    map<int, int> m;

    bool sw = false;
    string numTmp = "";
    int maxSize = 0;
    int size = 0;
    vector<int> tmp;
    for (int i = 1; i < s.length() - 1; i++) {  
        if (s[i] == '{') {
            sw = true;
        }
        else if (s[i] == '}') {
            tmp.push_back(stoi(numTmp));
            size++;
            numTmp = "";

            for (int j = 0; j < tmp.size(); j++) {
                num[size].push_back(tmp[j]);
            }
            maxSize++;
            tmp.clear();
            size = 0;

            sw = false;     
        }

        if (sw) {
            if (s[i] == ',') {
                tmp.push_back(stoi(numTmp));
                size++;
                numTmp = "";
            }
            else if (s[i] != '{' && s[i] != ','){
                numTmp += s[i];             
            }           
        }
    }

    for (int i = 1; i <= maxSize; i++) {
        for (int j = 0; j < num[i].size(); j++) {
            if (m[num[i][j]] == 0) {
                m[num[i][j]] = i;
            }           
        }
    }

    vector<pair<int, int>> vec(m.begin(), m.end());
    sort(vec.begin(), vec.end(), cmp);

    for (auto num : vec) {
        answer.push_back(num.first);
    }

    return answer;
}