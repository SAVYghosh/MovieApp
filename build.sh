cd authenticationapp
source ./env-variable.sh
mvn clean package
cd ..
cd moviecruiserapp
source ./env-variable.sh
mvn clean package
cd ..