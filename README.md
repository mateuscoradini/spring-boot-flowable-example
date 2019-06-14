Spring Flowable Example BPM App

<a href="https://www.flowable.org">
    <img src="https://www.flowable.org/img/logo_hero.png" alt="Flowable logo" title="Flowable" align="right" height="60" />
</a>


Spring Boot 2.1, Spring Flowable 6.4.1
======================
- [Installation](#installation)
- [Exemplificando](#exemplificando)

## Table of content
## Installation

```
  $ mvn clean install 
  $ mvn spring-boot:run

```

## Exemplificando:

Simplificando, um BPM é um conjunto de tarefas que, uma vez concluídas em uma ordem definida, realizam um objetivo definido. Cada tarefa em um Processo de Negócios tem entradas e saídas claramente definidas. Essas tarefas podem exigir intervenção humana ou podem ser completamente automatizadas.

* Todo o processo é envolto em uma tag chamada "processo", que, por sua vez, faz parte de uma tag chamada "definições"
* Um processo consiste em eventos, fluxos, tarefas e gateways
* Um evento é um evento inicial ou final
* Um fluxo (neste exemplo, um fluxo de sequência) conecta outros elementos como eventos e tarefas
* Tarefas são onde o trabalho real é feito; estas podem ser “tarefas do usuário” ou “tarefas de serviço”, entre outras
* Uma tarefa do usuário requer que um usuário humano interaja com a API do Flowable e execute uma ação
* Uma tarefa de serviço representa uma tarefa automática, que pode ser uma chamada para uma classe Java ou até mesmo uma chamada HTTP
* Um gateway é executado com base no atributo “aprovado”, no exemplo do repositorio; isso é conhecido como uma variável de processo e veremos como defini-las mais tarde.

### ArticleWorkFlowService: 
* RuntimeService para instanciar o processo para um envio específico
* TaskService para consultar e atualizar tarefas
* Agrupando todas as chamadas do banco de dados em transações suportadas pelo Spring
* Armazenando detalhes como autor e URL, entre outros, em um Mapa, e salvando com a instância do processo; estes são conhecidos como variáveis ​​de processo, e podemos acessá-los dentro de uma definição de processo, como vimos anteriormente.






