targetScope = 'subscription'

@sys.description('region of the resource group to be deployed')
param location string

param tagObject object = {
  Dept: 'Finance'
  Contact: 'masud.iem@gmail.com'
  Environment: 'Production'
}

resource applyTags 'Microsoft.Resources/tags@2021-04-01' = {
  name: 'default'
  properties: {
    tags: tagObject
  }
}

resource resourceGroupApp 'Microsoft.Resources/resourceGroups@2021-01-01' = {
  name: 'msdhn-rg-app'
  location: location
}

resource resourceGroupVnet 'Microsoft.Resources/resourceGroups@2021-01-01' = {
  name: 'msdhn-rg-vnet'
  location: location
}
