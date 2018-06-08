import sys

def next_permutation(array):
    i = len(array) - 1
    while i > 0 and array[i-1] >= array[i]:
        i -= 1

    if i <= 0:
        return False

    j = len(array) - 1
    while j >= i and array[j] <= array[i-1]:
        j -= 1

    array[i-1], array[j] = array[j], array[i-1]

    j = len(array) - 1
    while i < j:
        array[i], array[j] = array[j], array[i]
        i += 1
        j -= 1
    
    return True

def min_cost(costGraph):
    path = [i for i in range(len(costGraph))]
    output = sys.maxsize
    output = min(output, cal_cost(costGraph, path))
    while next_permutation(path):
        cost = cal_cost(costGraph, path)
        output = min(output, cost)
    
    return output

def cal_cost(costGraph, path):
    output = 0
    for i in range(1, len(path)):
        cost = costGraph[path[i-1]][path[i]]
        if cost == 0:
            return sys.maxsize
        output += cost

    # 다시 오는거 고려
    cost = costGraph[path[len(path) - 1]][path[0]]
    if cost == 0:
        return sys.maxsize
    output += cost

    return output

n = int(input())
graph = list()
for _ in range(n):
    graph.append(list(map(int, input().split())))

#graph = [[0, 10, 15, 20],[5,  0,  9, 10], [6, 13, 0, 12], [8,  8,  9,  0]]
value = min_cost(graph)
print(value)