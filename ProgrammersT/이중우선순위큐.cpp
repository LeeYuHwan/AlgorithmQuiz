#include <string>
#include <vector>
#include <queue>
using namespace std;

vector<int> solution(vector<string> operations) {
    vector<int> answer;
    priority_queue<int, vector<int>, less<int> > q;

    for (int i = 0; i < operations.size(); i++) {
        if (operations[i][0] == 'I') {
            operations[i].erase(0, 2);
            q.push(stoi(operations[i]));
        }
        else {
            if (!q.empty()) {
                if (operations[i][2] == '-') {
                    vector<int> tmp;

                    if (q.size() == 1) {                    
                        q.pop();
                    }
                    else {
                        while (1) {
                            tmp.push_back(q.top());
                            q.pop();
                            if (q.size() == 1) {
                                q.pop();
                                break;
                            }
                        }
                    }

                    for (int i = 0; i < tmp.size(); i++) {
                        q.push(tmp[i]);
                    }
                }
                else {
                    q.pop();
                }
            }       
        }

    }

    if (q.empty()) {
        answer.push_back(0);
        answer.push_back(0);
    }
    else {
        answer.push_back(q.top());
        while (1) {
            if (q.size() == 1) {
                answer.push_back(q.top());
                break;
            }
            q.pop();            
        }
    }
    return answer;
}