pipeline {
environment
{
registry = "mosbahhilali/timesheet"
registryCredential= 'dockerHub'
dockerImage = ''
}
agent any
stages {
stage( 'Checkout  GIT' ){
                       steps{
                          echo 'Pulling ... ';
                              git branch:  'main' ,
                              url :'https://github.com/mosbahhilali/Timesheet'
                              }
                    }

            stage("Test,Build"){
               steps{

                   bat "mvn clean install"
                    }

                  }

              stage("package"){
               steps{

                   bat "mvn package"
                    }

                  }
                  
               stage("Sonar"){
               steps{

                   bat "mvn sonar:sonar"
                    }

                  }
                  
                stage("Nexus"){
             steps {
                script {
                   bat "mvn deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=Timesheet-spring-boot-core-data-jpa-mvc-REST-1 -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/Timesheet-spring-boot-core-data-jpa-mvc-REST-1-1.0.jar"
                }
            }
           
       
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
post {
        success {
            emailext body: 'build success', subject: 'jenkins',to: 'mosbah.hilali@esprit.tn'
        }
    failure {
    emailext body: 'build failure', subject: 'jenkins',to: 'mosbah.hilali@esprit.tn'
    }
 
}
}
