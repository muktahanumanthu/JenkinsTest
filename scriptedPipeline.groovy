node {
    env.name = "Dev"
    timestamps {
            stage("Build") {
                timeout(time: 1, unit: "MINUTES") {
                    sh 'echo "in build"'
                }
            }
            if (env.name == "Dev") {
                stage("Test") {
                    timeout(time: 2, unit: "MINUTES") {
                        sh 'echo "Running in test"'
                    }
                }
            }
            if (env.name == "Dev") {
                stage("Dev") {
                    timeout(time: 2, unit: "MINUTES") {
                        sh 'echo "Running in dev"'
                    }
                }
            }
    }
}
