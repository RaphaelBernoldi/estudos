# 1. Criar usuario com policy adminstratorAccess sem acesso ao console
## 1.2 Gerar o arquivo access key em create-access-key
## 1.3 Fazer o download do .csv e adicionar na pasta .aws
## 1.4 Pegue os dados de credential-key e access-key, gere um arquivo no padrão https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/credentials-temporary.html cole os dados no arquivo e coloquei o arquivo na pasta ~/.aws
## 1.5 Para apontar em qual conta quero trabalhar declaro a variável export AWS_PROFILE=workshopProfile (O nome é o profile do arquivo que vem em conchetes)
## 1.6 O comando aws sts get-caller-identity mostra em qual conta irá acontecer suas alterações


# 2. Criar a role para que o possamos associar ao usuário e fazer as alterações sem precisar colocar access-key e secret-key no código e possívelmente ser vazado no github, com isso a própria role faz a gestão das credenciais

# 3. Entra na pasta da stack e executa o comando terraform init (similar ao npm install)

