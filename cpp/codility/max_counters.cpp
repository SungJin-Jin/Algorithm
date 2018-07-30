#include <iostream>
#include <vector>
using namespace std;

vector<int> solution(int N, vector<int> &A)
{
	vector<int> v(N);

	for (int x = 0; x < A.size(); x++) {
		if (A.at(x) >= 1 && A.at(x) <= N)
			v.at(A.at(x) - 1)++;
		else if (A[x] == N+1) {
			int max_value = v.front();
			for (size_t k = 1; k < v.size(); k++)
				if (v[k] > max_value) max_value = v[k];
			for (int i = 0; i < v.size(); i++)
				v.at(i) = max_value;
		}
	}

	return v;
}
