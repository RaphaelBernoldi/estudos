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

variable "remote_desktop" {
  type = object({
    s3_bucket     = string
    dynamo_table_name = string
    dynamo_table_billing_mode = string
    dynamo_table_hash_key = string
  })
  default = {
    s3_bucket = "workshop-s3-remote-backend-stack"
    dynamo_table_name = "workshop-s3-state-locking-table"
    dynamo_table_billing_mode = "PAY_PER_REQUEST"
    dynamo_table_hash_key = "LockID"
  }
  
}
