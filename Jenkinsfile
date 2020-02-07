pipeline {
    agent{label 'docker-testing' }

    stages {

       stage('Build') {
	agent {dockerfile true}
          when {
             anyOf {
                 branch 'UAT'
                 branch 'master'
             }
          }
          tools {
              gradle "gradle"
              jdk "jdk11"
          }

          steps {
              sh "gradle clean build artifactoryPublish"
              
          }
       }

       stage("deploy to uat") {
       agent{label 'docker-testing' }
           when {
                branch 'UAT'
            }
           steps {
               sh "cp -r build/distributions/*.tar /home/orbis/stapi_uat/bin/stapi${env.BUILD_NUMBER}.tar"
               sh "chmod -w /home/orbis/stapi_uat/bin/*.tar"
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
          }
       }
    }

    options {
        buildDiscarder(logRotator(numToKeepStr: '10'))
    }

}

