pipeline {
    agent any
    environment {
        NEXUS_VERSION = "nexus3"
        NEXUS_PROTOCOL = "http"
        NEXUS_URL = "localhost:8081"
        NEXUS_REPOSITORY = "maven-snapshots"
        NEXUS_CREDENTIAL_ID = "nexus-anas-credentials"
    }
    stages{
        stage('Compile-package'){
            steps{
                script{
                    sh 'mvn package'
                }
            }
        }
        stage('Sonarqube Analysis'){
            steps{
                script{
                    jacoco()
                    def mvnHome = tool name: 'maven-3', type: 'maven'
                    withSonarQubeEnv('sonar'){
                        sh "${mvnHome}/bin/mvn verify sonar:sonar"
                    }
                }
            }
        }

        stage("Quality Gate") {
            steps {
                timeout(time: 1, unit: 'HOURS') {
                    // Parameter indicates whether to set pipeline to UNSTABLE if Quality Gate fails
                    // true = set pipeline to UNSTABLE, false = don't
                    waitForQualityGate abortPipeline: true
                }
            }
        }

        stage("Deploying jar to Nexus Repository"){
            steps{
                script{
                    nexusPublisher nexusInstanceId: 'nexus', nexusRepositoryId: 'maven-releases', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: '', filePath: './target/kaddem-0.0.1-SNAPSHOT.jar']],mavenCoordinate: [artifactId: 'achat', groupId: 'tn.esprit.spring', packaging: 'jar', version: '1']]]
                }
            }
        }
        stage('Email Notification'){
            steps{
                script{
                    mail bcc: '', body: '''Hi,
                        Welcome to jenkins email alerts.
                        Thanks,
                        Anas''', cc: '', from: '', replyTo: '', subject: 'Jenkins Job', to: 'anasbo7@hotmail.com'
                }
            }
        }
        stage('Slack Notification'){
            steps{
                script{
                    slackSend baseUrl: 'https://hooks.slack.com/services/', channel: '#jenkins-notifications', color: 'good', message: 'Welcome to jenkins notifications channel, legionaries. Sent from Jenkins', teamDomain: 'Legion14', tokenCredentialId: 'slack-channel'
                }
            }
        }
        stage('Build And Deploy Docker Image'){
            steps{
                script{
                    echo "deploying the application"
                    withCredentials([usernamePassword(credentialsId:'dockerhub',usernameVariable:'USER',passwordVariable:'PWD')]) {
                        sh "echo $PWD | docker login -u $USER --password-stdin"
                        sh "docker build -t anasbenouaghrem/kaddem:1.0 ."
                        sh "docker push anasbenouaghrem/kaddem:1.0"
                    }
                }
            }
        }
    }
}