// Tries.cpp : This file contains the 'main' function. Program execution begins and ends there.
//
#include "TrieType.h"
#include <string>
#include <iostream>

void InsertKey();
void Search();
void Print();
void DeleteTrie(TrieType& trie);
int Menu();

TrieType newTrie;
key newKey;

int main()
{
	int input=0;

	while (input!=5) {
		int option = Menu();
		switch (option) {
		case 1:
			InsertKey();
			break;
		case 2:
			Search();
			system("pause");
			break;
		case 3:
			Print();
			cout << endl;
			system("pause");
			break;
		case 4:
			DeleteTrie(newTrie);
			system("pause");
			break;
		case 5:
			return 0;
			break;
		default:
			cout << "Wrong Choice" << endl;
			system("pause");
			break;
		}
	}
	return 0;
}



void InsertKey() {
	cout << "Please enter the word: " << endl;
	cin >> newKey;
	EntryType* newEntryType = new EntryType(newKey);
	newTrie.InsertTrie(newKey, newEntryType);

}

void Search()
{

	cout << "\n\n\t" << "Please enter a word: ";
	cin >> newKey;
	if (newTrie.TrieSearch(newKey)) {
		cout << "\n\n\t" << newKey << " was found!\n";
	}
	else {
		cout << "\n\n\t" << newKey << " wasn't found!\n";
	}
}



void Print()
{

	newTrie.PrintTrie();
}


void DeleteTrie(TrieType& trie)
{
	key word;
	cout << "Please enter the word to delete from trie: " << endl;
	cin >> word;

	trie.DeleteTrie(word, newTrie.root, 0);
	cout << "The word: " << word << " has been deleted from the trie!" << endl;
}
int Menu() {
	int input = 0;

	while (input != 5) {
		system("cls");
		cout << endl;
		cout << "\t\tSean Daly" << endl;
		cout << "\t\tK00228585" << endl;
		cout << "\t\t1.Insert Word into a Trie" << endl;
		cout << "\t\t2.Search a Trie for a specific word" << endl;
		cout << "\t\t3.Print Words Alphabetically" << endl;
		cout << "\t\t4.Delete A Word" << endl;
		cout << "\t\t5.Exit" << endl;
		cout << "Enter your Choice: ";
		cin >> input;
		if (cin.fail())
		{
			cin.clear();
			cin.ignore(numeric_limits<streamsize>::max(), '\n');
			cout << "Invalid input " << endl;
		}
		return input;
	}
}