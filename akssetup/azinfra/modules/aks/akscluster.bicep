@description('Optional. Specifies the location of the AKS cluster.')
param location string = resourceGroup().location

@description('Required. An AAD group object IDs to give administrative access to.')
param adminGroupObjectID string

@description('Required. Specifies the version of the AKS cluster.')
param aksVersion string

@description('Required. Resource ID of an existing Log Analytics Workspace.')
param logAnalyticsWorkspaceId string

@description('Required. Specifies the name of DNS Prefix.')
param dnsPrefix string

@description('Required. Specifies the Resource ID of the Subnet you wish to deploy AKS Nodes into.')
param subnetResourceId string

// @description('Required. Specifies the Object ID of the Service Principal you wish to have \'Virtual Machine Contributor\' rights on your Infrastructure Resource Group.')
// param resourceGroupServicePrincipalObjectId string

// @description('Required. ResourceId of the Disk Encryption Set to use.')
// param diskEncryptionSetResourceId string

@description('Required. ResourceId of the Managed Identity for the cluster.')
param clusterIdentityResourceId string

@description('Required. Specifies the minimum number of Nodes.')
param systemNodePoolMinCount int = 2

@description('Required. Specifies the maximum number of Nodes.')
param systemNodePoolMaxCount int = 5

@description('Optional. Specifies the VM Size of Nodes. Defaults to Standard_D2as_v5.')
param systemNodePoolVmSize string = 'Standard_D2as_v5' // Since we are unable to use ephemeral disk, we are using a remote only storage VM. Otherwise we would use Standard_D2ads_v5

@description('Optional. Specifies the VM Size of Nodes. Defaults to 128GB.')
param systemNodePoolDiskSizeGB int = 128 // Since we are unable to use ephemeral disks, we have to use a managed disk. This is the max P10 size

@description('Required. Indicates wether this is a new cluster, or an existing one.')
param newCluster bool
param clusterName string
param tenantId string = subscription().tenantId
param adminUsername string = 'msdhn'
//
//  AKS cluster resources
//  ******************
//  This is the cluster itself, with the following node pool configuration
//  - sys01 -> System nodepool
//  Rest of the nodepools are added separately, since they cannot be added afterwards within this resource.

resource cluster 'Microsoft.ContainerService/managedClusters@2022-09-01' = {
  name: clusterName
  location: location
  identity: {
    type: 'UserAssigned'
    userAssignedIdentities: {
      '${clusterIdentityResourceId}': {}
    }
  }
  sku: {
    name: 'Basic'
    tier: 'Free'
  }
  properties: {
    //nodeResourceGroup: nodeResourceGroupName
    aadProfile: {
      managed: true
      enableAzureRBAC: true
      tenantID: tenantId
    }
    addonProfiles: {
      azurePolicy: {
        enabled: true
      }
      omsagent: {
        enabled: true
        config: {
          logAnalyticsWorkspaceResourceID: logAnalyticsWorkspaceId
        }
      }
    }
    apiServerAccessProfile: {
      // later work on net integration of api server
      enablePrivateCluster: false
      //enablePrivateCluster: true
      //enablePrivateClusterPublicFQDN: true
      //privateDNSZone: 'None'
    }
    disableLocalAccounts: true
    dnsPrefix: dnsPrefix
    enableRBAC: true
    kubernetesVersion: aksVersion
    //diskEncryptionSetID: diskEncryptionSetResourceId
    networkProfile: {
      outboundType: 'userAssignedNATGateway'
      networkPlugin: 'azure'
      networkPolicy: 'calico'
      serviceCidr: '10.236.0.0/16'
      dnsServiceIP: '10.236.0.10'
      dockerBridgeCidr: '10.237.0.1/16'
    }
    oidcIssuerProfile: {
      enabled: true
    }
    // windowsProfile: {
    //   adminUsername: msdhn
    //   adminPassword: windowsPassword
    // }
    linuxProfile: {
      adminUsername: adminUsername
      ssh: {
        publicKeys: [
          {
            keyData: 'ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQC7DcWmIMx9E/F46AextYdYdMKPvXIUBLsSiVwkzRucFVCY/Vbdc6zZyyAxKZSt5ZGYoM5D7IjeIMzkwnW7lgQL6RMi8kMzgVeHmnv30sDUwA3NAn36vGu2G1D6PmKxgp1ZEVglkf5Be3i1az/ddO6EVeq/f23lPF2yRTMbw3fD5jLhIJ1sJ++hC9Hei8VZDtbYPoqQeryvAI6IEJL8KRZDoo0aZgFkIe86IefEGqBSUTTXW7wvo7pjUI1KnAW6voKjSgMRCAQPEgsDGhSMluDuOTOogxmSTKzHv+JecmHRca7XunGZdDcE8LDv49OWAAY0nInrrL3XJIZa2Uj7TtZcPQ1KMu9sBg5EERC2BBO7tpwsVahfJp1My4bxLyokzzru58/VMTt4r98a54t/OiRLPdz3yzIdNgR3J1+9NVckrKwSHVb45MjcAorvwjCMJre5cl+DtwbO9lEgA+CKAcvwDkbUrKOJj6B4zatZPKogpbIeUybkKEYUXTjgyKp5VP0= LAUNCHER+C77581@NLLH4000905275'
          }
        ]
      }
    }
    agentPoolProfiles: newCluster ? [
      // The system nodepool, tainted to only run system workloads
      {
        name: 'sys01'
        vnetSubnetID: subnetResourceId
        mode: 'System'
        //enableEncryptionAtHost: true
        osType: 'Linux'
        maxPods: 50
        availabilityZones: [
          '1', '2', '3'
        ]
        type: 'VirtualMachineScaleSets'
        enableAutoScaling: true
        count: systemNodePoolMinCount
        minCount: systemNodePoolMinCount
        maxCount: systemNodePoolMaxCount
        vmSize: systemNodePoolVmSize
        osDiskSizeGB: systemNodePoolDiskSizeGB
        //osDiskType: 'Ephemeral' // Is default, but this explicitly failes if ephemeral is not possible with selected VM size
        nodeTaints: [
          'CriticalAddonsOnly=true:NoSchedule'
        ]
      }
    ] : null
  }
}

