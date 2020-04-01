// Graphs_Assignment2.cpp : Defines the entry point for the console application.
// Sean Daly / K00228585

#include "stdafx.h"
#include "Graph.h"
void addFlight();
void search();
void deleteFromGraph();
using namespace std;
GraphType<string> G = GraphType<string>();



int main()
{
	G.AddVertex("Shannon");
	G.AddVertex("Chicago");
	G.AddVertex("Dublin");
	G.AddVertex("Denver");
	G.AddVertex("Houston");
	G.AddVertex("Gatwick");
	
	G.AddEdge("Shannon", "Houston", 300);
	G.AddEdge("Shannon", "Dublin", 500);
	G.AddEdge("Dublin", "Shannon", 700);
	G.AddEdge("Dublin", "Denver", 900);
	G.AddEdge("Dublin", "Chicago", 1200);
	G.AddEdge("Chicago", "Denver", 1050);
	G.AddEdge("Denver", "Chicago", 1000);
	G.AddEdge("Denver", "Gatwick", 750);
	G.AddEdge("Gatwick", "Houston", 850);
	G.AddEdge("Houston", "Gatwick", 150);
	
	

	int option;
	do {
		cout << endl << endl;
		cout << "\t\t\t   ASSIGNMENT 2 - GRAPHS (K00228585/SEANDALY)" << endl;
		cout << "\t\t\t   .........................................." << endl;
		cout << "\t\t\t1) Add New Flight. " << endl;
		cout << "\t\t\t2) Seek Flight. " << endl;
		cout << "\t\t\t3) Delete. " << endl;
		cout << "\t\t\t4) Print Flights. " << endl;
		cout << "\t\t\t5) Exit. " << endl;
		cout << "\t\t\t  " << endl;
		cout << "\t\t\t   Enter Option:  ";
		cin >> option;
		cout << endl << endl;

		switch (option)
		{

		case 1:
			addFlight();
			break;

		case 2:
			search();
			break;

		case 3:
			deleteFromGraph();
			break;

		case 4:
			G.print_Vs();
			break;

		case 5:
			break;

		default:
		{
			cout << " \t\t\t Invalid option " << endl;
			break;
		}
		}
	} while (option != 5);
	return 0;
}

void addFlight()
{
	string depart;
	string arrival;
	int distance;

	cout << "\t\t\t Enter Departure Airport: ";
	cin >> depart;
	cout << "\t\t\t Enter Arrival Airport: ";
	cin >> arrival;
	cout << "\t\t\t Enter Distance: ";
	cin >> distance;

	G.AddVertex(arrival);
	G.AddVertex(depart);
	G.AddEdge(depart, arrival, distance);



}

void search()
{
	string depart;
	string arrival;

	cout << "\t\t\t Enter Departure Airport: ";
	cin >> depart;
	cout << "\t\t\t Enter Arrival Airport: ";
	cin >> arrival;

	G.DepthFirstSearch(depart, arrival);

}

void deleteFromGraph()
{
	string depart;
	string arrival;

	cout << "\t\t\t Enter Departure Airport: ";
	cin >> depart;
	cout << "\t\t\t Enter Arrival Airport: ";
	cin >> arrival;

	G.RemoveFromGraph(depart, arrival);

}