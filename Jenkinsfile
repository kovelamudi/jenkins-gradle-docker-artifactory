pipeline {
    agent {
        dockerfile { 
		filename 'Dockerfile.build'
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

