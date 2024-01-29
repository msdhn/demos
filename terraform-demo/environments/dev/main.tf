resource "azurerm_resource_group" "rg" {
  name     = "sandbox-nl06123-1706353277-rg"
  location = "westeurope"
}

module "sa" {
   source = "../../modules/storageaccount"
   location = azurerm_resource_group.rg.location
   rgName = azurerm_resource_group.rg.name
}

output "name" {
  value = module.sa.name
}


