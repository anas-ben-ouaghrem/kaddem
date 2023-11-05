pipeline {
    agent any
    environment {
        NEXUS_VERSION = "nexus3"
        NEXUS_PROTOCOL = "http"
        NEXUS_URL = "192.168.1.13:8081"
        NEXUS_REPOSITORY = "maven-snapshots"
        NEXUS_CREDENTIAL_ID = "nexus-credentials"
    }
    stages {
        stage('Building') {
            steps {
                script {
                    sh 'mvn clean compile'
                }
            }
        }

        stage('Unit Testing') {
            steps {
                script {
                    sh 'mvn test'
                }
            }
            post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
        stage('Sonarqube Analysis') {
            steps {
                script {
                    jacoco()
                    def mvnHome = tool name: 'maven-3', type: 'maven'
                    withSonarQubeEnv('sonar') {
                        sh "${mvnHome}/bin/mvn verify sonar:sonar"
                    }
                }
            }
        }

        stage("Quality Gate") {
            steps {
                script {
                    sleep(10)
                    timeout(time: 1, unit: 'HOURS') {
                        def qg = waitForQualityGate() // Reuse taskId previously collected by withSonarQubeEnv
                        if (qg.status != 'OK') {
                            error "Pipeline aborted due to quality gate failure: ${qg.status}"
                        }
                    }
                }
            }
        }

        stage('Building jar') {
            steps {
                script {
                    def mvnHome = tool name: 'maven-3', type: 'maven'
                    sh "${mvnHome}/bin/mvn clean package"
                }
            }
        }

        stage("Deploying jar to Nexus Repository") {
            steps {
                script {
                    script {
                        def mvnHome = tool name: 'maven-3', type: 'maven'
                        def groupId = 'tn.esprit' // Replace with your project's group ID
                        def artifactId = 'kaddem' // Replace with your project's artifact ID
                        def version = '0.0.1-SNAPSHOT' // Replace with the version of your artifact
                        def packaging = 'jar' // Replace with the packaging type if different

                        sh """
                ${mvnHome}/bin/mvn deploy
                -Durl=${env.NEXUS_PROTOCOL}://${env.NEXUS_URL}/repository/${env.NEXUS_REPOSITORY}/
                -DrepositoryId=${env.NEXUS_REPOSITORY}
                -DgroupId=${groupId}
                -DartifactId=${artifactId}
                -Dversion=${version}
                -Dpackaging=${packaging}
                -Dfile=target/${artifactId}-${version}.${packaging}
            """
                    }
                }
            }
        }
        stage('Email Notification') {
            steps {
                script {
                    mail bcc: '', body: '''Hi,
                        Welcome to jenkins email alerts.
                        Thanks,
                        Anas''', cc: '', from: '', replyTo: '', subject: 'Jenkins Job', to: 'anasbo7@hotmail.com'
                }
            }
        }
        stage('Slack Notification') {
            steps {
                script {
                    slackSend baseUrl: 'https://hooks.slack.com/services/', channel: '#jenkins-notifications', color: 'good', message: 'Welcome to jenkins notifications channel, legionaries. Sent from Jenkins', teamDomain: 'Legion14', tokenCredentialId: 'slack-channel'
                }
            }
        }
        stage('Build And Deploy Docker Image') {
            steps {
                script {
                    echo "deploying the application"
                    withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'USER', passwordVariable: 'PWD')]) {
                        sh "echo $PWD | docker login -u $USER --password-stdin"
                        sh "docker build -t anasbenouaghrem/kaddem:1.0 ."
                        sh "docker push anasbenouaghrem/kaddem:1.0"
                    }
                }
            }
        }
    }
}