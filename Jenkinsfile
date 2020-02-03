pipeline {
    agent {node{ label 'linux'}}

    stages {

stage('example') {
           agent { label 'master' }
           steps {
               script {
                   wrap([$class: 'BuildUser']) {
                       echo "BUILD_USER=${BUILD_USER}"
                       echo "BUILD_USER_FIRST_NAME=${BUILD_USER_FIRST_NAME}"
                       echo "BUILD_USER_LAST_NAME=${BUILD_USER_LAST_NAME}"
                       echo "BUILD_USER_ID=${BUILD_USER_ID}"
                       echo "BUILD_USER_EMAIL=${BUILD_USER_EMAIL}"
                       echo "---"
                       echo "env.BUILD_USER=${env.BUILD_USER}"
                       echo "env.BUILD_USER_FIRST_NAME=${env.BUILD_USER_FIRST_NAME}"
                       echo "env.BUILD_USER_LAST_NAME=${env.BUILD_USER_LAST_NAME}"
                       echo "env.BUILD_USER_ID=${env.BUILD_USER_ID}"
                       echo "env.BUILD_USER_EMAIL=${env.BUILD_USER_EMAIL}"
                   }
               }
           }
       }

       stage('Build') {
          tools {
              gradle "gradle"
          }

          steps {

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
          mail(to: 'madhava.kovelamudi@orbisfn.com', subject: "Status of pipeline:user $env.{BUILD_USER} and ${currentBuild.fullDisplayName}", body: "Project: ${env.BUILD_URL} has result ${currentBuild.result}")
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

