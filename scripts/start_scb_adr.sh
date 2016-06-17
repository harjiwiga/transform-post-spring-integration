cd $SCB_ADR_HOME
if [ ! -z "$1" ] && [ ! -z "$2" ] && [ ! -z "$3" ] && [ ! -z "$4" ]
 then
	echo "arg1 value is: $1"
	echo "arg2 value is: $2"
	echo "arg3 value is: $3"
	echo "arg4 value is: $4"
        java -jar target/adr.jar "$1" "$2" "$3" "$4"
 else
     echo "Invalid operation. One or more parameter values are not completed."	 
 fi

#cd ~
#./stop_cluster.sh
# sleep 100
#./stop_cdh_nodes.sh
