
#include "pch.h"
#include <iostream>
class Memory {
public:
	void reserveByAddress(int** variable, int size);
	void reserveByReference(int*& variable, int& size);

};

void Memory::reserveByReference(int*& variable, int& size) {
	variable = new int[size];
	size = 22;
}

void Memory::reserveByAddress(int** variable, int size) {
	*variable = new int[size];
}


int main()
{
	int *p=new int[10] {5,9,3,8,1,4,7,6,0,2};
	const int *q = p;
	int *r = p;
	int n;

	n = *p;
	n = *(p + 1);
	n = *p++;
	n = *++p;
	n = *(p)+1;
	n = *q;
	n = *r;


	std::cout << n;
	
	
}

