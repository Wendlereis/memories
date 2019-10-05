#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "pilha.h"

//Função que monta os títulos da aplicação
void PrintHeader(char *title){
	printf("\n-------------------- %s --------------------\n", title);
}

//Função que atribui no vetor de lancamentos as equipes participantes
void CadastrarEquipes(Lancamento *lancamentos, int length){
	int i = 0;
	int j = 1;
	int res = 0;
	while(i < length){
	printf("\n---------- Equipe %d ----------\n", j);
		//Loop que valida o que o usuário digita
		do{
			fflush(stdin);
			puts("\nInforme o nome da equipe: ");
			gets(lancamentos[i].nome);
			if(strcmp(lancamentos[i].nome, "") == 0){
				puts("O nome da equipe nao pode ser nulo. Tente novamente!");
			}else {
				if(verificaNome(lancamentos, length, lancamentos[i].nome, i) == 1){
					puts("Este nome ja esta sendo utilizado, por favor informe outro nome.");
				}
			}
		} while(strcmp(lancamentos[i].nome, "") == 0 || verificaNome(lancamentos, length, lancamentos[i].nome, i) == 1);
		
		//Loop que valida o que o usuário digita
		do{
			fflush(stdin);
			puts("\nInforme a quantidade de integrantes da equipe: ");
			res = scanf("%d",&lancamentos[i].componentes);
			if(lancamentos[i].componentes <= 0 || res == 0){
				puts("\nPor Favor, digite um numero inteiro positivo.\n");
			}
		} while (lancamentos[i].componentes <= 0 || res == 0);
		
		//Situação Default de cada equipe cadastrada é 0 que significa que não foi efetuado nenhum lançamento
		lancamentos[i].situacao = 0;
		
		i++;
		j++;
		printf("\n------------------------------\n", i);
	}
}

int procuraEquipe(Lancamento *lancamentos,  int length, char *nomeGrupo){
	int i;
	for(i = 0; i < length; i++){
		if(lancamentos[i].situacao == 0){
			if(strcmp(lancamentos[i].nome, nomeGrupo) == 0)
			return i;
		}
	}
	return -1;
}

void CadastrarLancamentosEquipes(Lancamento *lancamentos, int length){
	int i, res = 0;
	int presentes = 0;
	int existeEquipe = -1;
	char nomeEq[NOME];
	int lancou = 0;
	do{
		printf("\n%d Equipes ainda nao fizeram o lancamento.\n", length - i);
		do{
			fflush(stdin);
			puts("\nInforme o nome da equipe que esta realizando o lancamento: ");
			gets(nomeEq);
			if((nomeEq, "") == 0){
				puts("\nO nome da equipe nao pode ser nulo. Tente novamente!");
			} else {
				existeEquipe = procuraEquipe(lancamentos, length, nomeEq);
				if(existeEquipe > -1){
					printf("\n- Lancamento da Equipe - %s", lancamentos[existeEquipe].nome);
					do{
						fflush(stdin);
						puts("\nInforme a quantidade de integrantes da equipe presentes: ");
						res = scanf("%d",&presentes);
						if(presentes < 0 || res == 0){
							puts("\nPor Favor, digite um numero inteiro positivo.\n");
						}
					} while (presentes < 0 || res == 0);
					
					if(presentes != lancamentos[existeEquipe].componentes){
						printf("\nEquipe %s esta DESCLASSIFICADA!\n", lancamentos[existeEquipe].nome);
						printf("\nMOTIVO: Nem todos os componentes do grupo estao presentes ou o numero de componentes nao coincide.\n");
						lancamentos[existeEquipe].situacao = -1;
						i++;
					} else {
						do{
							fflush(stdin);
							puts("Lancamento ocorreu com sucesso ? - (Sim = 1 / Nao = 0)");
							res = scanf("%d",&lancou);
							if(res == 0 || lancou < 0 || lancou > 1){
								puts("\nResponda apenas com 1 - Sim | 0 - Nao");
							} else {
								if(lancou == 1) {
									do{
										fflush(stdin);
										puts("\nInforme a distancia que o alvo atingiu: ");
										res = scanf("%f",&lancamentos[existeEquipe].distancia);
										if(lancamentos[existeEquipe].distancia <= 0 || res == 0){
											puts("\nPor Favor, digite um numero positivo.\n");
										}
									} while (lancamentos[existeEquipe].distancia <= 0 || res == 0);
										
										
									do{
										fflush(stdin);
										puts("\nInforme a altitude que o alvo atingiu: ");
										res = scanf("%f",&lancamentos[existeEquipe].altitude);
										if(lancamentos[existeEquipe].altitude <= 0 || res == 0){
											puts("\nPor Favor, digite um numero positivo.\n");
										}
									} while (lancamentos[existeEquipe].altitude <= 0 || res == 0);
									
									lancamentos[existeEquipe].situacao = 1;
									i++;
								} else if(lancou == 0){
									printf("\nEquipe %s esta DESCLASSIFICADA!\n", lancamentos[existeEquipe].nome);
									printf("\nMOTIVO: Lancamento nao efetuado com sucesso.\n");
									lancamentos[existeEquipe].situacao = -1;
									i++;
								}
							}
						} while(res == 0 || lancou < 0 || lancou > 1);
					}
				} else {
					printf("\nEquipe %s ja fez seu lancamento ou nao foi cadastrada, Tente novamente!\n", nomeEq);
				}
			}
		} while(strcmp(nomeEq, "") == 0 || existeEquipe <= -1);
	} while(i < length);
}

