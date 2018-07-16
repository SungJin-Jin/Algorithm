package main.kotlin.kakao

/*
  ���� : http://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/

  4. ��Ʋ ����(���̵�: ��)
    īī�������� ���� ��Ʋ������ �����ϱ� ������ �Ǳ������� ���ϰ� �繫�Ƿ� �� �� �ִ�. īī���� ������ ���θ� ��ũ�硯��� �θ��µ�, ��ħ���� ���� ũ����� �� ��Ʋ�� �̿��Ͽ� ����Ѵ�.

    �� ���������� ���Ǹ� ���� ��Ʋ�� ������ ���� ��Ģ���� �����Ѵٰ� ��������.

    ��Ʋ�� 09:00���� �� nȸ t�� �������� ���� �����ϸ�, �ϳ��� ��Ʋ���� �ִ� m���� �°��� Ż �� �ִ�.
    ��Ʋ�� �������� �� ������ ������ ��⿭�� �� ũ����� �����ؼ� ��� ������� �¿�� �ٷ� ����Ѵ�. ���� ��� 09:00�� ������ ��Ʋ�� �ڸ��� �ִٸ� 09:00�� ���� �� ũ�絵 Ż �� �ִ�.
    ���� ���ͼ� ��Ʋ�� ��ٸ��� ���� �����Ҵ� ����, �����ϰ��� ������ ���� ���� � ũ�簡 �� �ÿ� ��Ʋ ��⿭�� �����ϴ��� �˾Ƴ´�. ���� ��Ʋ�� Ÿ�� �繫�Ƿ� �� �� �ִ� ���� �ð� �� ���� ���� �ð��� ���Ͽ���.

    ��, ���� �������� ������ ���� �ð��� ������ ũ�� �� ��⿭���� ���� �ڿ� ����. ����, ��� ũ��� ���� �ھ� �ϹǷ� 23:59�� ���� ���ư���. ���� � ũ�絵 ������ ��Ʋ�� Ÿ�� ���� ����.

    �Է� ����
    ��Ʋ ���� Ƚ�� n, ��Ʋ ���� ���� t, �� ��Ʋ�� Ż �� �ִ� �ִ� ũ�� �� m, ũ�簡 ��⿭�� �����ϴ� �ð��� ���� �迭 timetable�� �Է����� �־�����.

    0 �� n ? 10
    0 �� t ? 60
    0 �� m ? 45
    timetable�� �ּ� ���� 1�̰� �ִ� ���� 2000�� �迭��, �Ϸ� ���� ũ�簡 ��⿭�� �����ϴ� �ð��� HH:MM �������� �̷���� �ִ�.
    ũ���� ���� �ð� HH:MM�� 00:01���� 23:59 �����̴�.
    ��� ����
    ���� ������ ��Ʋ�� Ÿ�� �繫�Ƿ� �� �� �ִ� ���� ���� ���� �ð��� ����Ѵ�. ���� �ð��� HH:MM �����̸�, 00:00���� 23:59 ������ ���� �� �� �ִ�.
 */


fun main(args: Array<String>) {

    require("09:00" == solve(1, 1, 5, listOf("08:00", "08:01", "08:02", "08:03")))
    require("09:09" == solve(2, 10, 2, listOf("09:10", "09:09", "08:00")))
    require("08:59" == solve(2, 1, 2, listOf("09:00", "09:00", "09:00", "09:00")))
    require("00:00" == solve(1, 1, 5, listOf("00:01", "00:01", "00:01", "00:01", "00:01")))
    require("09:00" == solve(1, 1, 1, listOf("23:59")))
    require("18:00" == solve(10, 60, 45, listOf("23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59")))

}

fun solve(count: Int = 1, interval: Int = 1, max: Int = 1, timetable: List<String>): String {
    val times = timetable.map { Time(it.substring(0, 2).toInt(), it.substring(3, 5).toInt()) }.toList()
    val lastShuttle = 9 * 60 + (count - 1) * interval
    val lastShuttleTime = Time(lastShuttle / 60, lastShuttle % 60)
    val lastCrewTime = times.sortedBy { it.time() }.last()

    return when {
        times.size >= max * count -> {
            val time = times.sortedBy { it.time() }[max - 1]

            when {
                lastShuttleTime.time() < time.time() -> lastShuttleTime.toString()
                else -> time.minus(1).toString()
            }
        }
        else -> when {
            lastCrewTime.time() > lastShuttleTime.time() -> lastShuttleTime.toString()
            lastCrewTime.time() == lastShuttleTime.time() -> lastShuttleTime.minus(1).toString()
            else -> lastShuttleTime.toString()
        }
    }
}

data class Time(
        var hour: Int,
        var minute: Int
) {

    fun time() = hour * 60 + minute

    fun minus(value: Int): Time {
        if (minute == 0) {
            hour--
            minute = 60 - value
        } else {
            minute -= value
        }

        return this
    }

    override fun toString(): String = String.format("%02d:%02d", hour, minute)
}
