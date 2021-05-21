#include <vector>
#include <string>
#include <map>
#include <algorithm>

using namespace std;

int solution(string str1, string str2) {
    string stru = "";
	map<string, int> m;
	map<string, int> m1;	
	map<string, int> m2;
	for (int i = 0; i < str1.length() - 1; i++) {
		if (65 <= toupper(str1[i]) && toupper(str1[i]) <= 90) {
			int idx = i;
			int cnt = 0;
			while (cnt < 2 && idx < str1.length()) {
				if (65 <= toupper(str1[idx]) && toupper(str1[idx]) <= 90) {
					stru += toupper(str1[idx]);
					cnt++;
				}
				else break;
				idx++;
			}
			if (cnt == 2) {
				m[stru]++;
				m1[stru]++;
			}		
			stru = "";
		}		
	}

	stru = "";
	for (int i = 0; i < str2.length() - 1; i++) {
		if (65 <= toupper(str2[i]) && toupper(str2[i]) <= 90) {
			int idx = i;
			int cnt = 0;
			while (cnt < 2 && idx < str2.length()) {
				if (65 <= toupper(str2[idx]) && toupper(str2[idx]) <= 90) {
					stru += toupper(str2[idx]);
					cnt++;
				}
				else break;
				idx++;
			}
			if (cnt == 2) {
				m[stru]++;
				m2[stru]++;
			}
			stru = "";
		}
	}

	map<string, int>::iterator iter;
 
	float cross = 0;
	float uni = 0;
	for (iter = m1.begin(); iter != m1.end(); iter++) {
		if (m2[iter->first] > 0) {
			cross += min(iter->second, m2[iter->first]);
		}
	}

	for (iter = m.begin(); iter != m.end(); iter++) {
		uni += max(m1[iter->first], m2[iter->first]);
	}
	float sum = cross / uni;
	if (cross == 0 && uni == 0) sum = 1;
	int answer = sum * 65536;
    return answer;
}