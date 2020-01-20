import static com.lohika.GlobalConfig.defaults

ef repoUpdate() {
    sh 'helm repo update'
}

def upgrade(String name, String chart = '', String args = '', String cluster = '') {
    def chartName = chart ? chart : "${name}/"
    echo chart
    echo chartName
    if (cluster) {
        def credentialsId = defaults.k8s[cluster.toLowerCase()].credentialsId
        def clusterUrl = defaults.k8s[cluster.toLowerCase()].clusterUrl
        println(credentialsId)
        println(clusterUrl)
        withKubeConfig([credentialsId: credentialsId,
                        serverUrl: clusterUrl]) {
            sh "helm upgrade -i ${name} ${chartName} ${args}"
        }
    } else {
        sh "helm upgrade -i ${name} ${chartName} ${args}"
    }
}