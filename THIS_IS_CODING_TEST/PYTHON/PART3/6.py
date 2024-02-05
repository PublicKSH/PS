# todo: 다시 풀기

import heapq
# heapq 에서 중요시 봐야하는 점은 heapq.heappop() 을 하면 가장 작은 값부터  pop 된다는 것이다
def solution(food_times, k):

    if sum(food_times) <= k:
        return -1
    
    q = []
    for i in range(len(food_times)):
        heapq.heappush(q, (food_times[i], i+1))
        
    sum_value = 0
    previous = 0
    length = len(food_times)
    
    while sum_value + ((q[0][0] - previous) * length) <= k: # 한번에 먹는 음식을 빼지 못할 때
        now = heapq.heappop(q)[0]  # 먹는 시간이 가장 작은 음식의 food_time
        sum_value += (now - previous) * length # 먹는 시간이 가장 작은 음식을 먹는데 까지 총 걸리는 시간
        length -= 1 # 남은 음식의 개수 -1
        previous = now # 직전에 먹은 음식 저장
        print(sum_value)
        
    result = sorted(q, key = lambda x : x[1])
    return result[(k -sum_value) % length][1]

print(solution([8,6,4], 15))