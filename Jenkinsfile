pipeline {
agent none
stages {
        stage('build') {
		agent{
			docker{
				image 'gradle'
				args '-u 1000'
				}
			}
            steps {
	
       sh 'docker info'

        }
    }
}
}
