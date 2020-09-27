#include <iostream>
#include <vector>
#include <algorithm>

/*
 * 백준 5373번 : 큐빙(36%)
 * 구현
 */

using namespace std;
int T;
char cube[6][3][3];

void rotate(int index, string r){

    char tmp[3][3];

    for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++){
            tmp[i][j] = cube[index][i][j];
        }
    }

    if(r == "+"){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                cube[index][j][3 - i - 1] = tmp[i][j];
            }
        }
    }
    else{
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                cube[index][3 - j - 1][i] = tmp[i][j];
            }
        }
    }
}

void turn(string s){

    char tmp[3];

    if(s == "F+"){
        rotate(1, "+");
        for(int i = 0; i < 3; i++) tmp[i] = cube[4][2][i];
        for(int i = 0; i < 3; i++) cube[4][2][i] = cube[0][2 - i][2];
        for(int i = 0; i < 3; i++) cube[0][2-i][2] = cube[5][0][2-i];
        for(int i = 0; i < 3; i++) cube[5][0][2-i] = cube[2][i][0];
        for(int i = 0; i < 3; i++) cube[2][i][0] = tmp[i];
    }
    else if(s == "F-") {
        rotate(1, "-");
        for (int i = 0; i < 3; i++) tmp[i] = cube[4][2][i];
        for (int i = 0; i < 3; i++) cube[4][2][i] = cube[2][i][0];
        for (int i = 0; i < 3; i++) cube[2][i][0] = cube[5][0][2-i];
        for (int i = 0; i < 3; i++) cube[5][0][2-i] = cube[0][2-i][2];
        for (int i = 0; i < 3; i++) cube[0][2-i][2] = tmp[i];
    }
    else if(s == "L+"){
        rotate(0, "+");
        for(int i = 0; i < 3; i++) tmp[i] = cube[1][i][0];
        for(int i = 0; i < 3; i++) cube[1][i][0] = cube[4][i][0];
        for(int i = 0; i < 3; i++) cube[4][i][0] = cube[3][2-i][2];
        for(int i = 0; i < 3; i++) cube[3][2-i][2] = cube[5][i][0];
        for(int i = 0; i < 3; i++) cube[5][i][0] = tmp[i];
    }
    else if(s == "L-"){
        rotate(0, "-");
        for(int i = 0; i < 3; i++) tmp[i] = cube[1][i][0];
        for(int i = 0; i < 3; i++) cube[1][i][0] = cube[5][i][0];
        for(int i = 0; i < 3; i++) cube[5][i][0] = cube[3][2-i][2];
        for(int i = 0; i < 3; i++) cube[3][2-i][2] = cube[4][i][0];
        for(int i = 0; i < 3; i++) cube[4][i][0] = tmp[i];
    }
    else if(s == "R+"){
        rotate(2, "+");
        for(int i = 0; i < 3; i++) tmp[i] = cube[1][i][2];
        for(int i = 0; i < 3; i++) cube[1][i][2] = cube[5][i][2];
        for(int i = 0; i < 3; i++) cube[5][i][2] = cube[3][2-i][0];
        for(int i = 0; i < 3; i++) cube[3][2-i][0] = cube[4][i][2];
        for(int i = 0; i < 3; i++) cube[4][i][2] = tmp[i];
    }
    else if(s == "R-"){
        rotate(2, "-");
        for(int i = 0; i < 3; i++) tmp[i] = cube[1][i][2];
        for(int i = 0; i < 3; i++) cube[1][i][2] = cube[4][i][2];
        for(int i = 0; i < 3; i++) cube[4][i][2] = cube[3][2-i][0];
        for(int i = 0; i < 3; i++) cube[3][2-i][0] = cube[5][i][2];
        for(int i = 0; i < 3; i++) cube[5][i][2] = tmp[i];
    }
    else if(s == "U+"){
        rotate(4, "+");
        for(int i = 0; i < 3; i++) tmp[i] = cube[1][0][i];
        for(int i = 0; i < 3; i++) cube[1][0][i] = cube[2][0][i];
        for(int i = 0; i < 3; i++) cube[2][0][i] = cube[3][0][i];
        for(int i = 0; i < 3; i++) cube[3][0][i] = cube[0][0][i];
        for(int i = 0; i < 3; i++) cube[0][0][i] = tmp[i];
    }
    else if(s == "U-"){
        rotate(4, "-");
        for(int i = 0; i < 3; i++) tmp[i] = cube[1][0][i];
        for(int i = 0; i < 3; i++) cube[1][0][i] = cube[0][0][i];
        for(int i = 0; i < 3; i++) cube[0][0][i] = cube[3][0][i];
        for(int i = 0; i < 3; i++) cube[3][0][i] = cube[2][0][i];
        for(int i = 0; i < 3; i++) cube[2][0][i] = tmp[i];
    }
    else if(s == "D+"){
        rotate(5, "+");
        for(int i = 0; i < 3; i++) tmp[i] = cube[1][2][i];
        for(int i = 0; i < 3; i++) cube[1][2][i] = cube[0][2][i];
        for(int i = 0; i < 3; i++) cube[0][2][i] = cube[3][2][i];
        for(int i = 0; i < 3; i++) cube[3][2][i] = cube[2][2][i];
        for(int i = 0; i < 3; i++) cube[2][2][i] = tmp[i];
    }
    else if(s == "D-"){
        rotate(5, "-");
        for(int i = 0; i < 3; i++) tmp[i] = cube[1][2][i];
        for(int i = 0; i < 3; i++) cube[1][2][i] = cube[2][2][i];
        for(int i = 0; i < 3; i++) cube[2][2][i] = cube[3][2][i];
        for(int i = 0; i < 3; i++) cube[3][2][i] = cube[0][2][i];
        for(int i = 0; i < 3; i++) cube[0][2][i] = tmp[i];
    }
    else if(s == "B+"){
        rotate(3, "+");
        for(int i = 0; i < 3; i++) tmp[i] = cube[4][0][i];
        for(int i = 0; i < 3; i++) cube[4][0][i] = cube[2][i][2];
        for(int i = 0; i < 3; i++) cube[2][i][2] = cube[5][2][2-i];
        for(int i = 0; i < 3; i++) cube[5][2][2-i] = cube[0][2-i][0];
        for(int i = 0; i < 3; i++) cube[0][2-i][0] = tmp[i];
    }
    else if(s == "B-"){
        rotate(3, "-");
        for(int i = 0; i < 3; i++) tmp[i] = cube[4][0][i];
        for(int i = 0; i < 3; i++) cube[4][0][i] = cube[0][2-i][0];
        for(int i = 0; i < 3; i++) cube[0][2-i][0] = cube[5][2][2-i];
        for(int i = 0; i < 3; i++) cube[5][2][2-i] = cube[2][i][2];
        for(int i = 0; i < 3; i++) cube[2][i][2] = tmp[i];
    }
}

int main(void){

    cin >> T;

    for(int i = 0; i < T; i++){
        int n;

        for(int p = 0; p < 3; p++){
            for(int q = 0; q < 3; q++){
                cube[4][p][q] = 'w';
                cube[5][p][q] = 'y';
                cube[1][p][q] = 'r';
                cube[3][p][q] = 'o';
                cube[0][p][q] = 'g';
                cube[2][p][q] = 'b';
            }
        }

        vector<string> input;
        cin >> n;

        for(int k = 0; k < n; k++){
            string s;
            cin >> s;
            turn(s);
        }

        for(int p = 0; p < 3; p++){
            for(int q = 0; q < 3; q++){
                cout << cube[4][p][q];
            }
            cout << endl;
        }

    }

    return 0;
}