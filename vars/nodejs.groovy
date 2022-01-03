def call() {
  pipeline {
    agent {
      label "${BUILD_LABEL}"
    }

    triggers {
      pollSCM('H/2 * * * *')
    }

    stages {

      stage('Label Builds') {
        steps {
          script {
            def gitTag = GIT_BRANCH.split('/').last()
            addShortText background: 'white', borderColor: 'white', color: 'red', link: '', text: "${gitTag}"
          }
        }
      }


      stage('Check the Code Quality') {
        steps {
          script {
            common.sonarQube()
			addBadge icon: '',id: '',: '', text: 'DEMO'
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
          sh 'env'
        }
      }
