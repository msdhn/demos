variable "rgName" {
  type        = string
}

variable "location" {
  type        = string
}

resource "azurerm_storage_account" "sa" {
  name                     = "msdhn02"
  resource_group_name      = var.rgName
  location                 = var.location
  account_tier             = "Standard"
  account_replication_type = "GRS"
}

output "name" {
  value = azurerm_storage_account.sa.name
}

