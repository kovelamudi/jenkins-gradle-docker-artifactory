pipeline {
    agent {node{ label 'linux'}}

    stages {

       stage('Build') {
          tools {
              gradle "gradle"
          }

          steps {

	  wrap([$class: 'BuildUser']) {
    echo "userId=${BUILD_USER_ID},fullName=${BUILD_USER},email=${BUILD_USER_EMAIL}"}
              sh "gradle clean"
              sh "gradle build artifactoryPublish"
          }
       }

       stage("deploy to UAT") {
           steps {
               sh "scp -r build/distributions/*.tar jenkins@192.168.110.100:bin/"
               sh "ssh jenkins@192.168.110.100 'chmod -w bin/*.tar'"
           }
       }
    }

    post {
       always {
          mail(to: 'madhava.kovelamudi@orbisfn.com', subject: "Status of pipeline:user ${BUILD_USER} and ${currentBuild.fullDisplayName}", body: "Project: ${env.BUILD_URL} has result ${currentBuild.result}")
       }

       success {
          script {
                 archiveArtifacts '**/*.tar'
                 cleanWs()
          }
       }
    }

    options {
        buildDiscarder(logRotator(numToKeepStr: '10'))
    }

}

