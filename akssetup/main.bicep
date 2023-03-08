
param location string = 'westeurope'

module virtualNetwork './modules/network/network.bicep' = {
  name: 'virtualNetworkDeploy'
  params: {
   virtualNetworkName: 'msdhn-vnet'
   location: location
  }
}

module keyVaultMain './modules/keyvault/keyvault.bicep' = {
  name:'keyVaultMainDeploy'
  params:{
    location: location
    keyVaultName: 'msdhn-kv'
  }
}

