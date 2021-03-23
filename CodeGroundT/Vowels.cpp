#include <iostream>
using namespace std;
int main(int argc, char** argv)
{
	int T, test_case;
	
	cin >> T;
	for (test_case = 0; test_case < T; test_case++)
	{		
		int N = 0;
		cin >> N;		
		string terms = "eiou";
		
		string ques = "";
		cin >> ques;

		int min = 1001;
		int start = 0;
		int end = 0;
		for (int i = 0; i < N; i++) {
			int count = 1;
			if (ques[i] == 'a') {			
				int termsIdx = 0;
				for (int j = i; j < N; j++) {
					if (ques[j] == terms[termsIdx]) {
						termsIdx++;
					}
					
					count++;
					if (termsIdx == 4) {
						if (min > count) {
							min = count;
							start = i + 1;
							end = j + 1;
						}						
					}
				}
			}						
		}

		cout << "Case #" << test_case + 1 << endl;
		if (start == 0 && end == 0) cout << -1 << " " << -1 << endl;
		else cout << start << " " << end << endl;	
	}

	return 0;
}