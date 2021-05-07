node {
    timestamps {
            stage("Build") {
                timeout(time: 1, unit: "MINUTES") {
                    sh """ echo “something”
                        """
                }
            }
            stage("Test") {
                timeout(time: 2, unit: "MINUTES") {
                    sh """
                        echo “something else”
                    """
                }
            }
    }
}