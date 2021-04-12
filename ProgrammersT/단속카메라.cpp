#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<vector<int>> routes) {
    sort(routes.begin(), routes.end());

    int answer = 1;
    int check = routes[0][1];
    for (int i = 0; i < routes.size(); i++) {
        if (check < routes[i][0]) {
            answer++;
            check = routes[i][1];
        }
        else {
            if (check > routes[i][1]) check = routes[i][1];
        }
    }
    return answer;
}
