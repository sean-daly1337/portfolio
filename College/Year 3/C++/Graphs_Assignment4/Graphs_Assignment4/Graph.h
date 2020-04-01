#pragma once
#include "Stack.h"
#include "Queue.h"
//#include <deque>

template<class VertexType>
class GraphType
{
public:
	GraphType();
	GraphType(int maxV);
	~GraphType();
	int IndexIs(VertexType * vertices, VertexType vertex);
	void AddVertex(VertexType);
	void AddEdge(VertexType, VertexType, int);
	int WeightIs(VertexType, VertexType);
	void GetToVertices(VertexType, Queue<VertexType>&);
	void ClearMarks();
	void MarkVertex(VertexType);
	bool IsMarked(VertexType) const;
	void DepthFirstSearch(VertexType startVertex, VertexType endVertex);
	void BreadthFirstSearch(VertexType startVertex, VertexType endVertex);
	void print_Vs();
	void RemoveFromGraph(VertexType vertex_1, VertexType vertex_2);


private:
	int numVertices;
	int maxVertices;
	VertexType* vertices;
	int edges[50][50];
	bool* marks;
};


template<class VertexType>
GraphType<VertexType>::GraphType()
{
	numVertices = 0;
	maxVertices = 50;
	vertices = new VertexType[50];
	marks = new bool[50];
}

template<class VertexType>
GraphType<VertexType>::GraphType(int maxV)

{
	numVertices = 0;
	maxVertices = maxV;
	vertices = new VertexType[maxV];
	marks = new bool[maxV];
}

template<class VertexType>
GraphType<VertexType>::~GraphType()

{
	delete[] vertices;
	delete[] marks;
}

template<class VertexType>
void GraphType<VertexType>::AddVertex(VertexType vertex)
{
	bool flag = true;
	if (numVertices == 0)
	{
		vertices[numVertices] = vertex;
		for (int index = 0; index<numVertices; index++)
		{
			edges[numVertices][index] = 0;
			edges[index][numVertices] = 0;
		}
		numVertices++;
	}
	else
	{
		for (int i = 0; i < numVertices; i++)
		{
			if (vertices[i] == vertex)
				flag = false;

		}
		if (flag != false)
		{
			vertices[numVertices] = vertex;
			for (int index = 0; index<numVertices; index++)
			{
				edges[numVertices][index] = 0;
				edges[index][numVertices] = 0;
			}
			numVertices++;
		}
	}


}

template<class VertexType>
int GraphType<VertexType>::IndexIs(VertexType *vertices, VertexType vertex)

{
	int index = 0;
	while (!(vertex == vertices[index]))
		index++;
	return index;
}

template<class VertexType>
void GraphType<VertexType>::AddEdge(VertexType fromVertex, VertexType toVertex, int weight)

{
	int row;
	int col;
	row = IndexIs(vertices, fromVertex);
	col = IndexIs(vertices, toVertex);
	edges[row][col] = weight;
}

template<class VertexType>
int GraphType<VertexType>::WeightIs(VertexType fromVertex, VertexType toVertex)

{
	int row;
	int col;
	row = IndexIs(vertices, fromVertex);
	col = IndexIs(vertices, toVertex);
	return edges[row][col];
}

template<class VertexType>
void GraphType<VertexType>::GetToVertices(VertexType vertex, Queue<VertexType>& adjvertexQ)
{
	int fromIndex;
	int toIndex;

	fromIndex = IndexIs(vertices, vertex);
	for (toIndex = 0; toIndex<numVertices; toIndex++)
		if (edges[fromIndex][toIndex] != 0)
			adjvertexQ.Enqueue(vertices[toIndex]);
}


template<class VertexType>
void GraphType<VertexType>::DepthFirstSearch(VertexType startVertex, VertexType endVertex)

{
	Stack<VertexType> stack;
	Queue<VertexType> vertexQ;
	bool found = false;
	VertexType vertex;
	VertexType item;
	ClearMarks();
	stack.Push(startVertex);
	do
	{
		stack.Pop(vertex);
		if (vertex == endVertex)
		{
			cout << vertex;
			found = true;
		}
		else
		{
			if (!IsMarked(vertex))
			{
				MarkVertex(vertex);
				cout << vertex << endl;
				GetToVertices(vertex, vertexQ);
				while (!vertexQ.IsEmpty())
				{
					vertexQ.Dequeue(item);
					if (!IsMarked(item))
						stack.Push(item);
				}
			}
		}
	} while (!stack.IsEmpty() && !found);
	if (!found)
		cout << "Path not found." << endl;
}


template<class VertexType>
void GraphType<VertexType>::BreadthFirstSearch(VertexType startVertex, VertexType endVertex)

{
	Queue<VertexType> queue;
	Queue<VertexType> vertexQ;
	bool found = false;
	VertexType vertex;
	VertexType item;
	ClearMarks();
	queue.Enqueue(startVertex);
	do
	{
		queue.Dequeue(vertex);
		if (vertex == endVertex)
		{
			cout << vertex;
			found = true;
		}
		else
		{
			if (!IsMarked(vertex))
			{
				MarkVertex(vertex);
				cout << vertex << endl;
				GetToVertices(vertex, vertexQ);
				while (!vertexQ.IsEmpty())
				{
					vertexQ.Dequeue(item);
					if (!IsMarked(item))
						queue.Enqueue(item);
				}
			}
		}
	} while (!queue.IsEmpty() && !found);
	if (!found)
		cout << "Path not found." << endl;
}

template<class VertexType>
void GraphType<VertexType>::MarkVertex(VertexType vertex) {
	for (int i = 0; i < 7; i++)
	{
		if (vertex == *(vertices + i))
		{
			*(marks + i) = true;
			break;
		}
	}
}

template<class VertexType>
bool GraphType<VertexType>::IsMarked(VertexType vertex)const
{
	
	for (int i = 0; i < 7; i++)
	{
		if (vertex == *(vertices + i))
		{
			if (*(marks + i) == true)
				return *(marks + i);
			else
				return false;
		}
	}
	return false;
}

template<class VertexType>
void GraphType<VertexType>::ClearMarks()
{
	for (int i = 0; i < numVertices; i++)
		marks[i] = false;
}

template<class VertexType>
void GraphType<VertexType>::print_Vs()
{
	ClearMarks();
	for (int i = 0; i < numVertices; i++)
	{
		for (int y = 0; y < numVertices; y++)
		{
			if (edges[i][y] > 0)
			{
				cout << *(vertices + i) << " to " << *(vertices + y) << "\t" << WeightIs(*(vertices + i), *(vertices + y)) << endl;
			}
		}
	}


}

template<class VertexType>
void GraphType<VertexType>::RemoveFromGraph(VertexType vertex_1, VertexType vertex_2)
{
	int row = IndexIs(vertices, vertex_1);
	int col = IndexIs(vertices, vertex_2);
	edges[row][col] = 0;
}