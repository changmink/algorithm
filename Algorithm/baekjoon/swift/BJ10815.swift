//10815
//10815
func binarySearch(values: [Int], findValue: Int, start: Int, end: Int) -> Bool{
    //swift의 특징 = 상수!!!
    var s = start
    var e = end
    //정렬을 안에서 하게 되면 느려짐
    while(s <= e){
        let mid = (s + e) / 2
        if values[mid] > findValue {
            e = mid - 1
        }else if values[mid] < findValue {
            s = mid + 1
        }else{
            return true
        }
    }
    return false
}

var n = readLine()
var cards = readLine()?.split(separator: " ")
    .map{Int($0)!}.sorted()
var m = readLine()
var values = readLine()?.split(separator: " ")
    .map{Int($0)!}

for value in values!{
    if binarySearch(values: cards!, findValue: value, start: 0, end: (cards?.count)!-1){
        print("1", terminator:" ")
    }else{
        print("0", terminator:" ")
    }
}

