param location string = resourceGroup().location

@description('name of the storage account')
param accountName string


resource stgAccount 'Microsoft.Storage/storageAccounts@2021-04-01' = {
  name: accountName
  location: location
  sku: {
    name: 'Standard_LRS'
  }
  kind: 'Storage'
  properties:{
    allowBlobPublicAccess: false
    allowCrossTenantReplication: false
    allowSharedKeyAccess: false
    supportsHttpsTrafficOnly: true
  }
}

output id string = stgAccount.id
