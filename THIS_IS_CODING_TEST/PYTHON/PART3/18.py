# todo: 문자열 뒤집기 방식 복습 
# todo: 코드만 다시 읽어보기
# 균형잡힌 괄호 문자열 분리
def balance_string(str):
    numLeftBracket = 0
    numRightBracket = 0
    index = 0
    for i in range(len(str)):
        if str[i] == '(':
            numLeftBracket+= 1
        if str[i] == ')':
            numRightBracket+= 1
        if numLeftBracket == numRightBracket:
            index = i
            break;
    return index+1

def correct_string(str):
    num = 0
    if str[0] != "(":
        return False
    for i in range(len(str)):
        if str[i] == '(':
            num += 1
        if str[i] == ')':
            num -= 1
        if num < 0:
            return False
    
    return True

def solution(p):
    testStr = '123456'

    answer = ''
    # 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
    if len(p) == 0:
        return ''
    # 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다.
    index = balance_string(p)
    u, v = p[:index], p[index:]
    # 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다. 
    # 3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다. 
    if correct_string(u):
        answer = u + solution(v)
    else:
        answer = '(' + solution(v) + ')'
        # 4-4
        u = u[1:len(u)-1]
        for i in range(len(u)):
            if u[i] == '(':
                answer += ')'
            if u[i] == ')':
                answer += '('

    return answer