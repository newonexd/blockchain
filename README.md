# blockchain_learn
目前在学习区块链的共识机制 **POW RAFT** POA etc,并尝试使用JAVA代码实现

>entity包暂时还没有用到，就没有完成它，主要是一些实体类。 \
>pow包中是POW共识算法，还有一点不太明白的地方没有完全实现。 \
>raft包中实现了raft算法，目前只完成了第一阶段LEADER选举(有一点小瑕疵) 日志复制也写了只不过还没有完成测试
>>REntry.java是整个raft算法的入口类 \
>>entity包中是定义了一些实体与常量。\
>>net包中则是网络通信 \
>>process包是消息处理流程 \
>>timer:包是计时器 \
>util包则是一些工具，只添加了目前用到的.\
>reources包下的raft.txt写了整个算法的流程，还在不断完善中.......


>build.sh是启动RAFT的脚本文件，包括MAVEN打包，DOCKER容器的创建，网络的启动。只需要执行这个文件就可以了 \
>clean.sh是清除之前的运行环境。 \
>docker-compose-Rnode.yaml是定义了节点启动需要的信息. 
