
//1080 런타임 에러..
func compare(input: [[Bool]], output: [[Bool]]) -> Bool{
    for i in 0..<input.count{
        for j in 0..<input[0].count{
            if(input[i][j] != output[i][j]){
                return false
            }
        }
    }
    return true
}
func flip( input: inout [[Bool]], i: Int, j: Int){
    for r in i..<i+3{
        for c in j..<j+3{
            if r < input.count && c < input[0].count{
                input[r][c] = !input[r][c]
            }
        }
    }
}

var input = readLine()
if let input = input{
    let values = input.split(separator: " ");
    let row = Int(values[0])!
    let col = Int(values[1])!
    
    var input : [[Bool]] = []
    for _ in 0..<row{
        let line = readLine()!.map({(c: Character) -> Bool in
            if(c == "0"){ return false}
            else{ return true}
        })
        
        input.append(line)
    }
    
    var output : [[Bool]] = []
    for _ in 0..<row{
        let line = readLine()!.map({(c: Character) -> Bool in
            if(c == "1"){ return true }
            else{ return false}
        })
        output.append(line)
    }
    
    var result = 0
    for i in 0..<row-2{
        for j in 0..<col-2{
            if input[i][j] != output[i][j]{
                result += 1
                flip(input: &input, i: i, j: j)
            }
        }
    }
    
    if(compare(input: input, output: output)){
        print(result)
    }
    else{
        print(-1)
    }
}
