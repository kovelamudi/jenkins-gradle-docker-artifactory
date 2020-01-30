pipeline {
   agent {node{ label 'linux'}}
triggers {
        pollSCM '* * * * *'
    }
   stages {
	stage('Build') {
	// this is very important and configure this gradle tool in gobal tool configuration(master and slave) otherwise it errors out
	tools {
           gradle "gradle"
	 }
					
            steps {
		// Get some code from a GitHub repository.
		//checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'RelativeTargetDirectory', relativeTargetDir: 'first-java-project']], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/kovelamudi/gradle-examples.git']]])
		
		//Get some code from Git not GitHub.
		        checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'ssh-jenkins-user', url: 'jenkins@192.168.110.100:/var/lib/jenkins/pipeline-testing']]])
		// Run Gradle on a Unix agent.
		        sh "gradle clean"
		        sh "gradle build"
		}
	}
		
	stage("deploy - uat") {
					steps {
	                                   sh "cp -r build/distributions/*.tar /home/apache-tomcat-8.5.50/webapps/StaPI.tar"
					
	}
		}
		}
   post {
		failure {

		     mail(to: 'madhava.kovelamudi@orbisfn.com', subject: "Build failure for ${env.JOB_NAME}", body: "Project: ${env.JOB_NAME}\nBuild Number: ${env.BUILD_NUMBER}")
		
		}

		// If Gradle was able to run the tests, even if some of the test failed, record the test results and archive the jar file.
		success {

		//junit '**/target/surefire-reports/TEST-*.xml'
		      archiveArtifacts '**/*.tar'
		//All artifacts are stored in master server $JENKINS_HOME/jobs/<job>/builds/<build>/archive and published to jfrog artifactory
			cleanWs()	
		}
		

		}
options {
        buildDiscarder(logRotator(numToKeepStr: '10'))
    }

}

