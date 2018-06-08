//1783
var input = readLine()?.split(separator: " ")

if let input = input{
    let height = Int(input[0])!
    let width = Int(input[1])!
    var output = 0
    if height == 1{
        output = 1
    }else if height == 2{
        output = min(width / 2 + 1, 4)
    }else{
        if width < 7{
            output = min(width, 4)
        }else{
            output = width - 2
        }
    }
    
    print(output)
}
