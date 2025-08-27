# Documentação da aws para instalar o load balancer controller com o helm
# https://docs.aws.amazon.com/eks/latest/userguide/lbc-helm.html

#Abaixo para facilitar a instalação do load balancer controller, vamos usar o provider helm, os parametros são baseados na documentação acima
# https://registry.terraform.io/providers/hashicorp/helm/latest/docs/resources/release

resource "helm_release" "load_balancer" {
  name       = "aws-load-balancer-controller"
  repository = "https://aws.github.io/eks-charts"
  chart      = "aws-load-balancer-controller"
  version    = "1.13.0"
  namespace  = "kube-system"

  set {
    name  = "clusterName"
    value = aws_eks_cluster.this.name
  }

  set {
    name  = "serviceAccount.create"
    value = true
  }

  set {
    name  = "vpcId"
    value = data.aws_vpc.this.id
  }

  set {
    name  = "serviceAccount.name"
    value = "aws-load-balancer-controller"
  }

  set {
    name  = "region"
    value = var.auth.region
  }
  set {
    name  = "serviceAccount.annotations.eks\\.amazonaws\\.com/role-arn"
    value = aws_iam_role.load_balancer.arn
  }
  set {
    name  = "region"
    value = var.auth.region
  }
}
