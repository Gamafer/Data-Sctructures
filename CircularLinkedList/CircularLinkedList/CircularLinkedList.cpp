#include "pch.h"
#include <iostream>

using namespace std;

template<class T>
class Node
{
public:
	T value;
	Node<T>* next;
	Node() {
		next = NULL;
	}
	Node(T v) {
		value = v;
		next = NULL;
	}

};
template<class T>
void printNormal(Node<T>* node)
{
	Node<T>* temp = node;
	while (temp != NULL)
	{
		cout << temp->value << " ";
		temp = temp->next;
	}
}

template<class T>
void recursivePrint(Node<T>* node)
{
	if (node == NULL)
		return;
	else
	{
		cout << node->value << ",";
		return recursivePrint(node->next);
	}
}

template<class T>
class CircularLinkedList
{
protected:
	Node<T>* root;
public:
	CircularLinkedList()
	{
		root = NULL;
	}

	void add(Node<T>* node)
	{
		if (root == NULL)
			root = node;
		root->next = root;
		else
		{
			Node<T>* temp = traverse(root);
			node->next = root;
			temp->next = node;
		}
	}

	void add(T value)
	{
		Node<T>* toAdd = new Node<T>(value);
		add(toAdd);
	}

	void insert(Node<T>* toAdd, int position) {
		Node<T>* temp = root;
		if (position == 0) {
			toAdd->next = root;
			temp = traverse(root);
			root = toAdd;
			temp->next = toAdd;
		}
	}

	void remove(int position) {
		Node<T>* temp = root;
		if (position == 0) {
		}
	}


	void insert(T value, int position) {
		Node<T>* toAdd = new Node<T>(value);
		toAdd->next = NULL;
		insert(toAdd, position);
	}
	void insert(Node<T>* toAdd, int position) {
		Node<T>* temp = root;
		if (position == 0) {
			toAdd->next = temp;
			root = toAdd;
			return;
		}
		for (int i = 0; i < position - 1; i++) {
			if (temp->next == NULL) {
				break;
			}
			else {
				temp = temp->next;
			}
		}
		toAdd->next = temp->next;
		temp->next = toAdd;

	}

	void remove(int position) {
		Node<T>* temp = root;
		Node<T>* toDel;
		if (position == 0) {
			root = temp->next;
		}
		else {
			for (int i = 0; i < position - 1; i++) {
				if (temp->next == NULL) {
					return;
				}
				else {
					temp = temp->next;
				}
			}
		}
		toDel = temp->next;
		temp->next = temp->next->next;
		free(toDel);
	}

	Node<T>* traverse(Node<T>* node)
	{
		if (node->next == nullptr)
			return node;
		else
			return traverse(node->next);
	}

	void modify(int position, T val) {
		Node<T>*temp = root;
		if (position == 0) {
			root->value = val;
		}
		else {
			for (int i = 0; i < position; i++) {
				if (temp->next != NULL) {
					temp = temp->next;
				}
				else {
					return;
				}
			}
			temp->value = val;
		}
	}



	void printList() {
		recursivePrint(root);
	}

};

int main()
{
	
}