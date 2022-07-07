# Caso precise instalar o vim
apt-get update </br>
apt-get install apt-file </br>
apt-file update</br>
apt-get install vim

# Documentação Jasmin
https://docs.jasminsms.com/en/latest/installation/index.html

# Executando docker-compose
cd /jaiminho/src/main/resources/Docker
docker-compose up

# Entrando no container do jasmin
sudo docker container exec -it jasmin /bin/bash

# Acesso ao jCli
host: 127.0.0.1 </br>
porta:	8990	</br>
admin_username:	jcliadmin </br>
senha do administrador:	jclipwd </br>

<b>telnet 127.0.0.1 8990

# Criando conector
jcli : smppccm -a 
> cid JAIMINHO_CONNECTOR </br>
> username jaiminho </br>
> password password </br>
> host 172.19.0.4 </br>
> port 2775  </br>
> submit_throughput 110 </br>
> ok 

# Iniciando conector
jcli : smppccm -1 JAIMINHO_CONNECTOR

# Criando rota
jcli : mtrouter -a
> type DefaultRoute </br>
> connector smppc(JAIMINHO_CONNECTOR) </br>
> rate 0.00 </br>
> ok

# Criando grupo
jcli : group -a
Adding a new Group: (ok: save, ko: exit)
>gid carteiros </br>
>ok 


# Criando usuário
jcli : user -a
> uid jaiminho </br>
> username jaiminho </br>
> gid carteiros </br>
> password password </br>
> ok


