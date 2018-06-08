//2875
func teamMatching(n: Int, m: Int, interns: Int) -> Int{
    var team = 0
    var girl = n
    var boy = m
    while girl >= 2 && boy >= 1 && girl + boy >= interns + 3{
        team += 1;
        girl -= 2;
        boy -= 1;
    }
    return team
}

var input = readLine()
if let input = input{
    var inputs = input.split(separator: " ")
    let girls = Int(inputs[0])!
    let boys = Int(inputs[1])!
    let interns = Int(inputs[2])!
    let output = teamMatching(n: girls, m: boys, interns: interns)
    print(output)
}
