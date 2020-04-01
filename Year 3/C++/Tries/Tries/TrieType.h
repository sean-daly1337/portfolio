#pragma once

#include "EntryType.h"

const int LETTERS = 26;
typedef char key[MAXLENGTH];

struct TrieNode
{
	TrieNode* branch[LETTERS];
	EntryType* ref;
};


class TrieType {

public:
	TrieType();
	~TrieType();
	TrieType(TrieType& originalTree);
	void operator=(TrieType& originalTree);
	void MakeEmpty();
	void InsertTrie(key newkey, EntryType* newentry);
	EntryType* TrieSearch(key target);
	bool DeleteTrie(key delkey, TrieNode* trie, int i);
	void PrintTrie();

	TrieNode* root;
	void Print(TrieNode* tree);
};




TrieType::TrieType()
{

}
TrieType::~TrieType()
{

}

EntryType* TrieType::TrieSearch(key target) {


	int i;
	TrieNode* current = root;
	for (i = 0; i < MAXLENGTH && current; i++)
		if (target[i] == '\0')
			break;
		else
			current =
			current->branch[target[i] - 'a'];

	if (!current)
		return NULL;
	else
		if (!current->ref)
			return NULL;

	return current->ref;
}

//
//	create a new node
//
TrieNode* CreateNode()
{

	TrieNode* newnode = new (TrieNode);
	for (int ch = 0; ch < LETTERS; ch++)
		newnode->branch[ch] = NULL;

	newnode->ref = NULL;

	return newnode;
}



void TrieType::InsertTrie(key newkey, EntryType* newentry)
{

	TrieNode* current;

	if (!root)
		root = CreateNode();
	current = root;
	for (int i = 0; i < MAXLENGTH; i++) {
		if (newkey[i] == '\0')
			break;
		else
		{
			if (!current->branch[newkey[i] - 'a'])

				current->branch[newkey[i] - 'a'] = CreateNode();
			current = current->branch[newkey[i] - 'a'];
		}
	}
	if (current->ref != NULL)
		cout << "\nTried to insert a duplicate key.\n";
	else
		current->ref = newentry;

}

void TrieType::PrintTrie()
{
	Print(root);
}

void TrieType::Print(TrieNode* tree)
{

	if (tree->ref != NULL)
	{
		cout << *(tree->ref) << " ";
	}

	for (int i = 0; i < 26; i++)
	{
		if (tree->branch[i] != NULL)
		{
			Print(tree->branch[i]);
		}
	}

}

bool TrieType::DeleteTrie(key delkey, TrieNode* trie, int i)
{
	TrieNode* current = trie;

	if (delkey[i] == '\0')
	{
		return true;

	}
	else
	{
		current = current->branch[delkey[i] - 'a'];
		if (DeleteTrie(delkey, current, ++i))
		{
			current->ref = NULL;
			if (!current)
				delete current;
			return false;
		}
		if (!current)
			delete current;
		return false;

	}


	return true;
}


/*

void  TrieType::TrieNode* remove(Trienode *curr, Key key, int depth)
{
	if (!curr)
		return NULL;

	if (depth == strlen(key))
	{
		if (haveChildren(curr) == false)
		{
			free(curr);
			curr = NULL;
		}

		return curr;
	}

	int index = key[depth] - 'a';
	curr->branch[index] = remove(curr->branch[index], key, depth + 1);

	if (haveChildren(curr) == false)
	{
		free(curr);
		curr = NULL;
	}

	return curr;
}


*/
/*
bool TrieType::DeleteTrie(Key delkey)
{
	if (TrieSearch(delkey) == false)
		return false;
	else
	{
		remove(root, delkey, 0);

		return true;
	}

*/