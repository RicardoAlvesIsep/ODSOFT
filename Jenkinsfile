pipeline {
    agent any

    stages {
        stage('Set Git Config') {
            steps {
                bat 'git config --global core.longpaths true'
            }
        }

        stage('Checkout') {
            steps {
                git 'https://github.com/RicardoAlvesIsep/ODSOFT.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }
    }
}
