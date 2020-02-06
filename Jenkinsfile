node('docker-testing') {
  def gradle = docker.image('gradle:latest')
  gradle.pull() // make sure we have the latest available from Docker Hub
  gradle.inside {
    sh gradle build
  }
}
