
pipeline {

    agent {
	label 'docker-testing'
} 

    stages {
        stage('Test') {
            steps {
             sh docker build -t gradle:v1 .
            }
        }
    }
}

