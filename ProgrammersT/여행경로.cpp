#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int max_size = 0;
bool check = 0;
vector<string> re_answer;
void dfs(vector<string> answer, vector<pair<string, string>> ticket, string value, int i, int count) {
    if (ticket[i].second.compare("") != 0) {

        answer.push_back(value);
        ticket[i].second = "";
        count++;

        string tmp = ticket[i].first;
        ticket[i].first = "";

        if (count == max_size) {
            check = 1;
            answer.push_back(tmp);
            re_answer = answer;
        }

        if (check != 1) {
            for (int h = 0; h < ticket.size(); h++) {
                if (tmp.compare(ticket[h].second) == 0) dfs(answer, ticket, tmp, h, count);
            }
        }
    }
}

vector<string> solution(vector<vector<string>> tickets) {
    vector<pair<string, string>> ticket;
    vector<string> answer;

    for (int i = 0; i < tickets.size(); i++) {
        ticket.push_back(make_pair(tickets[i][1], tickets[i][0]));
    }

    sort(ticket.begin(), ticket.end());
    max_size = ticket.size();

    for (int i = 0; i < ticket.size(); i++) {
        if (ticket[i].second.compare("ICN") == 0) {
            dfs(answer, ticket, ticket[i].second, i, 0);
        }

        if (check != 1) {
            re_answer.clear();
        }
        else break;
    }
    return re_answer;
}