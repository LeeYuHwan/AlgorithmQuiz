#include <iostream>
using namespace std;

int main()
{
	int t = 0;
	int n = 0, m = 0;
	int a = 0, b = 0;

	cin >> t;
	for (int i = 0; i < t; i++) {
		cin >> n >> m;
		
		for (int j = 0; j < m; j++) {
			cin >> a >> b;
		}
		cout << n - 1 << endl;
	}
}