pipeline {
    agent any

    options {
        timestamps()
    }
    
    environment{
        env_val = "dev"
    }

    stages {
        stage("Build") {
            options {
                timeout(time: 1, unit: "MINUTES")
            }
            steps {
                sh 'echo "Building code,"'
                sh 'echo "Building code: branch1"'
            }
        }

        stage("Test") {
            when {
                environment name: "env_val", value: "Test"
            }
            options {
                timeout(time: 2, unit: "MINUTES")
            }
            steps {
                sh """ echo "running in test" """
            }
        }
        stage("dev") {
            when {
                environment name: "env_val", value: "dev"
            }
            options {
                timeout(time: 2, unit: "MINUTES")
            }
            steps {
                sh 'echo "running in dev, changes done in branch2"'
            }
        }
    }
}
