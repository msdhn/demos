param location string = 'westeurope'
param namePrefix string = 'msdhn'

param aksAdminGroupObjectID string


module storageAccount './modules/storage/storageaccount.bicep' = {
  name: 'storageAccount'
  params: {
    accountName: '${namePrefix}sa'
    location: location
  }
}

module uami './modules/identity/identity.bicep' =  {
  name: 'uami'
  params: {
    name:  '${namePrefix}-uami'
    location: location
  }
}

module keyVault './modules/keyvault/keyvault.bicep' =  {
  name:'keyVault'
  params:{
    location: location
    keyVaultName: '${namePrefix}-kv-main'
    adminGroupObjectID: aksAdminGroupObjectID
  }
}

module logAnalytics './modules/loganalytics/loganalytics.bicep' =  {
  name: 'logAnalytics'
  params: {
    name: '${namePrefix}-la'
    location: location
    uamiResourceId: uami.outputs.uami.resourceId
  }
}

module acr './modules/acr/acr.bicep' =  {
  name: 'acrDeploy'
  params: {
    acrName: '${namePrefix}acr'
    location: location
    aksIdentityObjectId: uami.outputs.uami.principalId 
  }
}

module virtualNetwork './modules/network/network.bicep' = {
  name: 'virtualNetwork'
  params: {
   virtualNetworkName: '${namePrefix}-vnet'
   location: location
   logAnalyticsResourceId: logAnalytics.outputs.id
  storageAccountResourceId: storageAccount.outputs.id
  }
}

module aks './modules/aks/akscluster.bicep' = {
  name: 'aksDeploy'
  params:{
    clusterName: '${namePrefix}-aks'
    adminGroupObjectID: aksAdminGroupObjectID
    clusterIdentityResourceId: uami.outputs.uami.resourceId
    aksVersion:'1.24.6'
    dnsPrefix: namePrefix
    newCluster:true
    logAnalyticsWorkspaceId: logAnalytics.outputs.id
    subnetResourceId: virtualNetwork.outputs.subnetIds.aksSubnet
    location:location
  }
}





