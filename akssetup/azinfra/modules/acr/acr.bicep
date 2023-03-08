@minLength(5)
@maxLength(50)
@description('Provide a globally unique name of your Azure Container Registry')
param acrName string

@description('Provide a location for the registry.')
param location string = resourceGroup().location

@description('Provide a tier of your Azure Container Registry.')
param acrSku string = 'Basic'

param aksIdentityObjectId string

resource acrResource 'Microsoft.ContainerRegistry/registries@2021-06-01-preview' = {
  name: acrName
  location: location
  sku: {
    name: acrSku
  }
  properties: {
    adminUserEnabled: false
  }
}

resource acrPullRoleDefinition 'Microsoft.Authorization/roleDefinitions@2022-04-01' existing = {
  scope: subscription()
  name: '7f951dda-4ed3-4680-a7ca-43fe172d538d'
}
resource clusterAdminRoleAssignment 'Microsoft.Authorization/roleAssignments@2022-04-01' = {
  name: guid(acrResource.id, aksIdentityObjectId, acrPullRoleDefinition.id)
  scope: acrResource
  properties: {
    roleDefinitionId: acrPullRoleDefinition.id
    principalId: aksIdentityObjectId
    principalType: 'ServicePrincipal'
  }
}

@description('Output the login server property for later use')
output loginServer string = acrResource.properties.loginServer

