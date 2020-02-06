pipeline {

    agent {
	label 'docker-testing'
} 

    stages {
        stage('Test') {
            steps {
		script{
             docker.build("gradle-v1", '-f Dockerfile .')
            }
        }
    }
}
}
