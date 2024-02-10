def compression(string, length):
    newString = ''
    repeatNum = 0
    for i in range(0, len(string), length):
        if string[i:i+length] == string[i+length:i+2*length]:
            repeatNum += 1
        if string[i:i+length] != string[i+length:i+2*length]:
            if repeatNum == 0:
                newString += string[i:i++length]
            if repeatNum != 0:
                newString += str(repeatNum+1) + string[i:i+length]
            repeatNum = 0
    return len(newString)

def solution(s):
    result = 1e9
    for i in range(1, len(s)+1):
        newStringLen = compression(s, i)
        if result > newStringLen:
            result = newStringLen
    return result