pipeline {
    agent {
        dockerfile { 
		filename 'Dockerfile'
		label 'docker-testing'
    }
}
    stages {
        stage('Test') {
            steps {
                sh 'node --version'
            }
        }
    }
}

