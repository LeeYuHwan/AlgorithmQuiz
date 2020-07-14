function solution(a, b) {
    var day = ["SUN","MON","TUE","WED","THU","FRI","SAT"];
    var dayArray = [5,1,2,5,0,3,5,1,4,6,2,4];
    var start_day = dayArray[a - 1] + (b - 1);
    var answer = day[start_day % 7];
    return answer;
}