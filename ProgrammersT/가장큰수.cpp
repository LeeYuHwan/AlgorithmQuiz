#include<iostream>
#include<vector>
#include<algorithm>
#include<string>
using namespace std;

bool check(string& a, string& b) {
    return a + b > b + a;
}

string solution(vector<int> numbers) {
    vector<string> answer_tmp;
    string answer = "";

    for (int i = 0; i < numbers.size(); i++) {
        answer_tmp.push_back(to_string(numbers[i]));
    }

    sort(answer_tmp.begin(), answer_tmp.end(), check);

    for (int i = 0; i < answer_tmp.size(); i++) {
        answer += answer_tmp[i];
    }
    if(answer[0] == '0') answer = "0";
    return answer;
}