pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/RicardoAlvesIsep/ODSOFT.git' // Repository URL
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}
