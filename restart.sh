#!/bin/bash

SHELL_HOME="/home/puppy/code/puppy"
LOG_FILE="${SHELL_HOME}/restart.log"
GRADLEW_LOG_FILE="${SHELL_HOME}/app.log"
touch ${LOG_FILE}
touch ${GRADLEW_LOG_FILE}

source /etc/profile

function log_message(){
    message="$@"
    timestamp=$(date '+%Y-%m-%d %H:%M:%S')
    echo "[${timestamp}] ${message}" | tee -a ${LOG_FILE}
}

function execute_command(){
    command="$@"
    log_message "Execute: ${command}"
    ${command} | tee -a ${LOG_FILE}
    if [ $? != 0 ];then
        log_message "[ERROR] Execute command ${command} failed."
        exit 1
    fi
}

function ps_gradlew(){
    log_message "ps -ef | grep java | grep spring | grep -v grep | grep -v elasticsearch"
    ps -ef | grep java | grep spring | grep -v grep | grep -v elasticsearch | tee -a ${LOG_FILE}

    log_message "ps -ef | grep java | grep gradlew | grep -v grep | grep -v elasticsearch"
    ps -ef | grep java | grep gradlew | grep -v grep | grep -v elasticsearch | tee -a ${LOG_FILE}
}

function kill_gradlew(){
    ps -ef | grep java | grep PuppyApp | grep -v grep | awk '{ print $2 }' | while read vara
    do
        execute_command "kill -9 $vara"
    done

    ps -ef | grep java | grep gradlew | grep -v grep | grep -v elasticsearch | awk '{ print $2 }' | while read vara
    do
        execute_command "kill -9 $vara"
    done
}

function restart_gradlew(){
    ps_gradlew

    log_message "----------------------------------"

    kill_gradlew

    log_message "----------------------------------"

    execute_command "sleep 10"

    log_message "nohup ./gradlew -Pprod -x test --info >${GRADLEW_LOG_FILE} 2>&1 &"
    nohup ./gradlew -Pprod -x test --info >${GRADLEW_LOG_FILE} 2>&1 &

    ps_gradlew
}

log_message "=================================="
restart_gradlew
log_message "=================================="
