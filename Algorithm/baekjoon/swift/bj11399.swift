func scheduleMinSum(watings:[Int]) -> Int{
    let sorted = watings.sorted()
    var sum = 0
    var accumulation = 0
    let n = watings.count
    for i in 0..<n{
        accumulation += sorted[i]
        sum += accumulation
    }
    
    return sum
}

var n = readLine()
var inputs = readLine()?.split(separator: " ")
    .map({Int($0)})

let output = scheduleMinSum(watings: inputs! as! [Int])
print(output)
