//10816 시간 초과
var n = readLine()
var cards = readLine()!.split(separator: " ")
    .map{Int($0)!}


var cardMap = [Int:Int]()
for card in cards{
    cardMap[card, default: 0] += 1
}

var m = readLine()
var values = readLine()!.split(separator: " ")
    .map{Int($0)!}


for value in values{
    if cardMap[value] != nil{
        print(cardMap[value]!, terminator: " ")
    }else{
        print(0, terminator: " ")
    }
}
