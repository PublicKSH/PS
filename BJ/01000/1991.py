n = int(input())
tree = {}
for i in range(0,n):
    root, left, right = input().split()
    tree[root] = [left, right]

preResult = ''
inResult = ''
postResult = ''
def preorder(v):
    global preResult
    if v == '.':
        return
    preResult += v
    preorder(tree[v][0])
    preorder(tree[v][1])

def inorder(v):
    global inResult
    if v == '.':
        return
    inorder(tree[v][0])
    inResult += v
    inorder(tree[v][1])

def postorder(v):
    global postResult
    if v == '.':
        return
    postorder(tree[v][0])
    postorder(tree[v][1])
    postResult += v

preorder('A')
inorder('A')
postorder('A')
print(preResult)
print(inResult)
print(postResult)
