#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define NOME 50

typedef struct lancamento {
	char nome[NOME];
	int componentes;
	float distancia;
	float altitude;
}Lancamento;

struct no {
	Lancamento lancamento;
	struct no *prox;
};

typedef struct no* podio; 

void INIT(podio *inicio, podio *fim){
	*inicio = NULL;
	*fim = NULL;
}

int IsEmpty(podio inicio, podio fim){
	if((inicio==NULL) && (fim == NULL)){
		return (1);
	} else {
		return (0);
	}
}


void ENQUEUE(podio *inicio, podio *fim, Lancamento lancamento){
	podio aux;
	aux = (podio) malloc(sizeof(struct no));
	if(aux == NULL){
		puts("Não é possivel alocar mais espaco na fila.");
	}else{
		aux->lancamento = lancamento;
		aux->prox = NULL;
	if(IsEmpty(*inicio,*fim)){
  		*inicio=aux;
  	}else{
		(*fim)->prox=aux;
	}
   		*fim=aux;
	}
}

int DEQUEUE(podio *inicio, podio *fim, Lancamento *lancamento){
	podio aux;
	aux = *inicio;
	if(!IsEmpty(*inicio,*fim)){
		*lancamento = (*inicio)->lancamento;
		*inicio=(*inicio)->prox;
		if(*inicio == NULL){
			*fim == NULL;
		free(aux);
		return(1);
		}else{
			puts("Fila vazia.");
			return(0);
		}
	}
}

