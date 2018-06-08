def next_permutation(a):
    i = len(a) - 1
    while i > 0 and a[i-1] >= a[i]:
         i -= 1

    if i <= 0:
        return False

    j = len(a) - 1

    while a[j] <= a[i-1]:
        j -= 1

    a[i-1], a[j] = a[j], a[i-1]
    
    j = len(a) - 1
    while i < j:
        a[i], a[j] = a[j], a[i]
        i += 1
        j -= 1
    
    return True

def get_next_case(inputs, selected):
    output = list()
    for i in range(len(inputs)):
        if selected[i] != 1:
            output.append(inputs[i])
    return output

def get_all_case(inputs, selected):
    outputs = list()
    outputs.append(get_next_case(inputs, selected))

    while next_permutation(selected):
        outputs.append(get_next_case(inputs, selected))

    return outputs

def print_array(inputs):
    output = str()
    for i in inputs:
        output += str(i) + ' '
    print(output)

def main():
    input_value = input()

    while(input_value != '0'):
        values = list(map(int, input_value.split()))
        k = values[0]
        inputs = values[1:]
        select = [0,0,0,0,0,0]

        for _ in range(6,k):
            select.append(1)

        outputs = get_all_case(inputs, select)
        for output in outputs:
            print_array(output)    
        print()
        input_value = input()

main()
