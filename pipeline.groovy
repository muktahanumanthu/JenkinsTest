import groovy.*

if (main() == "SUCCESS"){
    echo("Main Success")
} else {
    echo("Main Failure")
    currentBuild.result = "UNSTABLE"
    return
}


def main() {
    def retVal = "SUCCESS"
	try {
		node {
			echo("Starting the pipeline")
			stage('Checkout the code') {

                
                echo("Options ::")
                echo("Branch for code checkout : $env.BRANCH_NAME")

				echo("Checking out the code")
				gitCheckout("your git URL", env.BRANCH_NAME)
                
                // Check if version already exisits
				}


	}
		
	} catch (Exception ex) {
		echo("an exception while execution", ex)
		retVal = "FAILURE"
	}
	return retVal
}


// Functions

// Functions
def gitCheckout(def gitURL, def gitBranch){

    checkout changelog: false, poll: false, scm: [
        $class: 'GitSCM',
        branches: [[name: gitBranch]],
        doGenerateSubmoduleConfigurations: false,
        submoduleCfg: [],
        userRemoteConfigs: [
            [
                credentialsId: 'adityy_github',
                url: "${gitURL}"
            ]
        ]
    ]
}
