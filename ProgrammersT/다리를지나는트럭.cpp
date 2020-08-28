#include <string>
#include <queue>
#include <vector>

using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
   queue<int> trucks;

    for (int i = 0; i < truck_weights.size(); i++) {
        trucks.push(truck_weights[i]);
    }

    vector<pair<int, int>> inBridge;

    int answer = 1;
    int bridgeWeight = 0;

    while (1) {

        if (!trucks.empty() && bridgeWeight + trucks.front() <= weight) {
            inBridge.push_back({ trucks.front(), 0 });
            bridgeWeight += trucks.front();
            trucks.pop();
        }

        answer++;

        for (int i = 0; i < inBridge.size(); i++) {
            inBridge[i].second++;
        }

        if (inBridge[0].second == bridge_length) {
            bridgeWeight -= inBridge[0].first;
            inBridge.erase(inBridge.begin());
        }   

        if (inBridge.empty() && trucks.empty()) break;

    }
    return answer;
}