pipeline {

    agent {
	label 'docker-testing'
} 

    stages {
        stage('build') {
		agent{
			docker{
				image 'gradle'
				args '-u root:sudo'
				}
			}
            steps {
	
       sh 'gradle build'

        }
    }
}
}
