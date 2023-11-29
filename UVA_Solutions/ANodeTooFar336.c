#include <stdio.h>
#include <stdlib.h>

#define white 0
#define gray 1

int graph[40][40], color[40], d[40];

int getVertexNo(int node[], int num, int *vtx){
	int i;
	for(i=1;i<=(*vtx);i++){
		if(node[i]==num){
			return i;
		}
	}
	node[++(*vtx)] = num;
	return (*vtx);
}

void bfs(int source, int vtx){
	int i, v;
	for(i=1;i<=vtx;i++){
		color[i] = white;
		d[i] = 10000;
	}
	color[source] = gray;
	d[source] = 0;
	int queue[vtx+1], head=0, tail=0;
	queue[head++] = source;
	while(head!=tail){
		int u = queue[tail++];
		for(v=1;v<=vtx;v++){
			if(graph[u][v]==1&&color[v]==white){
				color[v] = gray;
				d[v] = d[u]+1;
				queue[head++] = v;
			}
		}
	}
}

int main(){
	int test = 1;
	while(1){
		int i, j, a, b;
		int edge;
		scanf("%d",&edge);
		if(edge==0){
			break;
		}
		int node[40], vtx=0;
		for(i=0;i<40;i++){
			for(j=0;j<40;j++){
				graph[i][j] = 0;
			}
		}
		for(i=0;i<edge;i++){
			scanf("%d%d",&a,&b);
			int vtx1 = getVertexNo(node,a,&vtx);
			int vtx2 = getVertexNo(node,b,&vtx);
			graph[vtx1][vtx2] = 1;
			graph[vtx2][vtx1] = 1;
		}
		while(1){
			int source, dis;
			scanf("%d%d",&source,&dis);
			if(source==0&&dis==0){
				break;
			}
			source = getVertexNo(node,source,&vtx);
			bfs(source,vtx);
			int count = 0;
			for(i=1;i<=vtx;i++){
				if(d[i]>dis){
					count++;
				}
			}
			printf("Case %d: %d nodes not reachable from node %d with TTL = %d.\n",test++,count,node[source],dis);
		}
	}

	return 0;
}