
def make_prime_table(value, primes):
    for p in primes:
        if i % p == 0:
            return False
    return True

def is_prime(value, primes):
    for p in primes:
        if p == value:
            return True
    return False

def find_min_change(start, end, checks, changes, primes):
    change = 0
    value = start
    
    while a == 0:
    if value == end:
        return change
    
if __name__ == "__main__":
    primes = [2]
    
    for i in range(3, 10000):
        if make_prime_table(i, primes):
            primes.append(i)

    T = 1

    for i in range(T):
        checks = [False for _ in range(10000)]
        changes = [i for i in range(10000)]
        output = find_min_change(1033, 1033)

        if output == -1:
            print("Impossible")
        else: 
            print(output)
