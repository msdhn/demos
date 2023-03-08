param virtualNetworkName string
@sys.description('same as resource group')
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

var nsgsAllSubnetIds = {
  nsgForAksSubnetId: nsgAksSubnet.id
}

output nsgs object = nsgsAllSubnetIds

