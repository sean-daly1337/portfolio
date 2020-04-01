#pragma once
template<class ItemType>
struct TreeNode;

template<class ItemType>
class TreeType
{
public:
	TreeType(); 	// constructor
	~TreeType(); 	// destructor

	void MakeEmpty();
	void Print();
	void InsertItem(ItemType item);
	void RetrieveItem(ItemType& item, bool& found);
	void PrintTree(TreeNode<ItemType>* tree);

private:
	TreeNode<ItemType> * root;
};

typedef enum BalanceFactor { LH, EH, RH } BalanceFactor;

template <class ItemType>
struct TreeNode
{
	ItemType info;
	TreeNode<ItemType>* left;
	TreeNode<ItemType>* right;
	BalanceFactor bf;
};

template <class ItemType>
TreeType<ItemType>::TreeType()
{
	root = NULL;
}

template <class ItemType>
TreeType<ItemType>::~TreeType()
{
	MakeEmpty();
}

template <class ItemType>
void TreeType<ItemType>::MakeEmpty()
{
	Destroy(root);
	root = NULL;
}

template <class ItemType>
void Destroy(TreeNode<ItemType>*& tree)
{
	if (tree != NULL)
	{
		Destroy(tree->left);
		Destroy(tree->right);
		delete tree;
	}
}
//////////////////////////////////////////////////////////////////////////////////////////////
template <class ItemType>
void RotateLeft(TreeNode<ItemType> * & tree)
{
	TreeNode<ItemType> * rs;
	if (tree == NULL)
		cerr << "It is impossible to rotate an empty tree in RotateLeft" << endl;
	else if (tree->right == NULL)
		cerr << "It is impossible to make an empty subtree the root in	RotateLeft" << endl;
	else
	{
		rs = tree->right;
		tree->right = rs->left;
		rs->left = tree;
		tree = rs;
	}
}


// Rotating Right
template <class ItemType>
void RotateRight(TreeNode<ItemType> * & tree)
{
	TreeNode<ItemType> * ls;
	if (tree == NULL)
		cerr << "It is impossible to rotate an empty tree in RotateRight" << endl;
	else if (tree->left == NULL)
		cerr << "It is impossible to make an empty subtree the root in RotateRight" << endl;
	else
	{
		ls = tree->left;
		tree->left = ls->right;
		ls->right = tree;
		tree = ls;
	}
}
//Insert into AVL Tree
template <class ItemType>
void TreeType<ItemType> ::InsertItem(ItemType item)
// Calls recursive function Insert to insert item into tree.
{
	bool taller = false;
	Insert(root, item, taller);
}

template <class ItemType>
void Insert(TreeNode<ItemType>*& tree, ItemType item, bool & taller)
// Inserts item into tree.				 
// Post:	item is in tree; search property is maintained.
{
	if (tree == NULL)
	{	// Insertion place found.
		tree = new TreeNode<ItemType>;
		tree->left = NULL;
		tree->right = NULL;
		tree->info = item;
		tree->bf = EH;
		taller = true;
	}
	else if (item == tree->info)
		cerr << "Duplicate key is not allowed in AVL tree." << endl;
	else if (item < tree->info)
	{
		Insert(tree->left, item, taller);
		// Insert into left subtree			
		if (taller)
			switch (tree->bf) {
			case LH: LeftBalance(tree, taller);
				break;
			case EH: tree->bf = LH;
				break;
			case RH: tree->bf = EH;
				taller = false;
				break;
			}
	}
	else
	{
		Insert(tree->right, item, taller);
		// Insert into right subtree				
		if (taller)
			switch (tree->bf)
			{
			case RH: RightBalance(tree, taller);
				break;
			case EH: tree->bf = RH;
				break;
			case LH: tree->bf = EH;
				taller = false;
				break;
			}
	}
}
///////////////////////////////////////////////////////////////////////////////////////////////////
template <class ItemType>
void RightBalance(TreeNode<ItemType> *& tree, bool & taller)
{
	TreeNode<ItemType> * rs = tree->right;
	TreeNode<ItemType> * ls;

	switch (rs->bf)
	{
	case RH:	tree->bf = rs->bf = EH;
		RotateLeft(tree);
		taller = false;
		break;
	case EH:	cerr << "Tree already balanced " << endl;
		break;
	case LH:	ls = rs->left;
		switch (ls->bf)
		{
		case RH:	tree->bf = LH;
			rs->bf = EH;
			break;
		case EH:	tree->bf = rs->bf = EH;
			break;
		case LH:	tree->bf = EH;
			rs->bf = RH;
			break;
		}
		ls->bf = EH;
		RotateRight(tree->right);
		RotateLeft(tree);
		taller = false;
	}
}
/////////////////////////////////////////////////////////////////////////////////////////


template <class ItemType>
void LeftBalance(TreeNode<ItemType> *& tree, bool & taller)
{
	TreeNode<ItemType> * ls = tree->left;
	TreeNode<ItemType> * rs;
	switch (ls->bf)
	{
	case LH:	tree->bf = ls->bf = EH;
		RotateRight(tree);
		taller = false;
		break;

	case EH:	cerr << "Tree already balanced " << endl;
		break;

	case RH:	rs = ls->right;
		switch (rs->bf)
		{
		case LH:	tree->bf = RH;
			ls->bf = EH;
			break;

		case EH:	tree->bf = ls->bf = EH;
			break;

		case RH:	tree->bf = EH;
			ls->bf = LH;
			break;
		}
		rs->bf = EH;
		RotateLeft(tree->left);
		RotateRight(tree);
		taller = false;
	}
}


template<class ItemType>
void TreeType<ItemType>::RetrieveItem(ItemType& item, bool& found)
{
	Retrieve(root, item, found);
}

template<class ItemType>
void Retrieve(TreeNode<ItemType>* tree, ItemType& item, bool& found)
{
	if (tree == NULL)
		found = false;
	else if (item < tree->info)
		Retrieve(tree->left, item, found);
	else if (item > tree->info)
		Retrieve(tree->right, item, found);
	else
	{
		item = tree->info;
		found = true;
	
	}
}


template<class ItemType>
void TreeType<ItemType>::Print()
{
	PrintTree(root);
}


template<class ItemType>
void TreeType<ItemType>::PrintTree(TreeNode<ItemType>* tree)
{
	if (tree != NULL)
	{
		PrintTree(tree->left);
		cout << "\t\t\t" << tree->info << " : BF: ";
		switch (tree->bf)
		{
		case 0:
			cout << " LH: ";
			break;
		case 1:
			cout << " EH: ";
			break;
		case 2:
			cout << " RH: ";
			break;
		}
		if (tree->right == NULL && tree->left == NULL)
		{
			cout << " LEAF ";
		}
		else if (tree->right == NULL)
		{
			cout << " LEFT: " << tree->left->info;
		}
		else if (tree->left == NULL)
		{
			cout << " RIGHT: " << tree->right->info;
		}
		else
		{
			cout << " LEFT: " << tree->left->info << " RIGHT: " << tree->right->info;
		}
		cout << endl;
		PrintTree(tree->right);
	}
}










