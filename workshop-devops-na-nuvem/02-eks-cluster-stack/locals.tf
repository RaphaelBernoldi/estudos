#Locals é uma forma de criar variáveis internas para o terraform,
# igual o variables, porém o variables é apenas para constantes e locals 
# pode ser alterado durante o código
#Locals são variáveis internas, ou seja, não são expostas para fora do terraform
#Locals são úteis para evitar repetição de código
locals {
  eks_oidc_provider_url = replace(aws_iam_openid_connect_provider.kubernetes.url, "https://", "")
}