//ipelineJob('roboshop-ansible') {
//   configure { flowdefinition ->
//       flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
//           'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
//               'userRemoteConfigs' {
//                   'hudson.plugins.git.UserRemoteConfig' {
//                       'url'('https://github.com/Akhireddy/Ansible_Roboshop.git')
//                   }
//               }
//               'branches' {
//                   'hudson.plugins.git.BranchSpec' {
//                       'name'('*/main')
//                   }
//               }
//           }
//           'scriptPath'('Jenkinsfile')
//           'lightweight'(true)
//       }
//   }
//

//ipelineJob('roboshop-ansible') {
// configure { flowdefinition ->
//   flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
//     'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
//       'userRemoteConfigs' {
//         'hudson.plugins.git.UserRemoteConfig' {
//           'url'('https://github.com/Akhireddy/Ansible_Roboshop.git')
//         }
//       }
//       'branches' {
//         'hudson.plugins.git.BranchSpec' {
//           'name'('*/main')
//         }
//       }
//     }
//     'scriptPath'('Jenkinsfile')
//     'lightweight'(true)
//   }
// }
//
//
//older('CI-Pipelines') {
//   displayName('CI-Pipelines')
//   description('CI-Pipelines')
//
//
//ipelineJob('CI-Pipelines/cart') {
// configure { flowdefinition ->
//   flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
//     'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
//       'userRemoteConfigs' {
//         'hudson.plugins.git.UserRemoteConfig' {
//           'url'('https://github.com/Akhireddy/Cart.git')
//         }
//       }
//       'branches' {
//         'hudson.plugins.git.BranchSpec' {
//           'name'('*/main')
//         }
//       }
//     }
//     'scriptPath'('Jenkinsfile')
//     'lightweight'(true)
//   }
// }
//


folder('Mutable') {
  displayName('Mutable')
  description('Mutable')
}

pipelineJob('Mutable/VPC') {
  configure { flowdefinition ->
    flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
      'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
        'userRemoteConfigs' {
          'hudson.plugins.git.UserRemoteConfig' {
            'url'('https://github.com/Akhireddy/terraform-vpc.git')
          }
        }
        'branches' {
          'hudson.plugins.git.BranchSpec' {
            'name'('*/main')
          }
        }
      }
      'scriptPath'('Jenkinsfile')
      'lightweight'(true)
    }
  }
}