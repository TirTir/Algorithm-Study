#include <iostream>
using namespace std;

int main() {
	int h, m;
	cin >> h >> m;

	int count;
	m -= 45; //minute 설정
	if (m < 0) {
		h -= 1;
		m += 60;
	}

	//hour 설정
	if (h < 0) h += 24;
	else if (h > 23) h -= 24;

	cout << h << " " << m;
	return 0;
}