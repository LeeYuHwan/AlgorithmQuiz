#include <iostream>
#include <stdio.h>
#include <string>
#include <vector>
#include<algorithm>
using namespace std;

int solution(vector<int> d, int budget) {
    sort(d.begin(), d.end());
    int count = 0;
    int budget1 = 0;
    for(int i=0; i<d.size(); i++){


        budget -= d[i];
       if(budget >= 0){ 
        count++;
       }

    }
return count;
}