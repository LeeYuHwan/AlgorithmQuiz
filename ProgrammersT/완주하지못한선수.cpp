#include <string>
#include <vector>
#include <unordered_map>
using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    unordered_map<string, int> m;
    for (auto name : participant) {
		m[name]++;
	}
	for (auto name : completion) {
		m[name]--;
	}
	
	for (auto pair : m) {
		if (pair.second > 0)
			return pair.first;
	}
}