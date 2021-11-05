pipeline {
environment
{
registry = "mosbahhilali/timesheet"
registryCredential= 'dockerHub'
dockerImage = ''
}
agent any
stages {
stage('Cloning our Git') {
steps { git branch: 'main', url: 'https://github.com/mosbahhilali/Timesheet.git' }
}
stage('Building our image') {
steps { script { dockerImage= docker.build registry + ":$BUILD_NUMBER" } }
}
stage('Deploy our image') {
steps { script { docker.withRegistry( '', registryCredential) { dockerImage.push() } } }
}
stage('Cleaning up') {
steps { bat "docker rmi $registry:$BUILD_NUMBER" }
}

}
}
