# Cria o cluster que é onde ficaram os nodes

# Depois cria o node group que são agrupadores dos nodes, que: Um Node Group é um agrupamento de nodes que compartilham a mesma configuração, padronizando características como tipo/tamanho das instâncias, quantidade mínima e máxima de nós, regras de escalabilidade e outras definições comuns.



# Crio a rule do cluster que é onde configura o que me cluster pode fazer dentro da  aws, manipular subnets, logs, maquinas ec2 entre outras coisas

# Crio o node group iam que é onde configura o que um node group pode fazer dentro da aws

# O data funciona no terraform como uma query no banco de dados, onde fica responsável por ir lá no seu cloud provider e buscar o recurso que está precisando, no contexto desse projeto ele vai buscar os subnets que são necessárias para o eks


# Comandos
 - export AWS_PROFILE=workshopProfile
 - aws sts get-caller-identity


 # Após criar o cluster
  ## habilita o kubectl para se autenticar as credenciais do aws cli
 -  aws eks update-kubeconfig --name workshop-eks-cluster --region us-east-1

# Necessário habilitar o usuario que está sendo utilizado no aws cli para poder acessar o eks, o caminho para o procedimento é:
 - Entrar no console
 - Entrar no serviço eks
 - Aba access 
 - Click em create access entry
 - Add o usuario que está usando no workstation, opção standard, click em next
 - Add o policy name AmazonEksClusterAdminPolicy 
 - Click em Next e create

# Após o procedimento acima já da para listar os nodes localmente com o comando 
kubectl get nodes

# Para listar os pods localmente com o comando
kubectl get pods

# Após criar o ecr-repository é necessário fazer o login no ecr (O comando abaixo não precisa ser decorado, é só entrar no repository dentro do ecr e pegar o endereço de login clicando em view push commands)
aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 848175180062.dkr.ecr.us-east-1.amazonaws.com

# Geração da imagem do backend no docker
docker build -f backend/YoutubeLiveApp/Dockerfile -t 848175180062.dkr.ecr.us-east-1.amazonaws.com/workshop-ecr-repository/backend:v1.0 backend/YoutubeLiveApp/

# Pull da imagem do backend no ecr-registry
docker push 848175180062.dkr.ecr.us-east-1.amazonaws.com/workshop-ecr-repository/backend:v1.0 

# Geração da imagem do frontend no docker
docker build -f frontend/youtube-live-app//Dockerfile -t 848175180062.dkr.ecr.us-east-1.amazonaws.com/workshop-ecr-repository/frontend:v1.0 frontend/youtube-live-app/

# Pull da imagem do frontend no ecr-registry
docker push 848175180062.dkr.ecr.us-east-1.amazonaws.com/workshop-ecr-repository/frontend:v1.0 

# Para instanciar as imagens nos pods do kubernetes
 - Entrar na pasta 02-eks-cluster-stack/dnv-workshop-kubernetes$
 - kubectl apply -f backend/deployment.yaml -f backend/service.yaml
 - kubectl apply -f frontend/deployment.yaml -f frontend/service.yaml

 # Para não ser necessário passar um monte desses paramtros, ou até deixa-los dinamicos é comum usar o kustomize, ele já é integrado com o kubernetes e possibilita fazer esses processos, evitando ser obrigado a deixar a pipeline dinamica o que pode ser problematico e complexo
 


# Comandos uteis para kubectl
kubectl get nodes # para listar os nodes
kubectl get pods # para listar os pods
kubectl describe  pods  backend-deployment-694f67fd49-bdxrd # omando para descrever o pod
kubectl get pods --all-namespaces # Lista os namespaces
kubectl port-forward deploy/backend-deployment 8080:80 # cria um túneo da minha máquina local para o pod
kubectl port-forward pod/backend-deployment-694f67fd49-bdxrd 8080:80 outra alternativa me legal para fazer o mesmo



# Configuração OIDC
Essa configuração serve para autenticar alguma aplicação externa dentro da minha nuvem
