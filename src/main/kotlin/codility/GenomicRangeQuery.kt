package codility

/*
    DNA 서열은 A , C , G 및 T 문자로 구성된 문자열로 표현 될 수 있으며 , 시퀀스의 연속적인 뉴클레오티드 유형에 해당합니다. 각 뉴클레오타이드는 정수 인 충격 계수를 갖는다 . 유형 A , C , G 및 T의 뉴클레오타이드는 각각 1, 2, 3 및 4의 충격 인자를 갖는다. 주어진 DNA 서열의 특정 부분에 포함되어있는 뉴클레오티드의 영향을 최소화하는 요소는 무엇입니까?

DNA 서열은 N 개 문자로 구성된 비어 있지 않은 문자열 S = S [0] S [1] ... S [N-1] 로 주어집니다 . 비어 있지 않은 배열 P와 Q에 각각 M 개의 정수로 구성된 M 개의 쿼리가 있습니다. K 번째 질의 (0 ≤ K <M)는 위치 P [K]와 Q [K] (포함) 사이의 DNA 서열에 포함 된 뉴클레오타이드의 최소 영향 인자를 찾도록 요구합니다.

예를 들어, 문자열 S = CAGCCTA 및 배열 P, Q를 다음과 같이 간주합니다 .

    P [0] = 2 Q [0] = 4
    P [1] = 5 Q [1] = 5
    P [2] = 0 Q [2] = 6
이 M = 3 쿼리에 대한 대답은 다음과 같습니다.

위치 2와 4 사이의 DNA 부분은 뉴클레오티드 G 와 C (두 번)를 포함하며, 그 영향 인자는 각각 3과 2이므로 대답은 2입니다.
위치 5와 5 사이의 부분은 단일 뉴클레오티드 T를 포함하며 , 그 영향 인자는 4이므로, 그 답은 4이다.
위치 0과 6 사이의 부분 (전체 문자열)에는 모든 뉴클레오티드, 특히 영향 인자가 1 인 뉴클레오티드 A 가 포함되어 있으므로 대답은 1입니다.
함수를 작성하십시오.

클래스 솔루션 {public int [] solution (String S, int [] P, int [] Q); }

N 개의 문자로 구성된 비어 있지 않은 문자열 S와 M 개의 정수로 구성된 비어 있지 않은 두 개의 배열 P와 Q가 주어지면 모든 검색어에 대한 연속적인 답을 지정하는 M 개의 정수로 구성된 배열을 반환합니다.

시퀀스는 다음과 같이 반환되어야합니다.

결과 구조 (C 언어) 또는
정수 벡터 (C ++에서) 또는
결과 레코드 (파스칼), 또는
정수의 배열 (다른 프로그래밍 언어에서).
예를 들어, 문자열 S = CAGCCTA 와 배열 P, Q가 주어진 경우 다음 과 같습니다.

    P [0] = 2 Q [0] = 4
    P [1] = 5 Q [1] = 5
    P [2] = 0 Q [2] = 6
함수는 위에서 설명한대로 [2, 4, 1] 값을 반환해야합니다.

가정하자면 :

N은 [ 1 .. 100,000 ] 범위의 정수입니다 .
M은 [ 1 .. 50,000 ] 범위의 정수입니다 .
배열 P, Q의 각 요소는 [ 0 .. N - 1 ] 범위 내의 정수입니다 .
P [K] ≤ Q [K], 0 ≤ K <M;
문자열 S는 대문자 A, C, G, T 로만 구성됩니다 .
복잡성:

기대 최악의 경우의 시간 복잡도는 O (N + M)이다.
예상 최악의 경우의 공간 복잡도는 O (N) (입력 인수에 필요한 저장소를 계산하지 않음)입니다.
*/

fun main(args: Array<String>) {
    require(listOf(2, 4, 1) == solution("CAGCCTA", arrayOf(2, 5, 0), arrayOf(4, 5, 6)))
}

// TODO : O(N + M) 시간복잡도 만족하게
fun solution(input: String, startValues: Array<Int>, endValues: Array<Int>): List<Int?> {
    val inputToInt = input.toCharArray().map { charToInt(it) }
    return startValues.zip(endValues).map {
        val start = it.first
        val end = it.second

        when (start == end) {
            true -> inputToInt[start]
            false -> (start .. end).minBy { inputToInt[it] }
        }
    }
}

fun charToInt(ch: Char): Int {
    return when (ch) {
        'A' -> 1
        'C' -> 2
        'G' -> 3
        'T' -> 4
        else -> -1
    }
}
