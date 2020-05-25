#Primeiro servidor

#Entrar na pasta de instalação do rabbit e realizar as seguinte configurações

set RABBITMQ_NODENAME=rabbit1

set RABBITMQ_NODE_PORT=5672

set RABBITMQ_SERVER_START_ARGS=-rabbitmq_management listener [{port,15672}]

rabbitmq-server start

#Segundo Servidor

set RABBITMQ_NODENAME=rabbit2

set RABBITMQ_NODE_PORT=5673

set RABBITMQ_SERVER_START_ARGS=-rabbitmq_management listener [{port,15673}]

rabbitmq-server start

#Juntar segundo servidor ao cluster do primeiro

rabbitmqctl -n rabbit2 stop_app

rabbitmqctl -n rabbit2 join_cluster rabbit1

rabbitmqctl -n rabbit2 start_app