param location string = resourceGroup().location

@sys.description('name of the storage account')
param accountName string
param tagValues object = {
  Dept: 'Finance'
  Environment: 'Production'
}

resource stgAccount 'Microsoft.Storage/storageAccounts@2021-04-01' = {
  name: accountName
  location: location
  sku: {
    name: 'Standard_LRS'
  }
  kind: 'Storage'
  tags: tagValues
}
