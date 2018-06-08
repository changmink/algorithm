import queue

class Node():
    def __init__(self, pos, time):
        self.pos = pos
        self.time = time

def find_min_time(start, end):
    q = queue.Queue()
    q.put_nowait(Node(start, 0))
    output = -1
    table = [False for _ in range(100001)]
    while not q.empty():
        x = q.get_nowait()
        if x.pos == end:
            output = x.time
            break
            
        if x.pos < 0 or x.pos > 100000:
            continue

        if table[x.pos]:
            continue
        
        table[x.pos] = True
        q.put_nowait(Node(x.pos - 1, x.time + 1))
        q.put_nowait(Node(x.pos + 1, x.time + 1))
        q.put_nowait(Node(x.pos * 2, x.time + 1))

    return output

times = list(map(int, input().split()))
output = find_min_time(times[0], times[1])
print(output)


    
