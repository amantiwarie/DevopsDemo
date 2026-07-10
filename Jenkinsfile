node {
    stage('Checkout') {
        git branch: 'main', url: 'https://github.com/amantiwarie/DevopsDemo.git'
    }

    stage('Build') {
        withEnv(["PATH+MAVEN=/usr/share/maven/bin"]) {
            sh 'mvn clean package'
        }
    }

    stage('Deploy to Wildfly') {
        sh 'cp target/currency-converter.war /opt/wildfly/standalone/deployments/'
    }
}

if (currentBuild.currentResult == 'SUCCESS') {
    emailext (
            subject: "SUCCESS: Build #${env.BUILD_NUMBER} - ${env.JOB_NAME}",
            body: "Good news! Build ${env.BUILD_NUMBER} succeeded.\n\nCheck console: ${env.BUILD_URL}\n\nFull build log is attached.",
            to: 'attiwari261@gmail.com',
            attachLog: true
    )
} else {
    emailext (
            subject: "FAILED: Build #${env.BUILD_NUMBER} - ${env.JOB_NAME}",
            body: "Build ${env.BUILD_NUMBER} failed.\n\nCheck console: ${env.BUILD_URL}\n\nFull build log is attached for debugging.",
            to: 'attiwari261@gmail.com',
            attachLog: true
    )
}