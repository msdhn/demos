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


var roles = {
  //Grants full access to manage all resources, but does not allow you to assign roles in Azure RBAC, manage assignments in Azure Blueprints, or share image galleries.
  Contributor : 'b24988ac-6180-42a0-ab88-20f7382dd24c'
  
  //Grants full access to manage all resources, including the ability to assign roles in Azure RBAC.
  Owner : '8e3af657-a8ff-443c-a75c-2fe8c4bcb635'

  //View all resources, but does not allow you to make any changes.
  Reader : 'acdd72a7-3385-48ef-bd42-f606fba81ae7'
}



