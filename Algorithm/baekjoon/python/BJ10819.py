def next_permutation(array):
    i = len(array) - 1
    while i > 0 and array[i-1] >= array[i]:
        i -= 1
    
    if i <= 0:
        return False

    j = len(array) - 1
    while array[j] <= array[i-1]:
        j -= 1

    temp = array[i-1]
    array[i-1] = array[j]
    array[j] = temp

    j = len(array) - 1
    while i < j:
        temp = array[i]
        array[i] = array[j]
        array[j] = temp
        i += 1
        j -= 1

    return True

def max_difference(array):
    array.sort()

    output = get_value(array)

    while next_permutation(array):
        value = get_value(array)
        output = max(value, output)

    return output

def get_value(array):
    value = 0
    
    for i in range(1, len(array)):
        value += abs(array[i-1] - array[i])
    
    return value

def main():
    n = input()
    inputs = input().split(" ")
    array = list(map(int, inputs))
    print(max_difference(array))

main()