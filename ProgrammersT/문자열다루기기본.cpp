#include <string>
#include <vector>

using namespace std;

bool solution(string s) {
    bool answer = false;
    if(s.size() == 4 || s.size() == 6) {
         for(int i = 0 ; i < s.size() ; i++) {
             if(s[i] >= 48 && s[i] <=57) answer = true;
             else {
                 answer = false;
                 return answer;
             }
        }
        return answer;   
    }
    else {
        return answer;
    }
}