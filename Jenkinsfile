pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building application outfit_recommender'
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                echo 'Running unit tests for outfit_recommender'
                mvn 'test'
            }
        }
    }
}