// resource dataCollectionEndpointWeuRef 'Microsoft.Insights/dataCollectionEndpoints@2021-04-01' existing = {
//   name: 'aah-d-dce-weu01'
//   scope: resourceGroup('aah-plat-d-rg')
// }

// resource dcra 'Microsoft.Insights/dataCollectionRuleAssociations@2021-04-01' = {
//   name: 'configurationAccessEndpoint'
//   scope: cluster
//   properties: {
//     dataCollectionEndpointId: dataCollectionEndpointWeuRef.id
//   }
// }

//
//  Role Assingement for the admin group.
//  ******************
//  The default RBAC roles that MS delivers out of the box
//  https://docs.microsoft.com/en-us/azure/role-based-access-control/built-in-roles
//  The ID and names are the same. You can pick one and assing that to the group.
//

var role = {
  // roleName:    Azure Kubernetes Service Cluster Admin Role
  // description: List cluster admin credential action.
  azureKubernetesServiceClusterAdminRole: '0ab0b1a8-8aac-4efd-b8c2-3ee1fb270be8'
  // roleName:    Azure Kubernetes Service Cluster User Role
  // description: List cluster user credential action.
  azureKubernetesServiceClusterUserRole: '4abbcc35-e782-43d8-92c5-2d3f1bd2253f'
  // roleName:    Azure Kubernetes Service Contributor Role
  // description: Grants access to read and write Azure Kubernetes Service clusters
  azureKubernetesServiceContributorRole: 'ed7f3fbd-7b88-4dd4-9017-9adb7ce333f8'
  // roleName:    Azure Kubernetes Service RBAC Admin
  // description: Lets you manage all resources under cluster/namespace, except update or delete resource quotas and namespaces.
  azureKubernetesServiceRBACAdmin: '3498e952-d568-435e-9b2c-8d77e338d7f7'
  // roleName:    Azure Kubernetes Service RBAC Cluster Admin
  // description: Lets you manage all resources in the cluster.
  azureKubernetesServiceRBACClusterAdmin: 'b1ff04bb-8a4e-4dc4-8eb5-8693973ce19b'
  // roleName:    Azure Kubernetes Service RBAC Reader
  // description: Allows read-only access to see most objects in a namespace. It does not allow viewing roles or role bindings. This role does not allow viewing Secrets, since reading the contents of Secrets enables access to ServiceAccount credentials in the namespace, which would allow API access as any ServiceAccount in the namespace (a form of privilege escalation). Applying this role at cluster scope will give access across all namespaces.
  azureKubernetesServiceRBACReader: '7f6c6a51-bcf8-42ba-9220-52d62157d7db'
  // roleName:    Azure Kubernetes Service RBAC Writer
  // description: Allows read/write access to most objects in a namespace.This role does not allow viewing or modifying roles or role bindings. However, this role allows accessing Secrets and running Pods as any ServiceAccount in the namespace, so it can be used to gain the API access levels of any ServiceAccount in the namespace. Applying this role at cluster scope will give access across all namespaces.
  azureKubernetesServiceRBACWriter: 'a7ffa36f-339b-4b5c-8bdf-e2c188b2c0eb'
}

resource clusterAdminRoleDefinition 'Microsoft.Authorization/roleDefinitions@2022-04-01' existing = {
  scope: subscription()
  name: role.azureKubernetesServiceRBACAdmin
}

resource clusterRbacAdminRoleDefinition 'Microsoft.Authorization/roleDefinitions@2022-04-01' existing = {
  scope: subscription()
  name: role.azureKubernetesServiceRBACClusterAdmin
}

resource clusterAdminRoleAssignment 'Microsoft.Authorization/roleAssignments@2022-04-01' = {
  name: guid(cluster.id, adminGroupObjectID, clusterAdminRoleDefinition.id)
  scope: cluster
  properties: {
    roleDefinitionId: clusterAdminRoleDefinition.id
    principalId: adminGroupObjectID
  }
}

resource clusterRbacAdminRoleAssignment 'Microsoft.Authorization/roleAssignments@2022-04-01' = {
  name: guid(cluster.id, adminGroupObjectID, clusterRbacAdminRoleDefinition.id)
  scope: cluster
  properties: {
    roleDefinitionId: clusterRbacAdminRoleDefinition.id
    principalId: adminGroupObjectID
  }
}

output clusterId string = cluster.id
