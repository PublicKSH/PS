array = [('A', 2), ('B', 3), ('C', 1)]
def setting(data):
    return data[1]

result = sorted(array, key=setting)
print(result)