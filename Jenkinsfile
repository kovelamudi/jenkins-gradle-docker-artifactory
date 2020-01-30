pipeline {
   
agent {node{ label 'linux'}}
   
   
stages {
        
		
	stage('Build') {
		
		when {
                	branch 'UAT'
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
    			
		steps {
			sh "scp -r build/distributions/*.tar jenkins@192.168.110.100:/home/apache-tomcat-8.5.50/webapps/StaPI.tar"
		}
        }
}
   
   
   
post {
	failure {
		mail(to: 'madhava.kovelamudi@orbisfn.com', subject: "Build failure for ${env.JOB_NAME}", body: "Project: ${env.JOB_NAME}\nBuild Number: ${env.BUILD_NUMBER}")
	}
			
	success {
		script {
			if (env.BRANCH_NAME == 'master')
				archiveArtifacts '**/*.tar'
				cleanWs()
		}
	}
}
	
options {
        buildDiscarder(logRotator(numToKeepStr: '10'))
}

}
