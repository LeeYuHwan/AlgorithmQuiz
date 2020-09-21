#include <iostream>
#include <vector>
using namespace std;
int n = 0;
vector<int> s;
bool answer[20 * 100000];

void check(int index, int sum) {
	if (index == n) {
		answer[sum] = true;
		return;
	}

	check(index + 1, sum + s[index]);
	check(index + 1, sum);
}

int main() {
	

	cin >> n;

	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		s.push_back(a);
	}

	check(0, 0);

	for (int i = 0; i < 20 * 100000; i++) {
		if (answer[i] == false) {
			cout << i;
			break;
		}
	}
}