func bracket(input: String) -> Int{
    var output = 0
    var start = input.startIndex
    var minus = false
    var index = 0
    for token in input{
        let i = input.index(input.startIndex, offsetBy: index)
        if token == "+" || token == "-" {
            let value = Int(input[start..<i])!
            start = input.index(after: i)
            
            if minus{
                output -= value
            }else{
                output += value
            }
            
            if token == "-"{
                minus = true
            }
        }
        
        index += 1
    }
    
    let value = Int(input[start...])!
    if minus{
        output -= value
    }else{
        output += value
    }
    
    return output
}
var input = readLine()
if let input = input{
    let output = bracket(input: input)
    print(output)
}
