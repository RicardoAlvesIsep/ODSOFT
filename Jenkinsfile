pipeline {
    agent any

    stages {
        stage('Set Git Config') {
            steps {
                script {
                    // Set long paths option for Git
                    sh 'git config --global core.longpaths true'
                }
            }
        }

        stage('Checkout') {
            steps {
                // Checkout the repository
                git 'https://github.com/RicardoAlvesIsep/ODSOFT.git'
            }
        }

        stage('Build') {
            steps {
                // Your build steps here
                sh 'mvn clean install'
            }
        }
    }
}
