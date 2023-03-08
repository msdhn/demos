az account set 'mypracticesubscription'

az deployment sub validate --location westeurope --template-file rg.bicep --parameters location=westeurope
az deployment sub create --location westeurope --template-file rg.bicep --parameters location=westeurope


az deployment group validate --resource-group msdhn-rg-vnet --template-file main.bicep
az deployment group create --resource-group msdhn-rg-vnet --template-file main.bicep






