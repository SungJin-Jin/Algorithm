package codility;

import static utils.Utils.require;

/*
    N 개의 정수로 구성된 비어 있지 않은 배열 A가 주어진다. 0 ≤ P <Q <N과 같은 한 쌍의 정수 (P, Q) 를 배열 A 의 조각 이라고 부릅니다 (슬라이스에 적어도 두 개의 요소가 있음을 알 수 있음). 평균 슬라이스 (P, Q)의이 A [P]의 합이다 + A [P + 1] + ... + 슬라이스의 길이에 의해 분할 된 A [Q]. 정확히 말하면 평균은 (A [P] + A [P + 1] + ... + A [Q]) / (Q-P + 1)과 같습니다.

    예를 들어, 배열 A는 다음과 같습니다.

        A [0] = 4
        A [1] = 2
        A [2] = 2
        A [3] = 5
        A [4] = 1
        A [5] = 5
        A [6] = 8
    다음 예제 슬라이스가 포함되어 있습니다.

    slice (1, 2), 평균은 (2 + 2) / 2 = 2입니다.
    slice (3, 4), 평균은 (5 + 1) / 2 = 3;
    슬라이스 (1, 4), 평균은 (2 + 2 + 5 + 1) / 4 = 2.5입니다.
    목표는 평균이 최소 인 조각의 시작 위치를 찾는 것입니다.

    함수를 작성하십시오.

    클래스 솔루션 {public int solution (int [] A); }

    N 개의 정수로 구성된 비어 있지 않은 배열 A가 주어지면 최소 평균을 가진 슬라이스의 시작 위치를 반환합니다. 최소 평균을 가진 슬라이스가 두 개 이상인 경우 해당 슬라이스의 최소 시작 위치를 반환해야합니다.

    예를 들어, 주어진 배열 A는 다음과 같습니다.

        A [0] = 4
        A [1] = 2
        A [2] = 2
        A [3] = 5
        A [4] = 1
        A [5] = 5
        A [6] = 8
    함수는 위에서 설명한대로 1을 반환해야합니다.

    가정하자면 :

    N은 [ 2 .. 100,000 ] 범위의 정수입니다 .
    배열 A의 각 요소는 [ -10,000 .. 10,000 ] 범위의 정수 입니다.
    복잡성:

    기대 최악의 경우의 시간 복잡도는 O (N)이다.
    예상 최악의 경우의 공간 복잡도는 O (N) (입력 인수에 필요한 저장소를 계산하지 않음)입니다.
 */
public class MinimumSlice {

    public static void main(String[] args) {
        require(1 == solve(new int[]{4, 2, 2, 5, 1, 5, 8}));
        require(2 == solve(new int[]{4, 2, 2, 1, 3, 1, 3, 1}));
        require(0 == solve(new int[]{-3, 1, -2, 1, -2, 1, -2, 1, -2, 1, -2}));
    }

    private static int solve(int[] values) {
        int result = 0;
        double compareValue = Double.MAX_VALUE;
        for (int index = 0; index < values.length - 1; index++) {
            double value = (values[index] + values[index + 1]) / 2.0;

            if (compareValue > value) {
                compareValue = value;
                result = index;
            }

            if(index < values.length - 2) {
                value = (values[index] + values[index + 1] + values[index + 2]) / 3.0;
                if (compareValue > value) {
                    compareValue = value;
                    result = index;
                }
            }
        }
        return result;
    }

}