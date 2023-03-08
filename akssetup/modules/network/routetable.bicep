@sys.description('same as resource group')
param location string = resourceGroup().location
param name string
resource msdhnRouteTable 'Microsoft.Network/routeTables@2022-07-01' = {
  name: name
  location: location
  properties: {
    disableBgpRoutePropagation: false
    routes: [
      {
        id: 'internetroute'
        name: 'internet'
        properties: {
          addressPrefix: '0.0.0.0/0'
          hasBgpOverride: true
          //nextHopIpAddress: ''
          //override this with virtual apliance ip address for internet bound traffic
          nextHopType: 'Internet'
        }
        type: 'string'
      }
    ]
  }
}

output routeTableId string = msdhnRouteTable.id
