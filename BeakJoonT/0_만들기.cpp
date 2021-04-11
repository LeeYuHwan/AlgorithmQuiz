#include <iostream>
#include <string>
#include <vector>
using namespace std;
int N = 0;

void dfs(int idx, int sum, int pre, string answer, vector<int>& numbers) {

	if (idx == N) {
		if (sum == 0) {
			cout << answer << '\n';
		}
		return;
	}

	if (pre == 1) dfs(idx + 1, sum + numbers[idx - 1] + (-1 * ((numbers[idx - 1] * 10) + (numbers[idx]))), 4, answer + ' ' + to_string(numbers[idx]), numbers);
	if(pre == 2) dfs(idx + 1, sum - numbers[idx - 1] + ((numbers[idx - 1] * 10) + (numbers[idx])), 4, answer + ' ' + to_string(numbers[idx]), numbers);
	if(pre == 3) dfs(idx + 1, ((numbers[idx - 1] * 10) + (numbers[idx])), 4, answer + ' ' + to_string(numbers[idx]), numbers);		
	dfs(idx + 1, sum + numbers[idx], 2, answer + '+' + to_string(numbers[idx]), numbers);
	dfs(idx + 1, sum - numbers[idx], 1, answer + '-' + to_string(numbers[idx]), numbers);

}

int main()
{
	ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);
	
	int t = 0;
	cin >> t;
	
	
	for (int test = 0; test < t; test++) {
		cin >> N;
		vector<int> numbers;
		for (int i = 1; i <= N; i++) {
			numbers.push_back(i);
		}
		dfs(1, 1, 3, "1", numbers);
		
		cout << '\n';	
	}
}