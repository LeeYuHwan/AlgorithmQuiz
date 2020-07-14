function solution(d, budget) {
    d.sort((a,b)=>a-b);

    var answer = 0;
    for(var i = 0; i < d.length; i++){
        if(budget - d[i] >= 0) {
            answer++;
            budget -= d[i];
        }
        else break;
    }
    return answer;
}