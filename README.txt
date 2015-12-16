-------- Requisitos AspectJ --------

1) Pointcut
- Implementado no arquivo Persistence.aj, linhas 30 a 34. 

2) Advice: before, after returning, around
	2.1) before
	- Implementado no arquivo Persistence.aj, linha 65.
	- Implementado no arquivo MainAspects.aj, linha 52.
		
	2.2) after returning
	- Implementado no arquivo Persistence.aj, linha 39.
		
	2.3) around
	- Implementado no arquivo MainAspects.aj, linha 20.
		
3) Declare soft 
- Implementado no arquivo MainAspects, linha 14.

4) Declare parents
- Implementado no arquivo StudentAspects.aj, linha 10.

5) Override com around
- Implementado no arquivo MainAspects.aj, linha 20.

6) Intertype-declarations
- Implementdo no arquivo MainAspects.aj, linha 37.

-------- Explicação dos motivos --------

--- Requisitos 1, 2.1 (primeiro item) e 2.2 ---

O programa original não possui persistência alguma, logo, todos os dados salvos são perdidos, para resolver esse problema implementamos a persistência dos dados utilizando aspectJ.
Primeiramente criamos dois pointcuts, um que intercepta um novo cadastro e um que intercepta o início do programa.
Após isso, criamos um advice after returning que utiliza o pointcut que intercepta o novo cadastro, para podermos salvar esse novo dado em um arquivo de "banco de dados", e também um advice before que utiliza o pointcut que verifica o início do programa para poder ler o arquivo de "banco de dados" e carregar todos os dados já salvos para a memória do sistema antes do mesmo iniciar.

--- Requisitos 2.3, 3 e 5 ---

O programa original não possui a implementação do método registerTeacher e lança uma exceção NotImplementedException, nesse projeto nós possuímos o código fonte, mas assumindo que não o possuíssemos, não seria possível utilizar o método, para contornar o problema nós primeiramente "tiramos" a necessidade de tratar a exceção lançada quando o método é chamado, utilizando declare soft, e também substituímos a implementação do método utilizando um advice around. Nessa utilização do around nós tanto fizemos um override do método original, como também fizemos uma utilização do mesmo, ou seja, dois requisitos.

--- Requisitos 2.1 (segundo item) e 6 ---

O programa original não mostra nenhuma mensagem de boas-vindas, para deixar o sistema mais amigável, primeiramente injetamos o método estático printWelcome na classe Main utilizando intertype-declaration e, após isso, com o uso de um advice before, antes do ínicio do sistema nós chamamos esse método, mostrando assim a mensagem inicial.

--- Requisito 4 ---
Esse item não tem nenhuma motivação além de passar na cadeira.
