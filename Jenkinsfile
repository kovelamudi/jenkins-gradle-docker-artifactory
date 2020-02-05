pipeline {
    agent {
	label 'docker-slave'
} 

    stages {
        stage('Test') {
            steps {
                sh 'docker info'
            }
        }
    }
}

