pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building application outfit_recommender'
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Test') {
            steps {
                echo 'Running unit tests for outfit_recommender'
                sh 'mvn test'
            }
        }
    }
}
