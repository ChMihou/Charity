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
#执行方法
stop
#启动jar包
cd /home/
nohup java -jar charity-0.0.1-SNAPSHOT.jar  > countyMedia.out 2>&1&
~