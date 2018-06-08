
func minimumCoin(money: Int, coins: [Int]) -> Int{
    var output : Int = 0
    var input = money
    var length = coins.count;
    for i in length...0{
        output += money/coins[i]
        input %= coins[i]
    }
    return output
}
var n = Int(readLine()!)!;
var money = Int(readLine()!)!
var coins : [Int] = []

for i in 0..<n {
    coins[i] = Int(readLine()!)!
}

var output = minimumCoin(money: money, coins: coins)
print(output)