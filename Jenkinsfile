/* groovylint-disable-next-line CompileStatic */
pipeline {
        agent any
        stages {
            stage('Checkout') {
                steps {
                    deleteDir()
                    checkout scm
                }
            }

        stage('Build') {
                steps {
                    sh 'mvn clean verify -s settings.xml'
                    }
        }

        stage('Publish Results') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                junit 'target/surefire-reports/*.xml'
                jacoco execPattern: 'target/*.exec'
            }
        }

        stage('Deployment') {
                steps {
                sh 'ls -la'
                }
        }
        }

            post {
                always {
            emailext(
                            subject: 'Status of the Spring Demo Pipeline',
                            body: 'New Email',
                            // recipientProviders: [[$class: 'DevelopersRecipientProvider']],
                            to: 'ashsy009@gmail.com',
                            /* groovylint-disable-next-line DuplicateStringLiteral */
                            replyTo: 'ashsy009@gmail.com'
                    )
                }
            }
}
