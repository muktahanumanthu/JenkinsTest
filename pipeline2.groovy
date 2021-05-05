import groovy.*

def num = params.number
print(num)

def BRANCH_NAME = params.BRANCH_NAME


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
				gitCheckout("https://github.com/muktahanumanthu/JenkinsTest.git", params.BRANCH_NAME)
                
                // Check if version already exisits
				}
            stage('Build') {
		echo "${params.number}"    
                sh """
		ls -lrt
		chmod 755 build.sh
                ./build.sh ${params.number}
                """
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
                credentialsId: '37263308-b4a6-4327-8c72-ef8f4d969b46',
                url: "${gitURL}"
            ]
        ]
    ]
}
