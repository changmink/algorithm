//10610
var input = readLine()

if let input = input{
    let tokens = input.map({(value:Character) in return String(value)})
    //let tokens = input.map({(value:Character) in String(value)})
    //let tokens = input.map({(value) -> String in String(value)})
    //let tokens = input.map({value in String(value)})
    //let tokens = input.map({String($0)})
    //let tokens = input.map{String($0)}
    var sortedTokens = tokens.sorted()
    let length = tokens.count
    var sum = 0
    
    for i in 0..<length{
        sum += Int(sortedTokens[i])!
    }
    
    if sortedTokens[0] == "0" && sum % 3 == 0{
        var output : String = ""
        for i in 0..<length/2{
            let temp = sortedTokens[length - 1 - i]
            sortedTokens[length - 1 - i] = sortedTokens[i]
            sortedTokens[i] = temp
        }
        for i in 0..<length{
            output.append(sortedTokens[i])
        }
        
        print(output)
    }else{
        print(-1)
    }
}
