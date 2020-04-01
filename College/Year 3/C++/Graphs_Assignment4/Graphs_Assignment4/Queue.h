#pragma once
template <class ItemType>
struct NodeType;

template <class ItemType>
class Queue
{
public:
	Queue();
	~Queue();
	void MakeEmpty();
	bool IsEmpty() const;
	void Enqueue(ItemType newItem);
	void Dequeue(ItemType& item);
	void PrintQ();
private:
	NodeType<ItemType>* qFront;
	NodeType<ItemType>* qRear;

};


template <class ItemType>
struct NodeType
{
	ItemType info;
	NodeType* next;
};


template <class ItemType>
Queue<ItemType>::Queue()
{
	qFront = NULL;
	qRear = NULL;
}

template <class ItemType>
Queue<ItemType>::~Queue()
{
	MakeEmpty();
}

template <class ItemType>
bool Queue<ItemType>::IsEmpty() const
{
	if (qFront == NULL)
		return true;
	else
		return false;
}

template <class ItemType>
void Queue<ItemType>::MakeEmpty()
{
	NodeType<ItemType>* temp;

	while (qFront != 0)
	{
		temp = qFront;
		qFront = qFront->next;
		delete temp;
	}
	qRear = NULL;
}

template <class ItemType>
void Queue<ItemType>::Enqueue(ItemType newItem)
{
	NodeType<ItemType>* newNode;
	newNode = new NodeType < ItemType >;

	newNode->info = newItem;
	newNode->next = NULL;
	if (qRear == NULL)
		qFront = newNode;
	else
		qRear->next = newNode;
	qRear = newNode;
}

template <class ItemType>
void Queue<ItemType>::Dequeue(ItemType& item)
{
	NodeType<ItemType>* temp;
	temp = qFront;
	item = qFront->info;
	qFront = qFront->next;

	if (IsEmpty())
		qRear = NULL;
	delete temp;

}


template <class ItemType>
void Queue<ItemType>::PrintQ()
{
	NodeType<ItemType>* temp;
	temp = qFront;
	while (temp != NULL)
	{
		cout << temp->info << " ";
		temp = temp->next;
	}
}