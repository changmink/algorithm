class Meeting{
    var start : Int
    var end : Int
    init(start: Int, end :Int) {
        self.start = start
        self.end = end
    }
    
}
extension Meeting: Equatable{
    static func == (m1: Meeting, m2: Meeting) -> Bool{
        return m1.end == m2.end && m1.start == m2.start
    }
}
extension Meeting: Comparable{
    static func < (m1: Meeting, m2: Meeting) -> Bool{
        if m1.end == m2.end{ return m1.start < m2.start }
        return m1.end < m2.end
    }
}

func schedule(meetings: [Meeting]) -> Int{
    var sorted = meetings.sorted()
    var lastEnd = sorted[0].end
    var count = 1
    let length =  meetings.count
    for i in 1..<length{
        if( sorted[i].start >= lastEnd){
            count += 1
            lastEnd = sorted[i].end
        }
    }
    
    return count
}
var input = readLine()

if let input = input{
    let n = Int(input)!
    var list : [Meeting] = []
    
    for _ in 0..<n{
        let values = readLine()
        if values != nil{
            let times = values?.split(separator: " ")
            let start = Int(times![0])!
            let end = Int(times![1])!
            list.append(Meeting(start: start, end: end))
        }
    }
    
    print(schedule(meetings: list))
}
