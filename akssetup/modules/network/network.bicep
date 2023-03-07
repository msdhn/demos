
param virtualNetworkName string
param location string = resourceGroup().location
param subNetNameAks string = '${virtualNetworkName}-subnet-aks'


resource nsgAksSubnet 'Microsoft.Network/networkSecurityGroups@2022-01-01' = {
  name: '${subNetNameAks}-nsg'
  location: location
  properties: {
    securityRules: [
      //inbound rules start
      {
        name: 'DenyAllInbound'
        properties: {
          protocol: '*'
          sourcePortRange: '*'
          destinationPortRange: '*'
          sourceAddressPrefix: '*'
          destinationAddressPrefix: '*'
          access: 'Deny'
          priority: 1000
          direction: 'Inbound'
        }
      }
      //inbound rules end

      //outbound rules starts
      {
        name: 'DenyAllOutbound'
        properties: {
          protocol: '*'
          sourcePortRange: '*'
          destinationPortRange: '*'
          sourceAddressPrefix: '*'
          destinationAddressPrefix: '*'
          access: 'Deny'
          priority: 1000
          direction: 'Outbound'
        }
      }
      //outbound rules end
    ]
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
            id: nsgAksSubnet.id
          }
        }
      }
    ]
  }
}
