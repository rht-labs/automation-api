node {
	stage ('Code Checkout') {
		checkout scm
	}

	stage ('Build App') {
		dir( 'build-home-dir' ) {
			echo 'Using build tool: sh'
			sh "customBuildAppCommand"
			sh "customBuildAppCommand with arguments"
		}
	}

	stage ('Build Image and Deploy to Dev') {
		echo 'Found buildImageCommands, executing in shell'
		sh 'customBuildImageCommand'
		sh 'customBuildImageCommand with arguments'
	}

	stage ('Deploy to stage-project') {
		input 'Deploy to stage-project?'
		sh 'customDeployImageCommand'
		sh 'customDeployImageCommand with arguments'
	}

	stage ('Deploy to prod-project') {
		input 'Deploy to prod-project?'
		sh 'customDeployImageCommand'
		sh 'customDeployImageCommand with arguments'
	}
}
