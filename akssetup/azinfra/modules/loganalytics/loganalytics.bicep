@sys.description('name of the workspace')
param name string

param location string = resourceGroup().location

@sys.description('identity id to be assigned')
param uamiResourceId string

resource la 'Microsoft.OperationalInsights/workspaces@2022-10-01' = {
  name: name
  location: location
  identity: {
    type: 'UserAssigned'
    userAssignedIdentities: {
      '${uamiResourceId}' : {}
    }
  }
  
  
  // properties: {
  //   defaultDataCollectionRuleResourceId: 'string'
  //   features: {
  //     clusterResourceId: 'string'
  //     disableLocalAuth: bool
  //     enableDataExport: bool
  //     enableLogAccessUsingOnlyResourcePermissions: bool
  //     immediatePurgeDataOn30Days: bool
  //   }
  //   forceCmkForQuery: bool
  //   publicNetworkAccessForIngestion: 'string'
  //   publicNetworkAccessForQuery: 'string'
  //   retentionInDays: int
  //   sku: {
  //     capacityReservationLevel: int
  //     name: 'string'
  //   }
  //   workspaceCapping: {
  //     dailyQuotaGb: int
  //   }
  //}


}

output id string = la.id
