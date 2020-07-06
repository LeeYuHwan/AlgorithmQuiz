#include<iostream>
using namespace std;

int main() {
	int T = 0;

	cin >> T;
	
	int *answer = new int[T];
	int one = 0;
	int two = 0;

	for (int i = 0; i < T; i++) {
		cin >> one;
		cin >> two;

		if (one == 1) {
			one = 5000000;
		}
		else if (one <= 3 && one > 1) {
			one = 3000000;
		}
		else if (one <= 6 && one > 3) {
			one = 2000000;
		}
		else if (one <= 10 && one > 6) {
			one = 500000;
		}
		else if (one <= 15 && one > 10) {
			one = 300000;
		}
		else if (one <= 21 && one > 15) {
			one = 100000;
		}
		else one = 0;

		if (two == 1) {
			two = 5120000;
		}
		else if (two <= 3 && two > 1) {
			two = 2560000;
		}
		else if (two <= 7 && two > 3) {
			two = 1280000;
		}
		else if (two <= 15 && two > 7) {
			two = 640000;
		}
		else if (two <= 31 && two > 15) {
			two = 320000;
		}
		else two = 0;
		answer[i] = one + two;
	}

	for (int i = 0; i < T; i++) {
		cout << answer[i] << endl;
	}

	delete[] answer;
}