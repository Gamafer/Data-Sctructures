

#include "pch.h"
#include <iostream>

using namespace std;

template<class T>
class Bst
{
protected:
	void inOrder(Node<T>*);
	Node<T>* root;
public:
	Bst();
	void insert(T value);
	void inOrder();
};

template<class T>
Bst<T>::Bst()
{
	root = nullptr;
}
template<class T>
void Bst<T>::insert(T value)
{
	if (root == nullptr)
		root = new Node<T>(value);
	else
	{
		Node<T>* temp = root;
		while (true)
		{
			if (value < temp->value)
			{
				if (temp->left == nullptr)
				{
					temp->left = new Node<T>(value);
					return;
				}
				else
				{
					temp = temp->left;
					continue;
				}
			}
			if (value > temp->value)
			{
				if (temp->right == nullptr)
				{
					temp->right = new Node<T>(value);
					return;
				}
				else
				{
					temp = temp->right;
					continue;
				}
			}
		}
	}
}

template<class T>
void Bst<T>::inOrder()
{
	inOrder(root);
}

template<class T>
void inOrder(Node<T>* node)
{
	if (node == NULL)
		return;
}


template<class T>
class Node
{
public:
	Node(T value);
	Node* left;
	Node* right;
	T value;
};

template<class T>
Node<T>::Node(T value)
{
	this->value = value;
	left = nullptr;
	right = nullptr;
}


int main()
{
    std::cout << "Hello World!\n"; 
}

