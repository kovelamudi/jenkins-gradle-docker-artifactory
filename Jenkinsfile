pipeline {
  agent {node{ label 'linux'}}

  stages {
    stage('build user') {
      steps {
        wrap([$class: 'BuildUser']) {
	GET_BUILD_USER = sh ( script: 'echo "${BUILD_USER}"', returnStdout: true).trim()
        }
      }
    }
  }
}
