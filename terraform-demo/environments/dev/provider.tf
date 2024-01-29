terraform {
  required_providers {
    azurerm = {
      source = "hashicorp/azurerm"
      version = "3.89.0"
    }
  }
}

provider "azurerm" {
  subscription_id = "3a89d508-f992-4729-9058-ba4fae9a35ca"
  features {
  }
  skip_provider_registration = true
}

