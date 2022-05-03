pipeline {
  agent any
  stages {
    stage('install') {
      steps {
        sh 'mvn clean'
      }
    }

    stage('Building') {
      steps {
        sh 'mvn install'
      }
    }

    stage('testing') {
      steps {
        sh 'mvn test'
      }
    }

  }
}