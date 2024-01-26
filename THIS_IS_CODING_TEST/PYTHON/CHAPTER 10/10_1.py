def find_parent(parent, x):
    if parent[x] != x:
        return find_parent(parent, parent[x])
    return x

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b

    print("parent", parent)

v, e = map(int, input().split())
parent = [0] * (v + 1)

# 부모 테이블상에서, 부모를 자기 자신으로 초기화
for i in range(1, v + 1):
    parent[i] = i

# union 연산을 각각 수형
for i in range(e):
    a,b = map(int, input().split())
    union_parent(parent, a, b)


for i in range(1, v + 1):
    print(find_parent(parent, i), end = ' ')

print()

print('부모 테이블: ', end = ' ')
for i in range(1, v + 1):
    print(parent[i], end = ' ')
