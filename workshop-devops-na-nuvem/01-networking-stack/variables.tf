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

variable "vpc" {
  type = object({
    cidr_block               = string
    name                     = string
    internet_gateway_name    = string
    nat_gateway_name         = string
    public_route_table_name  = string
    private_route_table_name = string
    public_subnets = list(object({
      name                    = string
      cidr_block              = string
      availability_zone       = string
      map_public_ip_on_launch = bool
    }))
    private_subnets = list(object({
      name                    = string
      cidr_block              = string
      availability_zone       = string
      map_public_ip_on_launch = bool
    }))
  })
  default = {
    cidr_block               = "10.0.0.0/24"
    name                     = "workshop-devops-na-nuvem-vpc"
    internet_gateway_name    = "workshop-devops-na-nuvem-internet-gateway"
    nat_gateway_name         = "workshop-devops-na-nuvem-nat-gateway"
    public_route_table_name  = "workshop-devops-na-nuvem-public-route-table"
    private_route_table_name = "workshop-devops-na-nuvem-private-route-table"
    public_subnets = [
      {

        name                    = "workshop-devops-na-nuvem-public-subnet-1a"
        cidr_block              = "10.0.0.0/26"
        availability_zone       = "us-east-1a"
        map_public_ip_on_launch = true
      },
      {

        name                    = "workshop-devops-na-nuvem-public-subnet-1c"
        cidr_block              = "10.0.0.64/26"
        availability_zone       = "us-east-1c"
        map_public_ip_on_launch = true
      }
    ]
    private_subnets = [
      {

        name                    = "workshop-devops-na-nuvem-private-subnet-1a"
        cidr_block              = "10.0.0.128/26"
        availability_zone       = "us-east-1a"
        map_public_ip_on_launch = false
      },
      {

        name                    = "workshop-devops-na-nuvem-private-subnet-1c"
        cidr_block              = "10.0.0.192/26"
        availability_zone       = "us-east-1c"
        map_public_ip_on_launch = false
      }
    ]
  }
}

