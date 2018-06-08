//10815

var n = readLine()
var cards = readLine()?.split(separator: " ")
    .map{Int($0)!}
var cardSet = Set(cards!)
var m = readLine()
var values = readLine()?.split(separator: " ")
    .map{Int($0)!}

for value in values!{
    if cardSet.contains(value){
        print("1", terminator: " ")
    }else{
        print("0", terminator: " ")
    }
}
