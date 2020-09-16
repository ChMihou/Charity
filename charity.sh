#!/bin/sh
GIT_HOME=https://github.com/ChMihou/Charity.git
JAR_NAME='charity.jar'
DATE=$(date '+%y_%m_%d_%T')
BACK_JAR=/home/charity/back_jar
JAR_HOME=/home/charity
#创建kill进程的方法
function stop(){
#查询jar包的端口
pidlist=`ps -ef|grep charity-0.0.1-SNAPSHOT.jar|grep -v "grep"|awk '{print $2}'`
    if [ "$pidlist" == "" ]; then
        echo "----jar 已经关闭----"

    else
        echo "tomcat进程号 :$pidlist"
        kill -9 $pidlist
        echo "KILL $pidlist:"
    fi
}
##拉取项目并构建项目
function build() {
    echo -e "\e[1;31m 开始拉取最新代码  \e[0m"
    cd $JAR_HOME
    git pull $GIT_HOME
    check_fail "拉取失败了"
    echo -e "\e[1;31m 开始编译代码  \e[0m"
    mvn clean install -Dmaven.test.skip=true
    echo -e "\e[1;31m 编译完成  \e[0m"
}

function back_jar() {
    cd $BACK_JAR
    if [ -e "$JAR_NAME" ];then
        mv $JAR_NAME $BACK_JAR/${JAR_NAME}.$DATE
        rm -rf $JAR_NAME
        echo -e "\e[1;31m 代码备份完成  \e[0m"
    else
        echo -e "\e[1;31m 原文件不存在，直接下一步  \e[0m"
    fi

}

#检查执行语句失败  ==eq 执行成功  !=ne 执行失败
function check_fail(){
        if [ $? -ne 0 ]; then
                echo "ERROR: $1"
                exit 1
        fi
}

function start() {
    mv /home/charity/Charity/target/charity.jar $JAR_HOME
    cd $JAR_HOME
    nohup java -jar charity.jar  > charity.out 2>&1&
    check_fail "重启项目失败"
    echo -e "\e[1;31m 项目启动成功  \e[0m"
}

#执行方法
stop && build && back_jar && start && exit 0


