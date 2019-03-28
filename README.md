## BTRACE 使用步骤 ##
### 注意点 ###
1. 默认端口2020
-----------------------------
### 脚本编写 ###
+ 根据要植入的项目编写btrace脚本
+ 查看本项目的smaplesbao中的demos
-----------------------------
### linux服务器端部署btrace ###
+ 样例script
  + `mkdir -p btrace`
  + `cd ./btrace`
  + `mkdir btrace-1.3.8`
  + 上传btrace-bin-1.3.8.3.tgz文件到btrace-1.3.8目录下
  + 解压btrace压缩包
  + `tar -zxvf ./btrace-bin-1.3.8.3.tgz`
  + `cd ..`
  + `mkdir script`
  + `export BTRACE_HOME=~/btrace/btrace-1.3.8`
  + `export PATH=$BTRACE_HOME/bin:$PATH:`
+ 执行btrace脚本
  + safe mode: `btrace  $pid Debug.java`
  + unsafe mode: `btrace -u [-cp classPath] $pid Deubg.java`
 -----------------------------
### windows端调试应用 ###
+ 设置btrace环境变量
  + 添加BTRACE_HOME
  + 添加%BTRACE_HOME%到PATH
----------------------------- 
### 参考 ###
  1. [慕课Btrace小结](https://www.imooc.com/article/34563 )
  2. [简书](https://www.jianshu.com/p/dbb3a8b5c92f)
 