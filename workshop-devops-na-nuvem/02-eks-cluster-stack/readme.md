# Cria o cluster que é onde ficaram os nodes

# Depois cria o node group que são agrupadores dos nodes, que: Um Node Group é um agrupamento de nodes que compartilham a mesma configuração, padronizando características como tipo/tamanho das instâncias, quantidade mínima e máxima de nós, regras de escalabilidade e outras definições comuns.



# Crio a rule do cluster que é onde configura o que me cluster pode fazer dentro da  aws, manipular subnets, logs, maquinas ec2 entre outras coisas

# Crio o node group iam que é onde configura o que um node group pode fazer dentro da aws

# O data funciona no terraform como uma query no banco de dados, onde fica responsável por ir lá no seu cloud provider e buscar o recurso que está precisando, no contexto desse projeto ele vai buscar os subnets que são necessárias para o eks


