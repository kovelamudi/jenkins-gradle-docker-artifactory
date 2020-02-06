pipeline {

    agent {
	dockerfile
} 

    stages {
        stage('Test') {
            steps {
             sh docker build -t gradle-v1 .
            }
        }
    }
}

