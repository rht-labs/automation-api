#!/usr/bin/groovy

/**
    this section of the pipeline executes on the master, which has a lot of useful variables that we can leverage to configure our pipeline
**/
node (''){
    echo sh(script: 'env|sort', returnStdout: true)
}

node ('mvn-build-pod'){
    echo sh(script: 'env|sort', returnStdout: true)
}
