// Assignment1.cpp : Defines the entry point for the console application.
// Sean Daly
// K00228585
// Assignment 1A

#include "stdafx.h"
#include "TreeType.h"

void AddToTree();
void searchTree();
using namespace std;
TreeType<string>AVLTree;

int main()
{

	int option;

	do {
		cout << endl << endl;
		cout << "\t\t\t--------------------------------" << endl;
		cout << "\t\t\t| Assignment 1B / Sean Daly    |" << endl;
		cout << "\t\t\t--------------------------------" << endl;
		cout << "\t\t\t|1. Insert String To AVL Tree  |" << endl;
		cout << "\t\t\t|2. Print AVL Tree             |" << endl;
		cout << "\t\t\t|3. Search AVL Tree            |" << endl;
		cout << "\t\t\t|4. Exit			              |" << endl;
		cout << "\t\t\t--------------------------------" << endl;
		cout << "\t\t\tEnter an option now :  ";
		cin >> option;
		cout << endl << endl;

		switch (option)
		{

		case 1:
			AddToTree();
			break;

		case 2:
			AVLTree.Print();
			break;

		case 3:
			searchTree();
			break;

		default:
		{
			break;
		}
		}

	} while (option != 4);

	return 0;
}

void AddToTree()
{
	cout << "\t\t\tEnter string to add to tree:     ";
	string item;
	cin >> item;

	AVLTree.InsertItem(item);
}

void searchTree()
{
	bool found = false;
	cout << "\t\t\tEnter string to find in tree:     ";
	string item;
	cin >> item;
	AVLTree.RetrieveItem(item, found);
	if (found)
	{
		cout << "\t\t\t" << item << " found!" << endl << endl;
	}
	else
	{
		cout << "\t\t\t" << item << " not found!" << endl << endl;
	}
}

