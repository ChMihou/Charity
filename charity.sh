#!/bin/sh
GIT_HOME=https://github.com/ChMihou/Charity.git
JAR_NAME='charity-0.0.1-SNAPSHOT.jar'
BACK_JAR=/home/charity/backjar
JAR_HOME=/home/charity/Charity
HOME=/home/charity
#新建kill进程的方法
function stop(){
#查询jar包的端口
        oldpid=`ps -ef|grep charity-0.0.1-SNAPSHOT.jar|grep -v "grep"|awk '{print $2}'`
        if [ "$oldpid" == "" ]; then
                echo -e "\e[1;31m ----jar 已经关闭---- \e[0m"
        else
                echo -e "\e[1;31m 旧版本信息：  \e[0m"
                echo -e "\e[1;31m tomcat进程号 :$oldpid \e[0m"
                kill -9 $oldpid
                echo -e "\e[1;31m KILL $oldpid: \e[0m"
        fi
}
##拉取项目并构建项目
function build() {
        echo -e "\e[1;31m 开始拉取最新代码  \e[0m"
        cd $JAR_HOME
        git pull $GIT_HOME
        check_fail  "\e[1;31m 拉取失败了 \e[0m"
        echo -e "\e[1;31m 开始编译代码  \e[0m"
        mvn clean install  -Dmaven.test.skip=true
        echo -e "\e[1;31m 编译完成  \e[0m"
}
#代码备份，可以回滚
function back_jar() {
        cd $HOME
        DATE=$(date '+%y_%m_%d_%T')
        if [ -e "$JAR_NAME" ];then
                mv $JAR_NAME $BACK_JAR/${JAR_NAME}.$DATE
                echo -e "\e[1;31m 代码备份完成  \e[0m"
                ln -f $BACK_JAR/${JAR_NAME}.$DATE  $BACK_JAR/charity.jar
        else
                cp $JAR_HOME/target/charity-0.0.1-SNAPSHOT.jar $BACK_JAR/charity.jar
                echo -e "\e[1;31m 第一份备份完成  \e[0m"

        fi

}
#回滚上一个版本库
function rollback(){
        cd $BACK_JAR
        yes|cp charity.jar $HOME/charity-0.0.1-SNAPSHOT.jar
        echo -e "\e[1;31m 回滚上一个版本 \e[0m"
}
#检查执行语句失败  ==eq 执行成功  !=ne 执行失败
function check_fail(){
        if [ $? -ne 0 ]; then
                echo -e "\e[1;31m ERROR: $1 \e[0m"
                exit 1
        fi
}
#移动项目
function move(){
        mv $JAR_HOME/target/charity-0.0.1-SNAPSHOT.jar  $HOME
        check_fail  "\e[1;31m 移动错误 \e[0m "
        echo -e "\e[1;31m 项目移动成功  \e[0m"
}
#启动项目
function start() {
        cd $HOME
        echo -e "\e[1;31m 新版本信息：  \e[0m"
        nohup java -jar $JAR_NAME  > charity.out 2>&1&
        check_fail  "\e[1;31m 重启项目失败 \e[0m "
        #查询jar包的端口
        newpid=`ps -ef|grep charity-0.0.1-SNAPSHOT.jar|grep -v "grep"|awk '{print $2}'`
        echo -e "\e[1;31m tomcat进程号 :$newpid \e[0m"
        echo -e "\e[1;31m 项目启动成功  \e[0m"
}
#主函数
function main(){
        #从git上更新项目
        [ "$1" == "git" ] && stop && build && back_jar && move && start && exit 0
        #回滚上一个版本
        [ "$1" == "rb" ] && stop && rollback && start && exit 0
        #重新启动项目
        stop && start && exit 0
}
main $1
