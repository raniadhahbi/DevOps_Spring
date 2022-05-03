pipeline {
  agent any
  stages {
    stage('install') {
      steps {
        sh 'mvn install'
      }
    }

    stage('Building') {
      steps {
        sh 'mvn build'
      }
    }

  }
}