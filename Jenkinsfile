pipeline {
    agent {
        dockerfile true	
	label 'docker-testing'
    }

    stages {
        stage('Test') {
            steps {
                sh 'node --version'
            }
        }
    }
}

