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
	      sh "scp -r build/distributions/*.tar monitor@vtbuild:stapi_uat/bin/stapi${env.BUILD_NUMBER}.tar"
	      sh "ssh monitor@vtbuild 'chmod -w /home/orbis/stapi_uat/bin/*.tar'"		
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

