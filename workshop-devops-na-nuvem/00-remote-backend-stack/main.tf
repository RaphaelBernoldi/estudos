terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "6.7.0"
    }
  }
  backend "s3" {
    bucket         = "workshop-s3-remote-backend-stack"
    key            = "remote-stack/terraform.tfstate"
    region         = "us-east-1"
    use_lockfile   = true # Obsoleto quando dynamodb_table é usado
  }
}

provider "aws" {
  region = var.auth.region
  assume_role {
    role_arn = var.auth.assume_role
  }
  default_tags {
    tags = var.tags
  }
}
