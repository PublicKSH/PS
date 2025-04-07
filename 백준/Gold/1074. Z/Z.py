import math

result = 0

def whichBoxAreAkAndBkIn(k, ak, bk):
    global result
    if (k==1):
        if (ak == 0 and bk == 0):
            result += 0
        elif (ak == 0 and bk == 1):
            result += 1
        elif (ak == 1 and bk == 0):
            result += 2
        else:
            result += 3
        return
         
    half_box_length = int(math.pow(2, k-1))
    area = int(math.pow(2, k-1)) * int(math.pow(2, k-1))
    if (ak >= half_box_length and bk >= half_box_length):
        result += 3 * area
        return whichBoxAreAkAndBkIn(k-1, ak-half_box_length, bk-half_box_length);
    elif (ak >= half_box_length and bk < half_box_length):
        result += 2 * area
        return whichBoxAreAkAndBkIn(k-1, ak-half_box_length, bk);
    elif (ak < half_box_length and bk >= half_box_length):
        result += 1 * area
        return whichBoxAreAkAndBkIn(k-1, ak, bk-half_box_length);
    else:
        result += 0 * area
        return whichBoxAreAkAndBkIn(k-1, ak, bk);

n, a, b = map(int, input().split())
whichBoxAreAkAndBkIn(n, a, b)
print(result)