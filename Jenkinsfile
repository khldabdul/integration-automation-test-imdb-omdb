pipeline {
  agent any
  stages {
    stage('Checkout SCM') {
      steps {
        git(url: 'https://github.com/khldabdul/integration-automation-test-imdb-omdb.git', branch: 'master')
      }
    }
    stage('Smoke Test') {
      steps {
        bat 'mvn clean verify -Drunner.class=SmokeRunner'
      }
    }
    stage('API Test') {
      steps {
        bat 'mvn verify -Drunner.class=ApiRunner'
      }
    }
    stage('UI Test') {
      parallel {
        stage('Chrome') {
          steps {
            bat 'mvn verify -Drunner.class=ChromeRunner'
          }
        }
        stage('Firefox') {
          steps {
            bat 'mvn verify -Drunner.class=FirefoxRunner'
          }
        }
      }
    }
    stage('Results') {
      steps {
        junit '**/target/failsafe-reports/*.xml'
      }
    }
  }
}