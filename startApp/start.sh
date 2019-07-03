#!/usr/bin/env bash
# 找到projectfiling的端口号
pid=`jps -l |grep staging |awk '{printf $1}'`

#打印端口号
echo $pid

#判断是否有这个进程 有就kill
if [  -n  "$pid"  ];  then
    kill  -9  $pid;
   echo '进程已关闭'
fi

echo '开始启动 staging'

#启动
nohup java -jar ./staging-0.0.1-SNAPSHOT.jar --spring.profiles.active=test &