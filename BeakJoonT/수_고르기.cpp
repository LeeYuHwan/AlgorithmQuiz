#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	int answer = 2000000001;
	int n = 0, m = 0;
	int arr[100001];
	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		int n = 0;
		cin >> n;
		arr[i] = n;
	}

	sort(arr, arr + n);
	int i = 0, j = 1;

	while (i < n && j < n) {
		if ((arr[j] - arr[i]) >= m) {
			if (arr[j] - arr[i] == m) {
				answer = m;
				break;
			}

			if (answer > (arr[j] - arr[i])) {
				answer = arr[j] - arr[i];
			}
			i++;
		}
		else if ((arr[j] - arr[i]) < m) {
			j++;
		}		
	}

	cout << answer;
}