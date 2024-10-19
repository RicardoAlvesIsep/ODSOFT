pipeline {
    agent any
    
    stages {
        // Stage 1: Checkout code from the 'DiogoMMagalhaes-patch-1' branch
        stage('Checkout') {
            steps {
                git branch: 'DiogoMMagalhaes-patch-1', url: 'https://github.com/RicardoAlvesIsep/ODSOFT.git'
            }
        }

        // Stage 2: Set Git Configuration
        stage('Set Git Config') {
            steps {
                bat 'git config --global core.longpaths true'
            }
        }

        // Stage 3: Build 
        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        // Stage 4: Test 
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
    }
}
