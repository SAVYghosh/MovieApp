# Docker Run:
	1. Go to frontend folder and open terminal.
		i. run 
		```
		npm install
		```
		ii. run 
		```
		ng build --prod --base-href
		```
	2. Go to backend folder and open terminal.
		i. run 
		```
		source env.variable.sh
		```
		ii. run 
		``` 
		mvn clean package
		```
	3. go to moviecruiserapp folder and open terminal
		i. run 
		``` 
		docker-compose up
		```
		
	4. open chrome and open "localhost:4200/MovieCruiserAppFront"