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

pipelineJob('roboshop-ansible') {
  configure { flowdefinition ->
    flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
      'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
        'userRemoteConfigs' {
          'hudson.plugins.git.UserRemoteConfig' {
            'url'('https://github.com/Akhireddy/Ansible_Roboshop.git')
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

folder('CI-Pipelines') {
  displayName('CI-Pipelines')
  description('CI-Pipelines')
}

def COMPONENTS = ["cart", "catalogue", "payment", "shipping", "user", "dispatch"]

def SIZE =  COMPONENTS.size -1

for(i in 0..SIZE) {
  def j = COMPONENTS[i]
  pipelineJob("CI-Pipelines/${j}") {
    configure { flowdefinition ->
      flowdefinition << delegate.'definition'(class: 'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition', plugin: 'workflow-cps') {
        'scm'(class: 'hudson.plugins.git.GitSCM', plugin: 'git') {
          'userRemoteConfigs' {
            'hudson.plugins.git.UserRemoteConfig' {
              'url'("https://github.com/Akhireddy/${j}.git")
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
}

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


pipelineJob('Mutable/APP-SETUP') {
  configure { flowdefinition ->
    flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
      'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
        'userRemoteConfigs' {
          'hudson.plugins.git.UserRemoteConfig' {
            'url'('https://github.com/Akhireddy/Jenkins.git')
          }
        }
        'branches' {
          'hudson.plugins.git.BranchSpec' {
            'name'('*/main')
          }
        }
      }
      'scriptPath'('jenkinsfile-Mutable-Infra')
      'lightweight'(true)
    }
  }
}

pipelineJob('Mutable/ALB') {
  configure { flowdefinition ->
    flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
      'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
        'userRemoteConfigs' {
          'hudson.plugins.git.UserRemoteConfig' {
            'url'('https://github.com/Akhireddy/terraform-mutable-alb.git')
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
