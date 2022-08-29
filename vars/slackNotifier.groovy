def notifySlack(String buildStatus = 'STARTED') {
    // Build status of null means success.
    buildStatus = buildStatus ?: 'SUCCESS'
    def msg = "${buildStatus}: `${env.JOB_NAME}` #${env.BUILD_NUMBER}:\n"
    def color

    if (buildStatus == 'SUCCESS') {
        color = '#00FF00'
    } else if (buildStatus == 'UNSTABLE') {
        color = '#ff0000'
    } else {
        color = '#ff0000'
    }

    if (buildStatus == 'STARTED') {
        slackSend(channel: 'custom_pipelines_alerts', message: msg.concat("") , color: '#0000FF' )
    } else if (buildStatus == 'SUCCESS') {
        slackSend(channel: 'custom_pipelines_alerts', message: msg.concat("Successfully Updated To Desired  Count") , color: color )
    } else if (buildStatus == 'UNSTABLE') {
        slackSend(channel: 'custom_pipelines_alerts', message: msg.concat("Desired  Count Not Updated") , color: color )
    } else {
        slackSend(channel: 'custom_pipelines_alerts', message: msg.concat("Desired  Count Not Updated") , color: '#ff0000' )
    }

    }
