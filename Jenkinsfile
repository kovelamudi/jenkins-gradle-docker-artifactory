pipeline {
agent none
stages {
        stage('build') {
		agent{
			docker{		
				image 'gradle'
				args '-u 1000'
				args '-v /home/orbis/workspace/gradledockerjenkins_UAT:/root/gradledockerjenkins_UAT'				
				}
			}
            steps {
	
       sh 'docker info'

        }
    }
}
}
