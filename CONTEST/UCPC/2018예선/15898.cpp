//solved 함수 미구현
#include <bits/stdc++.h>
using namespace std;


pair<int,char> cauldron[5][5]; //가마솥
pair<int,char> material[10][4][4]; //재료 
int n; //재료의 개수
int Boom_quality = 0; //품질의 최대값
//가마솥 초기화 함수
void Cauldorn_init() {
    for (int i=0; i!=5; i++) {
        for (int j=0; j!=5; j++) {
            cauldron[i][j].first = 0;
            cauldron[i][j].second = 'W';
        }
    }
}
//폭탄의 품질을 반환하는 함수
int Quality() {
    int R=0,B=0,G=0,Y=0;
    // 함수 테스트용
    int W=0;
    for (int i=0; i!=5; i++) {
        for (int j=0; j!=5; j++) {
            if (cauldron[i][j].second == 'R') R+=cauldron[i][j].first;
            else if (cauldron[i][j].second == 'B') B+=cauldron[i][j].first;
            else if (cauldron[i][j].second == 'G') G+=cauldron[i][j].first;
            else if (cauldron[i][j].second == 'Y') Y+=cauldron[i][j].first;
        }
    }
    return 7*R+5*B+3*G+2*Y;
}
//재료를 회전시키는 함수 (재료의 순서)
void Turn(int n) {
    pair<int,char> temp[4][4]; //임시 저장 배열
    for (int i = 0; i < 4; i++)
		for (int j = 0; j < 4; j++)
		{
			temp[i][j] = material[n][3 - j][i];
		}

	for (int i = 0; i < 4; i++)
		for (int j = 0; j < 4; j++)
		{
			material[n][i][j] = temp[i][j];
		}
}
//재료를 가마솥에 넣는 함수, 왼쪽 위가 0,0 (좌표)
void Input_material(int n, int x=0, int y=0) {
    for (int i=0; i!=4; i++) {
        for (int j=0; j!=4; j++) {
            pair<int,char> Now_state = cauldron[x+i][y+j]; //현재 가마솥 상태
            Now_state.first += material[n][i][j].first;

            if (Now_state.first <0)
                Now_state.first = 0;
            else if (Now_state.first > 9)
                Now_state.first = 9;

            if (material[n][i][j].second != 'W') //W가 아니라면 상태를 바꾸고 맞으면 그대로
                Now_state.second = material[n][i][j].second;

            cauldron[x+i][y+j] = Now_state;
        }
    }
}
//모든경우를 계산하는 함수 
void Solved() {
    pair<int, char> origin[5][5]; //기존의 가마솥값 저장 변수
    //기존의 가마솥값 저장
    for (int i=0; i!=5; i++) {
        for (int j=0; j!=5; j++) {
            origin[i][j] = cauldron[5][5];
        }
    }
    //n개중 3개를 선택 (nP3)
    //각각 90도씩 돌려 가며 최댓값을 구함 이때,좌표변경도 생각함 (16가지 경우)
    //이후 최댓값을 저장
    for (int i=0; i!=n; i++) {
        for (int j=i+1; j!=n; j++) {
            for (int k=j+1; j!=n; j++) {
                // nP3 수행
                for (int a=0; a!=4; a++) {
                    for (int b=0; b!=4; b++) {
                        // 좌표 변경 및 90도씩 돌리기 
                        

                    }
                }
                // 원상태의 가마솥으로 변경
            }
        }
    }
}
int main() {
    Cauldorn_init(); //가마솥 초기화
    cin >> n;
    for (int i=0; i!=n; i++) {
        //재료의 효능 입력
        for (int j=0; j!=4; j++) {
            for (int k=0; k!=4; k++) {
                int x;
                cin >> x;
                material[i][j][k].first = x;
            }
        }
        //재료의 원소 입력
        for (int j=0; j!=4; j++) {
            for (int k=0; k!=4; k++) {
                char c;
                cin >> c;
                material[i][j][k].second = c;
            }
        }
    }


    cout << Boom_quality;
    return 0;
}