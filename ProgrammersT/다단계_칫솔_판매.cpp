#include <string>
#include <vector>
#include <map>
using namespace std;

vector<int> solution(vector<string> enroll, vector<string> referral, vector<string> seller, vector<int> amount) {
    map<string, string> m;
    map<string, int> idxM;
    for (int i = 0; i < enroll.size(); i++) {
        idxM[enroll[i]] = i;
        m[enroll[i]] = referral[i];
    }

    vector<int> answer(enroll.size());
    for (int i = 0; i < seller.size(); i++) {
        string person = seller[i];
        int money = amount[i] * 100;
        int pay = money / 10;
        money -= pay;
        while (person != "-") {
            answer[idxM[person]] += money;

            money = pay;
            pay = money / 10;
            money -= pay;

            person = m[person];
        }
    }
    return answer;
}