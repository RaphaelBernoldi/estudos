variable "remote_backend" {
  type = object({
    s3_bucket = string
  })

  default = {
    s3_bucket = "workshop-s3-state-locking-backend-bucket"
  }
}

variable "tags" {
  type = map(string)
  default = {
    "Project"     = "workshop-devops-na-nuvem"
    "Environment" = "Dev"
    "Owner"       = "raphael"
  }
}

variable "auth" {
  type = object({
    assume_role = string
    region      = string
  })
  default = {
    assume_role = "arn:aws:iam::848175180062:role/workshop-role"
    region      = "us-east-1"
  }
}

variable "eks_cluster" {
  type = object({
    name                      = string
    authentication_mode       = string
    version                   = string
    enabled_cluster_log_types = list(string)
    node_group_name           = string
    node_group_instance_type  = list(string)
    node_group_capacity_type  = string
    node_group_scaling_config = object({
      desired_size = number
      max_size     = number
      min_size     = number
    })
  })

  default = {
    name                      = "workshop-eks-cluster"
    authentication_mode       = "API_AND_CONFIG_MAP"
    version                   = "1.31"
    enabled_cluster_log_types = ["api", "audit", "authenticator", "controllerManager", "scheduler"]
    node_group_name           = "workshop_eks_node_group"
    node_group_instance_type  = ["t3.micro"]
    node_group_capacity_type  = "ON_DEMAND"
    node_group_scaling_config = {
      desired_size = 2
      max_size     = 2
      min_size     = 2
    }

  }

}
variable "ecr_repository" {
  type = list(object({
    name = string
    image_tag_mutability = string
  }))
  default = [
    {
      name                = "workshop-ecr-repository/backend"
      image_tag_mutability = "MUTABLE"
    },
    {
      name                = "workshop-ecr-repository/frontend"
      image_tag_mutability = "MUTABLE"
    },
    {
      name                = "workshop-ecr-repository/ingress-nginx-controller"
      image_tag_mutability = "MUTABLE"
    }
  ]
  
}
