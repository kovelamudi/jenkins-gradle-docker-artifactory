pipeline {
  agent {node{ label 'linux'}}

  stages {
    stage('build user') {
      steps {
        wrap([$class: 'BuildUser']) {
	sh ( script: 'echo "${BUILD_USER}"', returnStdout: true).trim()
        }
      }
    }
  }
}
