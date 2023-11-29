#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define white 0
#define gray 1
#define size 1001
int graph[size][size], color[size], distance[size], predecessor[size];
char Node[size][10];
int N;

void printPath(int des){
	if(predecessor[des] == -1){
		return;
	}
	else{
		printPath(predecessor[des]);
		printf("%s %s\n",Node[predecessor[des]],Node[des]);
	}
}

int map(char node[]){
	int i;
	for(i=1;i<N;i++){
		if(strcmp(Node[i],node)==0){
			return i;
		}
	}
	strcpy(Node[N++],node);
	return N-1;
}

int main(){
	int edge, i, j, first = 1;
	int blank_line = 0;
	while(fscanf(stdin,"%d",&edge)!=EOF){
		for(i=1;i<size;i++){
			for(j=1;j<size;j++){
				graph[i][j] = 0;
			}
		}

		char city1[10], city2[10];
		N = 1;
		for(i=1;i<=edge;i++){
			fscanf(stdin,"%s%s",city1,city2);
			int c1 = map(city1);
			int c2 = map(city2);
			graph[c1][c2] = 1;
			graph[c2][c1] = 1;
		}
		int queue[size], head, tail;
		head = tail = 1;

		fscanf(stdin,"%s%s",city1,city2);
		int source = map(city1);
		int destination = map(city2);

		int vertex = N-1;

		for(i=1;i<=vertex;i++){
			color[i] = white;
			distance[i] = 10000;
			predecessor[i] = -1;
		}
		
		color[source] = gray;
		distance[source] = 0;
		queue[head++] = source;

		while(head!=tail){
			int u = queue[tail++];
			int v;
			for(v=1;v<=vertex;v++){
				if(graph[u][v]==1&&color[v]==white){
					color[v] = gray;
					distance[v] = distance[u]+1;
					predecessor[v] = u;
					queue[head++] = v;
				}
			}
		}
		if(blank_line){
			printf("\n");
		}
		blank_line = 1;
		if(color[destination]==white){
			printf("No route\n");
		}
		else{
			printPath(destination);
		}
	}

	return 0;
}