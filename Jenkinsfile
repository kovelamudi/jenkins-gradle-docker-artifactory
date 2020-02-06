pipeline {
agent {label 'docker-testing'}
stages {

stage(build1){

steps{
script {sh 'sudo docker build -t .'}
}
}
        stage('build') {
		agent{
			docker{	
				
				image 'gradle'
				args '-u 1000'
				args '-v /home/orbis/workspace/gradledockerjenkins_UAT:/root/gradledockerjenkins_UAT'
				args '-v /var/run/docker.sock:/var/run/docker.sock'				
				}
			}
            steps {
	
       sh 'docker info'

        }
    }
}
}
