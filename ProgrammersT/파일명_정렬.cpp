#include <vector>
#include <string>
#include <algorithm>
using namespace std;

bool cmp(pair<pair<string, int>, int>a, pair<pair<string, int>, int>b) {
    if (a.first.first == b.first.first) return a.first.second < b.first.second;
    else return a.first.first < b.first.first;
}

vector<string> solution(vector<string> files) {
    vector<pair<pair<string, int>, int>> v;
    for (int i = 0; i < files.size(); i++) {
        string head = "", num = "";
        bool hs = false, ns = false, zero = false;
        int nSize = 0;
        for (int j = 0; j < files[i].length(); j++) {
            if (files[i][j] >= 48 && files[i][j] <= 57) {
                hs = true;
                if (files[i][j] > 48) zero = true;
                if (!ns && zero && nSize < 5) {
                    num += files[i][j];
                }       
                nSize++;
            }
            else {
                if (!hs) head += toupper(files[i][j]);
                if (hs) ns = true;
            }
        }
        if (num == "") num = "0";
        v.push_back(make_pair(make_pair(head, stoi(num)), i));
    }

    stable_sort(v.begin(), v.end(), cmp);

    vector<string> answer;
    for (int i = 0; i < v.size(); i++) {
        answer.push_back(files[v[i].second]);
    }
    return answer;
}