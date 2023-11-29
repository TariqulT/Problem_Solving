#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void preffixFunction(int * lps, char * ptt, int lenP){
	lps[0] = 0;
	int len = 0, index;
	for(index=1;index<lenP;index++){
		while(len>0 && ptt[len]!=ptt[index]){
			len = lps[len-1];
		}
		if(ptt[len]==ptt[index]){
			len = len+1;
		}
		lps[index] = len;
	}
}

int KMPSearch(char * text, int lenT, int lenP){
	int count = 0;
	int lps[lenP];
	preffixFunction(lps,text,lenP);
	int q=0, i;
	for(i=0;i<lenT;i++){
		while(q>0 && text[i]!=text[q]){
			q = lps[q-1];
		}
		if(text[i]==text[q]){
			q = q+1;
		}
		if(q==lenP){
			count++;
			q = 0;
		}
	}
	return count;
}

int main(){
	int n;
	scanf("%d",&n);
	while(n-->0){
		char st[100];
		scanf("%s",st);
		int lenT = strlen(st), i;
		for(i=0;i<lenT;i++){
			if(lenT%(i+1)==0){
				int count = KMPSearch(st,lenT,i+1);
				if(lenT/(i+1)==count){
                    if(n>0)
                        printf("%d\n\n",i+1);
                    else
                        printf("%d\n",i+1);
					break;
				}
			}
		}
	}

	return 0;
}
