pipeline {
agent none
stages {
        stage('build') {
		agent{
			docker{
				image 'gradle'
				args '-u root:sudo'
				}
			}
            steps {
	
       sh 'docker info'

        }
    }
}
}
