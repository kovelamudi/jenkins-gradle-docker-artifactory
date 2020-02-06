pipeline {

    agent {
	dockerfile true
} 

    stages {
        stage('Test') {
            steps {
             sh docker build -t gradle-v1 
            }
        }
    }
}

