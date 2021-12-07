node() {
    echo "Testing the parallel execution in stages"
    sleep 30
    parallel deploy1 : {
        stage('DeployDev') {
            echo "This is deploy dev stage of parallel"
            sleep 20
            echo "Finishing stage 1"
            
        }
    }, deploy: {
        stage('DeployDev2') {
            echo "Starting stage 2"
            echo "This is deploy dev2 stage of parallel execution"
            sleep 10
            echo "Finishing stage 2"
        }
    }
}
