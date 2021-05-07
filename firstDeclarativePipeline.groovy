pipeline {
    agent any

    options {
        timestamps()
    }

    stages {
        stage("Build") {
            options {
                timeout(time: 10, unit: "SECONDS")
            }
            steps {
                sh ' echo “something” '
                sleep 15
                            }
        }

        stage("Test") {
            options {
                timeout(time: 2, unit: "MINUTES")
            }
            steps {
                sh ' echo “something else” '
            }
        }
    }
}
            
