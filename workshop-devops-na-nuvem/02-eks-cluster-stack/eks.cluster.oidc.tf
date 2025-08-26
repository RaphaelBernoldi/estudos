#https://oidc.eks.us-east-1.amazonaws.com/id/E753EC9A67EA215E6F05FC4F2FFCFA63

resource "aws_iam_openid_connect_provider" "kubernetes" {
  
  #Nessa linha a url que peguei acima via console, conseguimos pegar via terraform
  url = aws_eks_cluster.this.identity[0].oidc[0].issuer
  client_id_list = [
    "sts.amazonaws.com",
  ]
}