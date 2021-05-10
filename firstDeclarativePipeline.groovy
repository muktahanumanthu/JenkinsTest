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
                sh """echo "Building code, branch2"
                echo "Building code, branch1"
                echo "Building code, branchX"
                echo "Building code, branchY"
                echo "Building code, branchZ"
                """
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
                sh """ 
                echo "running in test" 
                echo "running in test2"
                echo "running in test3"
                echo "running in test4" 
                """
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
