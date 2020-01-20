def test() {
    sh 'go test -v 2>&1 | go-junit-report > report.xml'
}