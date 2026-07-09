pipeline {
    agent any

    tools {
        maven 'Maven_System'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/amantiwarie/DevopsDemo.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Deploy to Wildfly') {
            steps {
                sh 'cp target/currency-converter.war /opt/wildfly/standalone/deployments/'
            }
        }
    }

    post {
        success {
            emailext (
                subject: "SUCCESS: Build #${env.BUILD_NUMBER} - ${env.JOB_NAME}",
                body: "Good news! Build ${env.BUILD_NUMBER} succeeded.\n\nCheck console: ${env.BUILD_URL}",
                to: 'youremail@example.com'
            )
        }
        failure {
            emailext (
                subject: "FAILED: Build #${env.BUILD_NUMBER} - ${env.JOB_NAME}",
                body: "Build ${env.BUILD_NUMBER} failed.\n\nCheck console: ${env.BUILD_URL}",
                to: 'youremail@example.com'
            )
        }
    }
}pipeline {
     agent any

     tools {
         maven 'Maven_System'
     }

     stages {
         stage('Checkout') {
             steps {
                 git branch: 'main', url: 'https://github.com/amantiwarie/DevopsDemo.git'
             }
         }

         stage('Build') {
             steps {
                 sh 'mvn clean package'
             }
         }

         stage('Deploy to Wildfly') {
             steps {
                 sh 'cp target/currency-converter.war /opt/wildfly/standalone/deployments/'
             }
         }
     }

     post {
         success {
             emailext (
                 subject: "SUCCESS: Build #${env.BUILD_NUMBER} - ${env.JOB_NAME}",
                 body: "Good news! Build ${env.BUILD_NUMBER} succeeded.\n\nCheck console: ${env.BUILD_URL}",
                 to: 'attiwari261@gmail.com'
             )
         }
         failure {
             emailext (
                 subject: "FAILED: Build #${env.BUILD_NUMBER} - ${env.JOB_NAME}",
                 body: "Build ${env.BUILD_NUMBER} failed.\n\nCheck console: ${env.BUILD_URL}",
                 to: 'attiwari261@gmail.com'
             )
         }
     }
 }