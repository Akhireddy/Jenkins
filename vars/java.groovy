def call() {
  pipeline {
    agent {
      label "${BUILD_LABEL}"
    }

 //   triggers {
    //   pollSCM('2 * * * *')
   // }

    environment {
      PROG_LANG_NAME = "java"
      PROG_LANG_VERSION = "1.8"
      NEXUS = credentials('NEXUS')
    }

    stages {

      stage('Check the Code Quality') {
        steps {
          script {
            common.sonarQube()
          }
        }
      }

      stage('Lint Checks') {
        steps {
          sh 'echo Lint Cases'
        }
      }

      stage('Test Cases') {
        steps {
          sh 'echo Test Cases'
        }
      }

      stage('Publish Artifacts') {
        when {
          expression { sh([returnStdout: true, script: 'echo ${GIT_BRANCH} | grep tags || true' ]) }
        }
        steps {
          script {
            common.prepareArtifacts()
            common.publishArtifacts()
          }
        }
      }

    }

    post {
      cleanup {
        cleanWs()
      }
    }

  }
}
