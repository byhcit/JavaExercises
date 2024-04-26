package site.redis.distributed_lock;

public class DelayMsgTest {
    public static void main(String[] args) {
        Redis redis = new Redis();
        redis.execute(jedis -> {
            //构造一个消息队列
            DelayQueue queue = new DelayQueue(jedis, "delay_queue");
            //构造消息生产者
            Thread producer = new Thread(() -> {
                for (int i = 0; i < 5; i++) {
                    queue.queue("www.hwali.site===>" + i);
                }
            });
            //构造一个消息消费者
            Thread consumer = new Thread(queue::loop);
            //启动
            producer.start();
            consumer.start();
            //休息 7 秒后，停止程序
            try{
                Thread.sleep(7000);
                consumer.interrupt();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
    }
}
