@description('Name of the NAT gateway')
param natgatewayname string

@description('Name of resource group')
param location string = resourceGroup().location

var  publicipname = '${natgatewayname}-pip'
var publicipprefixname = '${natgatewayname}-prefixpip'

resource publicip 'Microsoft.Network/publicIPAddresses@2021-05-01' = {
  name: publicipname
  location: location
  sku: {
    name: 'Standard'
  }
  properties: {
    publicIPAddressVersion: 'IPv4'
    publicIPAllocationMethod: 'Static'
    idleTimeoutInMinutes: 4
  }
}

resource publicipprefix 'Microsoft.Network/publicIPPrefixes@2021-05-01' = {
  name: publicipprefixname
  location: location
  sku: {
    name: 'Standard'
  }
  properties: {
    prefixLength: 31
    publicIPAddressVersion: 'IPv4'
  }
}

resource natgateway 'Microsoft.Network/natGateways@2021-05-01' = {
  name: natgatewayname
  location: location
  sku: {
    name: 'Standard'
  }
  properties: {
    idleTimeoutInMinutes: 4
    publicIpAddresses: [
      {
        id: publicip.id
      }
    ]
    publicIpPrefixes: [
      {
        id: publicipprefix.id
      }
    ]
  }
}

output natgateWayId string = natgateway.id
