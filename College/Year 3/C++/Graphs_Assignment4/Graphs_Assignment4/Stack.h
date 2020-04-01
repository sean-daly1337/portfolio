#pragma once
template <class ItemType>
struct SNodeType;


template <class ItemType>
class Stack
{
public:
	Stack();
	~Stack();
	bool IsEmpty() const;
	void MakeEmpty();
	void Push(ItemType item);
	void Pop(ItemType& item);
	void PrintStack();
private:
	SNodeType<ItemType>* top;
};

template <class ItemType>
struct SNodeType
{
	ItemType info;
	SNodeType<ItemType>* next;
};

template <class ItemType>
Stack<ItemType>::Stack()
{
	top = NULL;
}

template <class ItemType>
Stack<ItemType>::~Stack()
{
	SNodeType<ItemType>* temp;
	while (top != NULL)
	{
		temp = top;
		top = top->next;
		delete temp;
	}
}

template <class ItemType>
bool Stack<ItemType>::IsEmpty() const
{
	if (top == NULL)
		return true;
	else
		return false;
}

template <class ItemType>
void Stack<ItemType>::MakeEmpty()
{
	SNodeType<ItemType>* temp;
	while (top != NULL)
	{
		temp = top;
		top = top->next;
		delete temp;
	}
}

template <class ItemType>
void Stack<ItemType>::Push(ItemType item)
{
	SNodeType<ItemType>* loc;
	loc = new SNodeType <ItemType>;
	loc->info = item;
	loc->next = top;
	top = loc;
}

template <class ItemType>
void Stack<ItemType>::PrintStack()
{
	SNodeType<ItemType>* temp;
	temp = top;

	while (temp != NULL)
	{
		cout << temp->info << endl;
		temp = temp->next;

	}
}

template <class ItemType>
void Stack<ItemType>::Pop(ItemType& item)
{
	SNodeType<ItemType>* temp;
	temp = top;
	item = top->info;
	top = top->next;

	delete temp;

}