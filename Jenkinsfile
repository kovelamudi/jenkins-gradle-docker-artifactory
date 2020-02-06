pipeline {
agent none
stages {
        stage('build') {
		agent{
			docker{
				args '-u 1000'
				args '-v /home/orbis/workspace/gradledockerjenkins_UAT:/root/gradledockerjenkins_UAT'				
				image 'gradle'
				}
			}
            steps {
	
       sh 'docker info'

        }
    }
}
}
