a,b,c = map(int ,input().split())

def power(n, exp):
    if exp == 1:
        return n % c
    else:
        if exp%2 == 0:
            x = power(n, exp/2) % c
            return x * x
        else:
            x = power(n, (exp-1)/2) % c
            return x * x * n

print(power(a,b) % c)