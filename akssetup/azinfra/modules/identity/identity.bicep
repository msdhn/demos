
@description('name of the idenity')
param name string

@description('region')
param location string = resourceGroup().location

resource uamIdentity 'Microsoft.ManagedIdentity/userAssignedIdentities@2023-01-31' = {
  name: name
  location: location
}

output uami object  = {
  resourceId : uamIdentity.id
  principalId : uamIdentity.properties.principalId
}
