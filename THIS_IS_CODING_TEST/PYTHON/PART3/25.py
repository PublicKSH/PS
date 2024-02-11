def solution(N, stages):
    tempList = [0] * (N+2)
    for i in stages:
        tempList[i] += 1
    totalLen = sum(tempList)
    failureRateList = []
    for i in range(1, N+1):
        if tempList[i] == 0:
            failureRateList.append((i, 0))
            continue
        if tempList[i] != 0:
            stage = i
            failureRate = tempList[i]/totalLen
            totalLen -= tempList[i]
            failureRateList.append((stage, failureRate))
    
    failureRateList.sort(key = lambda x : -x[1])
    answer = [failureRate[0] for failureRate in failureRateList]
    return answer
