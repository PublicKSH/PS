n = 3
board = [[
    13, 0 ,50
],[
    12, 70, 90
],[
    25, 60, 100
]]

# 위에서 부터 더하면서 내려오는 값중 최대 (같은 column과 row에서 1개만 선택할 수 있다)
# 최대 경우의수 100*99*... *85
# 1. 백트래킹 2. dfs
# 0은 고르면 안된다 -> 0을 고를 수 밖에 없는 경우가 생기나??