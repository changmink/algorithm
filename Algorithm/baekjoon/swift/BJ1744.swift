func getMax(inputs: [Int]) -> Int{
    var plus : [Int] = []
    var minus : [Int] = []
    var zero = 0
    var one = 0
    
    for i in 0..<inputs.count{
        if inputs[i] == 1 {
            one += 1
        }else if inputs[i] > 0{
            plus.append(inputs[i])
        }else if inputs[i] < 0{
            minus.append(inputs[i])
        }else{
            zero += 1
        }
    }
    var output = one
    
    if plus.count % 2 == 1{
        plus.append(1)
    }
    var plusValues = plus.sorted()
    for i in stride(from: 0, to: plusValues.count, by: 2){
        output += plusValues[i] * plusValues[i+1]
    }
    
    if minus.count % 2 == 1{
        if zero > 0{
            minus.append(0)
        }else{
            minus.append(1)
        }
    }
    
    var minusValues = minus.sorted()
    for i in stride(from: 0, to: minusValues.count, by: 2){
        output += minusValues[i] * minusValues[i+1]
    }
    
    return output
}
var n = readLine()
if n != nil{
    let size = Int(n!)!
    var inputs : [Int] = []
    for _ in 0..<size{
        let input = Int(readLine()!)!
        inputs.append(input);
    }
    
    let output = getMax(inputs: inputs)
    print(output)
}
