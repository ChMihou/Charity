#!/bin/sh
#查询jar包的端口
pidlist=`ps -ef|grep charity-0.0.1-SNAPSHOT.jar|grep -v "grep"|awk '{print $2}'`
#创建kill进程的方法
function stop(){
if [ "$pidlist" == "" ]; then
        echo "----jar 已经关闭----"

else
echo "tomcat进程号 :$pidlist"
kill -9 $pidlist
echo "KILL $pidlist:"
fi
}
#检查执行语句失败  ==eq 执行成功  !=-ne 执行失败
function check_fail(){
        if [ $? -ne 0 ]; then
                echo "ERROR: $1"
                exit 1
        fi
}

#执行方法
stop
#执行检验
check_fail "重启项目失败"
#启动jar包
cd /home/

nohup java -jar charity-0.0.1-SNAPSHOT.jar  > charity.out 2>&1&
~