pipeline {

def app

    agent {
	label 'docker-testing'
} 

    stages {
        stage('Test') {
            steps {
                app = docker.build("kovelamudi/gradle")
            }
        }
    }
}

