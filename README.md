
# remote-method-invocation

Universidade do Estado de Santa Catarina - UDESC

Curso: Tecnologia em Análise e Desenvolvimento de Sistemas - TADS

Disciplina: Sistemas Distribuídos

## Serviço utilizando Comunicação Inter-processos através de Remote Method Invocation - RMI

## Requisitos 
  * Java 7

## Instruções para compilação

1o.) Compilar todas as classes Java com o seguinte comando:

    javac *.java

## Instruções para execução

1. Executar o Servidor Mestre:

    java -cp . ServidorMestre

2. Executar o Servidor, passando os parâmetros nome do serviço, porta, endereço IP da máquina, respectivamente, por exemplo:

  2.1. Exemplo 1: `java -cp . Servidor Server1 1234 192.168.0.11`

  2.1. Exemplo 2: `java -cp . Servidor Server2 4321 192.168.0.11`

3. Execute a aplicação cliente:

    java -cp . Cliente

## Instruções para testes 

1. Ecoar algumas mensagems e visualizar o histórico.
2. Derrubar o Server1 e tentar ecoar mensagens.
3. Derrubar o Cliente, executá-lo novamente e visualizar o histórico.
