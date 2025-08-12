# Criar vpc
## Definir cidr block exemplo:
10.0.0.0/24 Isso quer dizer a quantidade de IPs que vou querer disponibilizar na minha rede e isso é feito conforme o cálculo abaixo:
2 ^ (bits - ultimo_numero)
2 ^ (32 - 24)
2 ^ 8
256
Minha rede terá 256 IPs

# Criar Um internet gateway
# Criar subnet pública
- Uma subnet publica é a que tem acesso de entrada e saida para a internet (Isso se faz associado o endereço defaul 0.0.0.0/0 a um internet-gateway)
- Os ips que serão disponibilizados dentro dela será definido via cidr block
Um exemplo: 10.0.0.0/26 -> Essa subnet terá disponível para ela os ips entre 10.0.0.0 até 10.0.0.64

# Criar uma route table
# Associas o internet gateway a subnet
# Configura security group (para configurar as portas de entrada)


# Criar um nat gateway (Precisa de um elastic IP public para que o nat possa fazer o roteamento de saida do trafego para o mundo)
# Criar rede privada
- Uma subnet privada é a que tem acesso de saida para a internet mas não tem de entrada(Isso se faz associado o endereço defaul 0.0.0.0/0 a um nat-gateway)
- Os ips que serão disponibilizados dentro dela será definido via cidr block
Um exemplo: 10.0.0.0/26 -> Essa subnet terá disponível para ela os ips entre 10.0.0.0 até 10.0.0.64

# Criar um nat gateway (Precisa de um elastic IP public para que o nat possa fazer o roteamento de saida do trafego para o mundo)
# Criar uma route table
# Associas o internet gateway a subnet
# Configura security group (para configurar as portas de entrada)