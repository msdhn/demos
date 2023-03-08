
param virtualNetworkName string
@sys.description('same as resource group')
param location string = resourceGroup().location
param subNetNameAks string = '${virtualNetworkName}-subnet-aks'

module msdhnRouteTable 'routetable.bicep' = {
  name: 'msdhnRouteTable'
  params:{
     name: '${virtualNetworkName}-routetable'
     location:location
  }
}

module nsgs 'nsg.bicep' = {
  name: 'msdhnNsgs'
  params: {
     virtualNetworkName: virtualNetworkName
     location: location
  }
}

resource virtualNetwork 'Microsoft.Network/virtualNetworks@2019-11-01' = {
  name: virtualNetworkName
  location: location
  properties: {
    addressSpace: {
      addressPrefixes: [
        '10.0.0.0/16'
      ]
    }
    subnets: [
      {
        name: subNetNameAks
        properties: {
          addressPrefix: '10.0.0.0/20'
          networkSecurityGroup: {
            id: nsgs.outputs.nsgs.nsgForAksSubnetId
          }
          routeTable:{
            id: msdhnRouteTable.outputs.routeTableId
          }
        }
      }
    ]
  }
}