void GetMelhorLancamento(Lancamento *lancamentos,int length, Podio *podio){
	int i;
	float meDist = 999999999999999999;
	float maAlt = -999999999999999999;
	Lancamento bestLancamento;
	for(i = 0; i < length; i++){
		if(lancamentos[i].situacao == 1){
			if(lancamentos[i].distancia < meDist){
				bestLancamento = lancamentos[i];
				meDist = lancamentos[i].distancia;
				maAlt = lancamentos[i].altitude;
				lancamentos[i].situacao = 0;
			} else {
				 if(lancamentos[i].distancia == meDist) {
				 	if(lancamentos[i].altitude > maAlt){
				 		bestLancamento = lancamentos[i];
						meDist = lancamentos[i].distancia;
						maAlt = lancamentos[i].altitude;
					    lancamentos[i].situacao = 0;
					} else {
						if(lancamentos[i].altitude == maAlt) { 
							bestLancamento = lancamentos[i];
							meDist = lancamentos[i].distancia;
							maAlt = lancamentos[i].altitude;
							lancamentos[i].situacao = 0;
						}
					}
				 }
			}
		}
		
		PUSH(podio, bestLancamento);
	}
}

int qtdLancamentosCertos(Lancamento *lancamentos, int length) {
	int i;
	int qtd = 0;
	for(i = 0; i < length; i++){
		if(lancamentos[i].situacao == 1){
			qtd++;
		}
	}
	
	return qtd;
}

int verificaNome(Lancamento *lancamentos, int length, char *nome, int indice){
	int i;
	for(i = 0; i < length; i++){
		if(i != indice){
			if(strcmp(lancamentos[i].nome, nome) == 0){
				return 1;
			}
		}
	}
	return 0;	
}
//Função principal da aplicação
int main(){
	//Declaração de variáveis
	int i;
	int qtdEquipes = 0;
	int totalPodio = 0;
	Podio podio; 
	INIT(&podio);
	char nome[NOME];
	float distancia;
	float altitude;
	
	PrintHeader("SPACE CUP");
	//Loop que valida o que o usuário digita
	do{
		fflush(stdin);
		//Usuário informa a quantidade de equipes que vão participar da competição
		puts("\nInforme a quantidade de equipes participantes: ");
		scanf("%d", &qtdEquipes);
		if(qtdEquipes <= 0)
			puts("\nPor Favor, digite um numero inteiro positivo.\n");
	}while (qtdEquipes <= 0);
	
	Lancamento lancamentos[qtdEquipes];
	
	PrintHeader("CADASTRO DE EQUIPES");
	//Chama a função que cadastra as equipes participantes
	CadastrarEquipes(lancamentos, qtdEquipes);
	PrintHeader("FIM DO CADASTRO DE EQUIPES");
	PrintHeader("LANCAMENTOS");
	//Chama a função que cadastra a situacao dos lancamentos nos grupos
	CadastrarLancamentosEquipes(lancamentos, qtdEquipes);
	PrintHeader("FIM DOS LANCAMENTOS");
	totalPodio = qtdLancamentosCertos(lancamentos, qtdEquipes);

	if(totalPodio > 3){
		totalPodio = 3;
	}
	if(totalPodio > 0){
		for(i = 0; i < totalPodio; i++) {
			GetMelhorLancamento(lancamentos, qtdEquipes, &podio);
		}	
	}
	
	PrintHeader("VENCEDORES");
	if(totalPodio == 0){
		puts("As equipes nao conseguiram executar nenhum lancamento com sucesso.");
	}
	
	for(i = 0; i < totalPodio; i++) {
		printf("\nEm %d lugar ", i+1);
		POP(&podio, nome, &distancia, &altitude);
		printf("\n\n%s Equipe: ", &nome);
		printf("\n\n%f Distancia: ",distancia);
		printf("\n\n%f Altitude: ",altitude);
		
	}	
}

