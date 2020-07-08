#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
	int numSet[1000000] = {0};

	for (int i = 2; i <= n; i++) {
		if (numSet[i] == 0) {
			answer++;
			for (int j = 1; i * j <= n; j++) {
				numSet[i * j] = 1;
			}
		}
	}

    return answer;
}