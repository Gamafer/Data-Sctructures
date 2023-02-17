

#include "pch.h"
#include <iostream>

#include <iostream>
using namespace std;

class Ordenador
{
public:
	int * arreglo;
	int size;
	void Intercambia(int, int);
	void AsignarArreglo(int*, int);
	void ImprimirArreglo();
	virtual void Ordena() = 0;
};

void Ordenador::AsignarArreglo(int* a, int s) {
	arreglo = new int[s];
	size = s;
	for (int i = 0; i < s; i++) {
		arreglo[i] = a[i];
	}
}

void Ordenador::ImprimirArreglo() {
	for (int i = 0; i < size; i++) {
		printf("%d, ", arreglo[i]);
	}
	printf("\n");
}

void Ordenador::Intercambia(int index1, int index2) {
	int auxiliar;
	auxiliar = arreglo[index1];
	arreglo[index1] = arreglo[index2];
	arreglo[index2] = auxiliar;
}


class SelectionSort : public Ordenador
{
public:
	void Ordena();
};

void SelectionSort::Ordena() {
	for (int i = 0; i < size - 1; i++) {
		int minimo = i;
		for (int j = i + 1; j < size; j++) {
			if (arreglo[j] < arreglo[minimo]) {
				minimo = j;
			}
		}
		SelectionSort::Intercambia(i, minimo);
	}
}

class MergeSort : public Ordenador
{
public:
	void Ordena();
private:
	void sort(int, int);
	void merge(int, int, int);
};

void MergeSort::Ordena() {
	MergeSort::sort(0, size - 1);
}

void MergeSort::sort(int low, int high) {
	if (low < high) {
		int mid = low + (high - low) / 2;
		MergeSort::sort(low, mid);
		MergeSort::sort(mid + 1, high);
		MergeSort::merge(low, mid, high);
	}
}

void MergeSort::merge(int low, int mid, int high) {
	int n1 = mid - low + 1;
	int n2 = high - mid;
	int Left[mid - low + 1];
	int Right[high - mid];
	//copiar arreglos
	for (int i = 0; i < n1; i++) {
		Left[i] = arreglo[low + i];
	}
	for (int i = 0; i < n2; i++) {
		Right[i] = arreglo[mid + 1 + i];
	}
	int i = 0;
	int j = 0;
	int k = low;
	while (i < n1 && j < n2) {
		if (Left[i] < Right[i]) {
			arreglo[k] = Left[i];
			i++;
		}
		else {
			arreglo[k] = Right[j];
			j++;
		}
		k++;
	}
	while (i < n1)
	{
		arreglo[k] = Left[i];
		i++;
		k++;
	}
	while (j < n2)
	{
		arreglo[k] = Right[j];
		j++;
		k++;
	}
}

class QuickSort : public Ordenador
{
public:
	void Ordena();
private:
	void sort(int, int);
	int partition(int, int);
};

void QuickSort::Ordena() {
	QuickSort::sort(0, size - 1);
}

void QuickSort::sort(int low, int high) {
	if (high <= low) {
		return;
	}
	int j = QuickSort::partition(low, high);
	QuickSort::sort(low, j - 1);
	QuickSort::sort(j + 1, high);
}

int QuickSort::partition(int low, int high) {
	int i = low + 1;
	int j = high;
	int pivote = arreglo[low];//pivote
	while (1) {
		while (arreglo[i] < pivote) {
			i++;
		}
		while (arreglo[j] > pivote) {
			j--;
		}
		if (i >= j) {
			break;
		}
		QuickSort::Intercambia(i, j);
	}
	QuickSort::Intercambia(j, low);
	return j;
}
int main() {
	QuickSort qs;
	MergeSort ms;
	SelectionSort ss;
	int a[] = { 5,2,3,4,1 };
	qs.AsignarArreglo((int *)&a, 5);
	qs.Ordena();
	qs.ImprimirArreglo();
	ms.AsignarArreglo((int *)&a, 5);
	ms.Ordena();
	ms.ImprimirArreglo();
	ss.AsignarArreglo((int *)&a, 5);
	ss.Ordena();
	ss.ImprimirArreglo();

}

