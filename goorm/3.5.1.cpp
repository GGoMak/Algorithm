#include <iostream>

/*
 * 비타알고 2020년 3월 5주차 1번 : 온라인 강의(난이도 1)
 * 구현
 *
 * 구분자가 있는 정수입력의 경우 scanf를 이용하면 쉽게 받을 수 있음
 * 또한 시간 계산의 경우 시간, 분을 따로 계산하는 것이 아니라 분으로 통일하여 계산하면 간편하게 할 수 있음
*/

using namespace std;
int conHour, conMin;
int stuHour, stuMin;

int main(void){

    scanf("%d:%d", &conHour, &conMin);
    scanf("%d:%d", &stuHour, &stuMin);

    conMin += conHour * 60;
    stuMin += stuHour * 60;

    if(stuMin < conMin || stuMin >= conMin + 10){
        cout << 0;
    }
    else{
        cout << 1;
    }

    return 0;
}