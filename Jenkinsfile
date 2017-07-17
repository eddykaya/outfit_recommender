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
        stage('Integration-Test') {
	    steps {
	    	echo 'Running integration tests for outfit_recommender'
                sh 'mvn integration-test -Prun-integration-tests'
	    }
	}
	stage('Build docker file') {
	    steps {
		echo 'Building dockerfile for outfit_recommender'
		sh 'mvn docker:package -Pbuild-docker-image'
            }
	}	
	stage('Deploy Test') {
	    steps {
		echo 'Deploying current build to test environment'
		sh 'curl -f --user mesos_user:${MESOS_PW} -X PUT https://mesos.url/v2/apps/tss/test/outfit_recommender -d @$WORKSPACE/target/mesos_test.json -H "Content-type: application/json'
	    }
	}
        stage('Deploy Prod') {
            steps {
                echo 'Deploying current build to production environment'
                sh 'curl -f --user mesos_user:${MESOS_PW} -X PUT https://mesos.url/v2/apps/tss/production/outfit_recommender -d @$WORKSPACE/target/mesos_prod.json -H "Content-type: application/json'
            }
        }
    }
}
