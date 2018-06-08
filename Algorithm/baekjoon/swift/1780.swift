//1780
var countM1 = 0
var count0 = 0
var count1 = 0

func countValue(value: Int){
    if value == -1 {
        countM1 += 1
    }else if value == 0 {
        count0 += 1
    }else{
        count1 += 1
    }
}
func same(input:[[Int]], startX:Int, startY:Int, size: Int)-> Bool{
    for i in startX..<(startX + size) {
        for j in startY..<(startY + size) {
            if(input[startX][startY] != input[i][j]){
                return false
            }
        }
    }
    return true
}
func countPaper(input:[[Int]], startX: Int, startY: Int, size: Int){
    if size == 1{
        countValue(value: input[startX][startY])
        return
    }
    
    
    
    if same(input: input, startX: startX, startY: startY, size: size) {
        countValue(value: input[startX][startY])
    }else {
        let newSize = size / 3
        for k in 0..<3{
            for p in 0..<3{
                countPaper(input: input, startX: startX + newSize * k,
                           startY: startY + newSize * p, size: newSize)
            }
        }
    }
}


var size = Int(readLine()!)!
var input = [[Int]]()

for _ in 0..<size{
    let values = (readLine()?.split(separator: " ").map{Int($0)!})!
    input.append(values)
}

countPaper(input: input, startX: 0, startY: 0, size: size)

print(countM1)
print(count0)
print(count1)

