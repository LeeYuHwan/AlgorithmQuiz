#include<iostream>
#include<vector>
using namespace std;

int main(void)
{
	int n = 0, m = 0;
	string s = "";

	cin >> n >> m;

	cin >> s;

	int start = 0;
	vector<bool> check_v;
	bool check = false;
	string s_tmp = "";
	for (int z = 0; z < m; z++) {
		cin >> s_tmp;
		for (int i = 0; i < n; i++) {		
			for (int j = start; j < s_tmp.length(); j++) {			
				if (s[i] == s_tmp[j]) {
					if (j == s_tmp.length() - 1)
						start = j;
					else
						start = j + 1;
					check = true;
					break;
				}
				else check = false;
			}
			if (check == false) break;
		}
		check_v.push_back(check);
		check = false;
		start = 0;
	}

	for (int i = 0; i < check_v.size(); i++) {
		if (check_v[i] == true)
			cout << "true";
		else
			cout << "false";
		cout << endl;
	}
}