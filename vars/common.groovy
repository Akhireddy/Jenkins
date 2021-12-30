//def sonarQube() {
//  pintIn "Prting sonarqube testing"
//}

def sonarQube() {
  sh 'sonar-scanner -Dsonar.projectKey=${COMPONENT} -Dsonar.sources=. -Dsonar.host.url=http://34.125.133.79:9000/'
}
