node {
    stage("Build") {
        echo "Testing scripted pipeline..."
    }

    stage("Test") {
        echo "Executing tests..."
        echo 1
    }
}

