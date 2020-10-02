#include<iostream>
#include<vector>
using namespace std;

int main(void)
{
	int n = 0;
	int m = 0;
	int n_max = 0;
	int m_max = 0;

	cin >> n >> m;

	int a = 0;
	for (int i = 0; i < n; i++) {
		cin >> a;
		if (n_max < a) n_max = a;
	}
	for (int i = 0; i < m; i++) {
		cin >> a;
		if (m_max < a) m_max = a;
	}

	cout << n_max + m_max;
}