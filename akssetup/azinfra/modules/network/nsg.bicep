param virtualNetworkName string
@description('same as resource group')
param location string = resourceGroup().location
param subNetNameAks string = '${virtualNetworkName}-subnet-aks'
param logAnalyticsResourceId string

param storageAccountResourceId string

resource nsgAksSubnet 'Microsoft.Network/networkSecurityGroups@2022-01-01' = {
  name: '${subNetNameAks}-nsg'
  location: location
  properties: {
    securityRules: [
      
      //inbound rules start
      //inbound rules end

      //outbound rules starts
      //outbound rules end

    ]
  }
}
resource nsgAksSubnetDiagnostics 'Microsoft.Insights/diagnosticSettings@2021-05-01-preview' = {
  name: 'laDiagnostics'
  scope: nsgAksSubnet
  properties: {
    logs: [
        {
            category: null
            categoryGroup: 'allLogs'
            enabled: true
            retentionPolicy: {
                days: 0
                enabled: false
            }
        }
    ]
    metrics: []
    workspaceId: logAnalyticsResourceId
    logAnalyticsDestinationType: null
  }
}

// TODO nsg flow logs 

// resource networkWatcher 'Microsoft.Network/networkWatchers@2022-07-01' = {
//   name: 'networkWatcher'
//   location: location
//   properties: {}
// }
// resource nsgAksflowLog 'Microsoft.Network/networkWatchers/flowLogs@2022-01-01' = {
//   name: 'nsgAksflowLogs'
//   location: location
//   parent: networkWatcher
//   properties: {
//     targetResourceId: nsgAksSubnet.id
//     storageId: storageAccountResourceId
//     enabled: true
//     retentionPolicy: {
//       days: 180
//       enabled: true
//     }
//     format: {
//       type: 'JSON'
//     }
//   }
// }

var nsgsAllSubnetIds = {
  nsgForAksSubnetId: nsgAksSubnet.id
}

output nsgs object = nsgsAllSubnetIds
