# Alivee

##Custom Link Shortener Service

[aliv.ee](http://aliv.ee)

----

### Docker explanation
To deploy on docker, go to project's root directory, and run command 'docker-compose up'

Docker postgres will create postgresDbDir on project root to hold it's files.

This can be changed from docker-compose-yml. on volumes '- ./postgresDbDir:/var/lib/postgresql/data'

if any project file changes, you should rebuild docker container. 'docker-compose up --build'

[db-init](./db-init/README.md) directory holds initial postgres db creation scripts.


- CAUTION : do not push postgresDbDir directory to git. (already added on .gitignore)




### TODO's
- DB passwords can be stored on servers environment variables.
- docker postgres directories not tested on windows machine.