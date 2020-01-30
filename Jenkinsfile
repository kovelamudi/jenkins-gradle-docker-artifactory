pipeline {
    agent {node{ label 'linux'}}

    stages {

       stage('Build') {
          when {
             anyOf {
                 branch 'UAT'
                 branch 'master'
             }
          }
          tools {
              gradle "gradle"
          }

          steps {
              sh "gradle clean"
              sh "gradle build"
          }
       }

       stage("deploy to uat") {
           when {
                branch 'UAT'
            }
           steps {
               sh "scp -r build/distributions/*.tar jenkins@192.168.110.100:bin/"
               sh "ssh jenkins@192.168.110.100 'chmod -w bin/*.tar'"
           }
       }
    }

    post {
       failure {
          mail(to: 'madhava.kovelamudi@orbisfn.com', subject: "Build failure for ${env.JOB_NAME}", body: "Project: ${env.JOB_NAME}\nBuild Number: ${env.BUILD_NUMBER}")
       }

       success {
          script {
              if (env.BRANCH_NAME == 'UAT')
                 archiveArtifacts '**/*.tar'
                 cleanWs()
          }
       }
    }

    options {
        buildDiscarder(logRotator(numToKeepStr: '10'))
    }

}

