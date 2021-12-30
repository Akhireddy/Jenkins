def call() {
  pipeline {
    agent {
      label "${BUILD_LABEL}"
    }

    triggers {
      pollSCM('*/2 * * * *')
    }

    stage('Compile the Code') {
      steps {
        sh 'echo compile code'
      }

      stage('Check the Code Quality') {
        steps {
          script { 
            common.sonarQube()
          }
        }
      }

      stage('Lint Checks') {
        steps {
          sh 'echo Test Cases'
        }
      }

      stage('Test Cases') {
        steps {
          sh 'echo Test Cases'
        }
      }  }
  }
