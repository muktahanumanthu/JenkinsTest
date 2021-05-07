pipeline {
    agent any

    stages {
        stage("Build") {
            steps {
                echo "Testing declarative pipeline..."
            }
        }

        stage("Test") {
            steps {
                echo "Executing tests..."
                echo "1"
            }
        }
    }
}

