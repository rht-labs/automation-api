node {
	stage ('Code Checkout'){
		checkout scm
	}

	stage ('Build App'){
		echo 'Using build tool: mvn-3'
		def toolHome = tool 'mvn-3'
		env.JAVA_HOME = tool 'java-1.8'
		sh "${toolHome}/bin/mvn clean deploy"
	}

	stage ('Build Image and Deploy to Dev'){
		echo 'Found label "provider=fabric8" or "s2i=binary", we are generating the s2i binary build commands'
		sh 'oc login 10.1.2.2:8443 --token=$OPENSHIFT_API_TOKEN --insecure-skip-tls-verify'
		sh 'oc start-build cool-application-name --from-dir=. --follow -n dev-project'
	}

	stage ('Deploy to stage-project') {
		input 'Deploy to stage-project?'
		openshiftTag apiURL: '10.1.2.2:8443', authToken: $OPENSHIFT_API_TOKEN, destStream: 'cool-application-name', destTag: 'latest', destinationAuthToken: $OPENSHIFT_API_TOKEN, destinationNamespace: 'stage-project', namespace: 'dev-project', srcStream: 'cool-application-name', srcTag: 'latest'
		openshiftVerifyDeployment apiURL: '10.1.2.2:8443', authToken: $OPENSHIFT_API_TOKEN, depCfg: 'cool-application-name', namespace: 'stage-project'
	}

	stage ('Deploy to prod-project') {
		input 'Deploy to prod-project?'
		openshiftTag apiURL: '10.1.2.2:8443', authToken: $OPENSHIFT_API_TOKEN, destStream: 'cool-application-name', destTag: 'latest', destinationAuthToken: $OPENSHIFT_API_TOKEN, destinationNamespace: 'prod-project', namespace: 'stage-project', srcStream: 'cool-application-name', srcTag: 'latest'
		openshiftVerifyDeployment apiURL: '10.1.2.2:8443', authToken: $OPENSHIFT_API_TOKEN, depCfg: 'cool-application-name', namespace: 'prod-project'
	}
}