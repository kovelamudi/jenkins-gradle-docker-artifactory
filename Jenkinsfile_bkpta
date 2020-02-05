pipeline {
    agent {node{ label 'docker-testing'}}
environment { 
USER = 'MONITOR'
}
    stages {

    stage('env-variable') {
    	steps {
    	sh "printenv"
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
          mail(to: 'madhava.kovelamudi@orbisfn.com', subject: "Status of pipeline:user ${USER} and ${currentBuild.fullDisplayName}", body: "Project: ${env.BUILD_URL} has result ${currentBuild.result}")
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

