
param virtualNetworkName string
@description('same as resource group')
param location string = resourceGroup().location

param logAnalyticsResourceId string
param storageAccountResourceId string

var subNetNameAks = '${virtualNetworkName}-subnet-aks'
var subNetNameVM = '${virtualNetworkName}-subnet-vm'


var vnetCIDR = '10.0.0.0/16'

var aksCIDR = '10.0.0.0/20'
var vmCIDR = '10.0.16.0/28'
var azFwCIDR = '10.0.17.0/26'
var bastionCIDR = '10.0.18.0/26'


module natGw './natgateway.bicep' = {
  name: 'natGatewayDeploy'
  params:{
    natgatewayname: '${virtualNetworkName}-ngw'
    location: location
  }
}

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
     logAnalyticsResourceId: logAnalyticsResourceId
     storageAccountResourceId: storageAccountResourceId
  }
}

resource virtualNetwork 'Microsoft.Network/virtualNetworks@2019-11-01' = {
  name: virtualNetworkName
  location: location
  properties: {
    addressSpace: {
      addressPrefixes: [
        vnetCIDR
      ]
    }
    subnets: [
      {
        name: subNetNameAks
        properties: {
          addressPrefix: aksCIDR
          networkSecurityGroup: {
            id: nsgs.outputs.nsgs.nsgForAksSubnetId
          }
          routeTable:{
            id: msdhnRouteTable.outputs.routeTableId
          }
          natGateway:{
            id : natGw.outputs.natgateWayId
          }
        }
      }
      {
        name: subNetNameVM
        properties: {
          addressPrefix: vmCIDR
          natGateway:{
            id : natGw.outputs.natgateWayId
          }
        }
      }
      {
        name: 'AzureFirewallSubnet'
        properties: {
          addressPrefix: azFwCIDR
        }
      }
      {
        name: 'AzureBastionSubnet'
        properties: {
          addressPrefix: bastionCIDR
        }
      }
    ]
  }
}

output subnetIds object = {
  aksSubnet : virtualNetwork.properties.subnets[0].id
  vmSubnet : virtualNetwork.properties.subnets[1].id
  azFwSubnet : virtualNetwork.properties.subnets[2].id
  bastionSubnet : virtualNetwork.properties.subnets[3].id
}
