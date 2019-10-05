#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define NOME 50

typedef struct lancamento {
	char nome[NOME];
	int componentes;
	float distancia;
	float altitude;
	int situacao;
}Lancamento;

struct sucesso {
	char nome[NOME];
	float distancia;
	float altitude;
	struct sucesso *prox;
};

typedef struct sucesso* Podio; 

void INIT(Podio *topo){
	*topo = NULL;
}

int IsEmpty(Podio topo){
	if(topo == NULL){
		return 1;
	}	
	return 0;
}

void PUSH(Podio *topo, Lancamento lancamento){
	Podio novo;
	novo = (Podio)malloc(sizeof(struct sucesso));
	if(novo != NULL){
		strcpy(novo->nome,lancamento.nome);
		novo->distancia = lancamento.distancia;
		novo->altitude = lancamento.altitude;
		novo->prox = *topo;
		*topo = novo;
	} else {
		puts("Pilha cheia! \n");
	}
}

int POP(Podio *topo, char *nome, float *distancia, float *altitude){
	Podio aux;
	aux = *topo;
	if(IsEmpty(*topo) == 0){
		strcpy(nome, aux->nome);
		*distancia = aux->distancia;
		*altitude = aux->altitude;
		*topo = aux->prox;
		free(aux);
		return(1);
	} else {
	   printf("Pilha vazia!");
       return(0);
	}
}
