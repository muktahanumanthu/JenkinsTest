node() {
    echo "Testing the parallel execution in stages"
    
    parallel build : {
        stage('DeployDev') {
            echo "This is deploy dev stage of parallel"
            sleep 20
        }
    }, deploy: {
        stage('DeployDev2') {
            echo "This is deploy dev2 stage of parallel execution"
            sleep 10
        }
    }
}
