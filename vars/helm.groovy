def repoUpdate() {
    sh 'helm repo update'
}

def upgrade(String name, String chart = '', String args = '', cfg = [:]) {
    def chartName = chart ? chart : "${name}/"

    if (cfg) {
        echo "Config is not empty"
        withKubeConfig([credentialsId: cfg.credentialsId, serverUrl: cfg.clusterUrl]) {
            sh "helm upgrade -i ${name} ${chartName} ${args}"
        }
    } else {
        sh "helm upgrade -i ${name} ${chartName} ${args}"
    }
}