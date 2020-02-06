pipeline {
agent none
stages {
        stage('build') {
		agent{
			docker{
				args '-u 1000'				
				image 'gradle'
				}
			}
            steps {
	
       sh 'docker info'

        }
    }
}
}
