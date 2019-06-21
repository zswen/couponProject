Merchants调试：

进入如下 folder
cd  /usr/local/Cellar/kafka/2.2.1/libexec


启动 zookeeper。 zookeeper 使用 2181 端口。   -daemon flag 让 zookeeper 运行在后台
bin/zookeeper-server-start.sh  -daemon config/zookeeper.properties


启动 kafka。
bin/kafka-server-start.sh -daemon config/server.properties


创建 topic 和 producer
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic merchants-template
bin/kafka-topics.sh --list --zookeeper localhost:2181
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic merchants-template
在这里，我们可以不用 创建 producer，java application运行时会创建producer

创建 consumer
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic merchants-template --from-beginning# couponProject
