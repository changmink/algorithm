var size = readLine()
var a : [Int] = (readLine()?.split(separator: " ").map{Int($0)!})!
var b = (readLine()?.split(separator: " ").map{Int($0)!})!
var output = [Int]()

var left = 0
var right = 0
var index = 0

while left < a.count && right < b.count{
    if(a[left] <= b[right]){
        output.append(a[left])
        left += 1
    }else{
        output.append(b[right])
        right += 1
    }
}

while left < a.count {
    output.append(a[left])
    left += 1
}

while right < b.count{
    output.append(b[right])
    right += 1
}

for i in output{
    print(i, terminator: " ")
}
