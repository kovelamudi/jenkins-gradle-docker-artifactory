pipeline {

    agent {
	label 'docker-testing'
} 

    stages {
        stage('build') {
		agent{
			docker{
				image 'gradle'
				}
			}
            steps {
	
       sh 'gradle build'

        }
    }
}
}
