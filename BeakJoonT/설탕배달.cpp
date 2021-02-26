#include <iostream>
#include <vector>
using namespace std;

int main()
{
	int n = 0;
	cin >> n;
	
	int answer = 0;

	while (1) {
		if (n % 5 == 0) {
			answer += n / 5;
			break;
		}

		n -= 3;
		answer++; 

		if (n < 0) {
			answer = -1;
			break;
		}
	}

	cout << answer;
}