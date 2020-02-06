pipeline {

    agent {
	label 'docker-testing'
} 

    stages {
        stage('build') {
		agent{
			docker{
				image 'gradle'
				args '-u root:sudo -v $HOME/workspace/gradledockerjenkins_UAT:/gradledockerjenkins_UAT'
				}
			}
            steps {
	
       sh 'gradle build'

        }
    }
}
}
