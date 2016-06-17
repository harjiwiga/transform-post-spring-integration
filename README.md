# ADR (Autamatic Data Replication) Standard Chartered Bank Project
==========================

## Introduction
(contains brief explanation of this program, initial and purpose of this program)

This program purposely is integrator program for existing environment in SCB, current file system SCB and Datameer application. This program will called ADR. ADR flow is .sas data will be produced by sas application and will be stored in SCB internal file system, each of these files will be uploaded into Datameer application, because SCB use Datameer for their internal BI. After each data stored into Datameer application, stored data into datameer will be called job later, this ADR will start each job that would be created in Datameer then Datameer will store each file into Hadoop database. Hadoop database will represents with hive in this case.


## System Requirements
(details system requirement, what need to prepare to run this program, what need to download)

Environment Details :
* Linux environment (CentOS, our OS)
* Jdk 1.8
* Maven Installer
* Datameer 5.11.9
* Hadoop 2.6.0 (Hadoop 2.6.0-cdh5.5.1, our environment)
* Hive 1.1.0 (Hive 1.1.0-cdh5.5.1)

Programs Requirement :
* Spring Integration 4.2.x
* Jackson 2.3.x
* log4j 1.2.x
* MySql 5.5.49
* 
*(detail of program requirement in pom.xml)*


## How To Use
(details explanation how to start this program in real environment)

	#### Configuration File

	Main configuration is in *config.properties* and *datameer.properties* file.

	* config.properties
	Config.properties Detail Explanation (if it's not contains here, just used for development only)
	- sas.dir			= source folder
	- skipped.dir		= folder those not include to 'watch' (separates with , if want to add more directory name)
	- source.filename	= soure  file extension type (separates with , if want to add more source filename)
	- datameer.host		= host of datameer application
	- datameer.port 	= port of datameer application
	- datameer.username = username of datameer account, will be used to POST job into Datameer application
	- datameer.password = password of datameer account, will be used to POST job into Datameer application
	- filename.pattern	= pattern for naming handler (separates with , if want to add more filename pattern)

	* datameer.properties
	*contains fixed value of json generator of each .sas file*


	#### Flow How to Run This Program and Check it
    * Define location scb_adr directory, scb_adr directory contains folder target and conf. Add this text below on file .bashrc on root
    	        export SCB_ADR_HOME="/home/<path of location scb_adr dir>"

	* package scb_adr installation using maven (mvn install)
	* java -jar target/scb.jar (run runnable jar)
	* check datameer apps (if before you start 'sasdir' folder contains .sas file it will POST to datameer apps)
	* check hive table (make sure you in right database name, you can check it in config.properties-> datameer.propertiesDatabaseName.export, the table name is uploaded file name with no historical pattern)
	* if you want to try new flow testing just add .sas file(s) from 'filenamedir' folder to 'sasdir' folder then check iteratively from point 1 again.

	* to run scb.jar, use file shell script "start_scb_adr.sh" that contain this script code:
	        cd $SCB_ADR_HOME
            if [ ! -z "$1" ] && [ ! -z "$2" ] && [ ! -z "$3" ] && [ ! -z "$4" ]
             then
                    echo "arg1 value is: $1"
                    echo "arg2 value is: $2"
                    echo "arg3 value is: $3"
                    echo "arg4 value is: $4"
                    java -jar target/scb.jar "$1" "$2" "$3" "$4"
             else
                  echo "Invalid operation. One or more parameter values are not completed."
             fi

    * run the shell script using this command:
            ./start_scb_adr.sh "<country_code>" "<frequency>" "<sequence>" "<abort_on_failure>"
       e.g: ./start_scb_adr.sh "ID" "M" "ALL" "N"
       Make sure all the paremeter values has been completed!



