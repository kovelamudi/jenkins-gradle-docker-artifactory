
pipeline {

    agent {
	label 'docker-testing'
} 

    stages {
        stage('Test') {
            steps {
                docker.build("kovelamudi/gradle", '-f ./Dockerfile .')
            }
        }
    }
}

