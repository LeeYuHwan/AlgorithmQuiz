#include<iostream>
#include<vector>
using namespace std;

int main(void)
{
	int n = 0;
	int a = 0, b = 0;
	int max = 0;
	int jinseo = 0;
	string answer = "";
	int tmp = 0;
	
	cin >> n >> a >> b;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> tmp;
			if (i != a - 1 && j == b - 1) {
				if (max < tmp) max = tmp;
			}
			else if (i == a - 1 && j != b - 1) {
				if (max < tmp) max = tmp;
			}
			else if (i == a - 1 && j == b - 1) {
				jinseo = tmp;
			}
		}
	}

	if (jinseo >= max) answer = "HAPPY";
	else answer = "ANGRY";

	cout << answer;
}