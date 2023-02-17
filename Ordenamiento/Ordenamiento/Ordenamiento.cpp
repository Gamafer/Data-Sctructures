#include "pch.h"
#include <iostream>
#include <algorithm>
#include <vector>
#include <stdlib.h>


int tam;
int *vec;
using namespace std;

class Ordenador {
public:
	void Intercambia(int, int, int*);
	virtual void Ordena(int*, int);
};

void Ordenador::Intercambia(int i, int j, int* arreglo) {
	int temporal = arreglo[i];
	arreglo[i] = arreglo[j];
	arreglo[j] = temporal;
}

//Bubble Sort
class BubbleSort {
public:
	void Ordena(int* arreglo, int n) {
		int i, j, k;

		for (i = 0; i < n-1; i++) {
			for (j = 0; j < n-1- i; j++) {
				if (arreglo[j] > arreglo[j + 1]) {
 					k = arreglo[j];
					arreglo[j] = arreglo[j + 1];
					arreglo[j + 1] = k;
					
				}
			}
		}
	} 
};

//Insertion Sort
class InsertionSort {
public:
	void Ordena(int* arreglo, int n) {
		int i, j, k;

		for (i = 0; i < n; i++) {
			j = i;
			k = arreglo[i];
			
			while ((j > 0) && (arreglo[j - 1] > k)) {
				arreglo[j] = arreglo[j - 1];
				j--;
			}
			arreglo[j] = k;
		}
	}
};


//Cocktail Sort
void CocktailSort(int a[], int n)
{
	bool swapped = true;
	int start = 0;
	int end = n - 1;

	while (swapped) {
		swapped = false; 
		for (int i = start; i < end; ++i) {
			if (a[i] > a[i + 1]) {
				swap(a[i], a[i + 1]);
				swapped = true;
			}
		}

		if (!swapped)
			break;

		swapped = false;

		--end;

		for (int i = end - 1; i >= start; --i) {
			if (a[i] > a[i + 1]) {
				swap(a[i], a[i + 1]);
				swapped = true;
			}
		}
		++start;
	}
}

//Counting Sort
void countingSort() {
	int i, j, k;
	int idx = 0;
	int min, max;

	min = max = vec[0];
	for (i = 1; i < tam; i++) {
		min = (vec[i] < min) ? vec[i] : min;
		max = (vec[i] > max) ? vec[i] : max;
	}

	k = max - min + 1;
	int *B = new int[k];
	for (i = 0; i < k; i++) B[i] = 0;

	for (i = 0; i < tam; i++) B[vec[i] - min]++;
	for (i = min; i <= max; i++)
		for (j = 0; j < B[i - min]; j++) vec[idx++] = i;


	delete[] B;
}





//Tree Sort
struct Node {
	int key;
	struct Node *left, *right;
};

struct Node *newNode(int item) {
	struct Node *temp = new Node;
	temp->key = item;
	temp->left = temp->right = NULL;
	return temp;
}

void storeSorted(Node *root, int vec[], int &i) {
	if (root != NULL) {
		storeSorted(root->left, vec, i);
		vec[i++] = root->key;
		storeSorted(root->right, vec, i);
	}
}

Node* insert(Node* node, int key) {
	if (node == NULL) return newNode(key);

	if (key < node->key)
		node->left = insert(node->left, key);
	else if (key >= node->key)
		node->right = insert(node->right, key);

	return node;
}

void treeSort() {
	struct Node *root = NULL;

	root = insert(root, vec[0]);
	for (int i = 1; i < tam; i++)
		insert(root, vec[i]);

	int i = 0;
	storeSorted(root, vec, i);
}

//Shell Sort
int shellSort() {
	for (int gap = tam / 2; gap > 0; gap /= 2) {
		for (int i = gap; i < tam; i += 1) {
			int temp = vec[i];
			int j;
			for (j = i; j >= gap && vec[j - gap] > temp; j -= gap)
				vec[j] = vec[j - gap];

			vec[j] = temp;
		}
	}
	return 0;
}



//Selection Sort
class SelectionSort {
public:
	void Ordena(int * arreglo, int n) {
		int i, j, k;

		for (i = 0; i < n; i++) {
			j = i + 1;
			k = i;
			while (j < n) {

				if (arreglo[k] > arreglo[j]) {
					k = j;
				}
				j++;

			}
			if (k != i) {
				j = arreglo[i];
				arreglo[i] = arreglo[k];
				arreglo[k] = j;
			}
		}
	}
};

//Quick Sort
int particion(int lo, int hi) {
	int pivote = vec[lo];
	lo--;
	hi++;

	while (true) {
		do {
			lo++;
		} while (pivote > vec[lo]);
		do {
			hi--;
		} while (pivote < vec[hi]);

		if (lo >= hi) {
			return hi;
		}
		else {
			swap(lo, hi);
		}
	}
}

void quickSort(int lo, int hi) {
	int p; 	
	if (hi > lo) {
		p = particion(lo, hi);  
		quickSort(lo, p);
		quickSort(p + 1, hi);
	}
}




int main()
{
	BubbleSort bS;
	InsertionSort iS;
	SelectionSort o;

	int arreglo[] = { 4,7,15,30,2,12,9,2};
	o.Ordena((int*)&arreglo, 5);
	for (int i = 0; i < 5; i++) {
		std::cout << arreglo[i];
	}

	//iS.Ordena((int*)&arreglo, 8);
	//for (int i = 0; i < 8; i++) {
	//	std::cout << arreglo[i];
	//}

	//bS.Ordena((int*)&arreglo, 6);
	//for (int i = 0; i < 6; i++) {
	//	std::cout << arreglo[i];
	//}
}

