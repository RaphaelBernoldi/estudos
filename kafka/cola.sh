#Instalation
#Downlaod 
#https://www.apache.org/dyn/closer.cgi?path=/kafka/2.5.0/kafka_2.12-2.5.0.tgz

#Documentation
#http://kafka.apache.org/quickstart

tar -xzf kafka_2.12-2.5.0.tgz

#commands_utils
#start
./bin/zookeeper-server-start.sh config/zookeeper.properties
./bin/kafka-server-start.sh config/server.properties 

#Lista topicos
./kafka-topics.sh --list --bootstrap-server localhost:9092

#Descreve topicos
./kafka-topics.sh --bootstrap-server localhost:9092 --describe

#cria topicos
./kafka-topics.sh --bootstrap-server localhost:9092 --create --topic NOME_TOPIC

#Cria mensagem em um topico
./kafka-console-producer.sh --bootstrap-server localhost:9092 --topic LOJA_NOVO_PEDIDO


#Consome mensagem de um topico
./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic LOJA_NOVO_PEDIDO --from-beginning

