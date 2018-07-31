#include <iostream>
#include <vector>
using namespace std;

int solution(vector<int> &A)
{
	double prev, calc;
	int result;
	int start, end;
	int temp;
	int sum;

	prev = (A.at(0) + A.at(1)) / 2;
	for (start = 0; start < A.size() - 1; start++) {
		for (end = start + 1; end <= A.size() - 1; end++) {
			temp = start;
			sum = 0;
			while (temp <= end) {
				sum += A.at(temp);
				temp++;
			}
			calc = (double)sum / (end - start + 1);
			if (calc < prev) {
				prev = calc;
				result = start;
			}
		}
	}

	return result;
}

